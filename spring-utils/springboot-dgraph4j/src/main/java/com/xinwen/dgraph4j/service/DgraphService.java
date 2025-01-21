package com.xinwen.dgraph4j.service;

import cn.hutool.json.JSONUtil;
import com.google.protobuf.ByteString;
import com.xinwen.dgraph4j.entity.Follows;
import com.xinwen.dgraph4j.entity.User;

import io.dgraph.DgraphClient;
import io.dgraph.DgraphProto;
import io.dgraph.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenlx
 * @description
 * @date 2025/2/14 15:28
 */
@Service
@Slf4j
public class DgraphService {

    @Autowired
    private DgraphClient dgraphClient;

    public void addFollows(Follows follows) {
        Transaction txn = dgraphClient.newTransaction();

        try {

            String query = "query {\n" +
                    "from as var(func: eq(name, \"" + follows.getFromUid() + "\"))\n" +
                    "to as var(func: eq(name, \"" + follows.getToUid() + "\"))\n" +
                    "}\n";
            String nquad = "{{uid(from)}} <follows> {{uid(to)}} .";
            DgraphProto.Mutation mu = DgraphProto.Mutation.newBuilder()
                    .setSetNquads(ByteString.copyFromUtf8(nquad))
                    .build();

            DgraphProto.Request request = DgraphProto.Request.newBuilder()
                    .setQuery(query)
                    .addMutations(mu)
                    .setCommitNow(true)
                    .build();

            txn.doRequest(request);

            System.out.println("Added follows relationship from " + follows.getFromUid() + " to " + follows.getToUid());
        } finally {
            if (txn != null) {
                txn.discard();
            }
        }
    }

    public String getFollowers(String userName) throws Exception {
        Transaction txn = dgraphClient.newTransaction();
        try {
            String query = "{\n" +
                    "followers(func: has(name), orderasc: name) {\n" +
                    "   name\n" +
                    "   ~follows @filter(eq(name, \"" + userName + "\")) {\n" +
                    "      name\n" +
                    "   }\n" +
                    "}\n" +
                    "}";

            DgraphProto.Response res = txn.query(query);
            txn.discard();

            return res.getJson().toStringUtf8();
        } catch (Exception e) {
            if (txn != null) {
                txn.discard();
            }
            throw e;
        }
    }

    public void addUser(User user) {
        Transaction txn = dgraphClient.newTransaction();

        try {
            Map<String, Object> node = new HashMap<>();
            node.put("uid", "_:" + user.getName());
            node.put("name", DgraphProto.Value.newBuilder().setStrVal(user.getName()).build());
            node.put("email", DgraphProto.Value.newBuilder().setStrVal(user.getEmail()).build());

            DgraphProto.Mutation mu = DgraphProto.Mutation.newBuilder()
                    .setSetJson(ByteString.copyFromUtf8(JSONUtil.toJsonStr(node)))
                    .build();

            DgraphProto.Response response = txn.mutate(mu);

            txn.commit();
            log.warn("Added User:{}", user.getName());


        } finally {
            if (txn != null) {
                txn.discard();
            }
        }
    }
}
