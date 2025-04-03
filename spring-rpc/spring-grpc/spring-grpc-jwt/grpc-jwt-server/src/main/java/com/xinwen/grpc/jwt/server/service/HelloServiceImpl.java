package com.xinwen.grpc.jwt.server.service;

import com.google.protobuf.StringValue;
import com.xinwen.grpc.jwt.api.HelloServiceGrpc;
import com.xinwen.grpc.jwt.common.AuthConstant;
import org.springframework.stereotype.Component;

/**
 * @author shenlx
 * @description
 * @date 2025/3/31 16:59
 */
@Component
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(com.google.protobuf.StringValue request,
                         io.grpc.stub.StreamObserver<com.google.protobuf.StringValue> responseObserver) {
        String clientId = AuthConstant.AUTH_CLIENT_ID.get();
        responseObserver.onNext(StringValue.newBuilder().setValue(clientId + " say hello:" + request.getValue()).build());
        responseObserver.onCompleted();
    }
}
