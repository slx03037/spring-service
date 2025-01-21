package com.xinwen.dgraph4j.config;

import io.dgraph.DgraphClient;
import io.dgraph.DgraphGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenlx
 * @description
 * @date 2025/2/14 15:19
 */
@Configuration
public class DgraphConfig {

    @Bean
    public DgraphClient dgraphClient() {
        List<DgraphGrpc.DgraphStub> list = new ArrayList<>();

        list.add(DgraphGrpc
                .newStub(io.grpc.ManagedChannelBuilder
                        .forAddress("localhost", 9080)
                        .usePlaintext()
                        .build()));
        DgraphGrpc.DgraphStub[] arr = (DgraphGrpc.DgraphStub[]) list.toArray();
        return new DgraphClient(arr);

    }
}
