package com.xinwen.demo.node02.consumer;


import com.xinwen.demo.node01.sdk.entity.PoJo;
import com.xinwen.demo.node02.sdk.GreetingServiceAsync;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2025/1/13 11:20
 */
public class ApiConsumerForProviderAsync {
    public static void main(String[]args) throws InterruptedException {
        //创建引用实例，并进行设置
        ReferenceConfig<GreetingServiceAsync> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("second-dubbo-consumer"));
        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        referenceConfig.setInterface(GreetingServiceAsync.class);
        //referenceConfig.setAsync(true);
        referenceConfig.setTimeout(50000);
        //referenceConfig.setCluster("myCluster");
        referenceConfig.setVersion("1.0.1");
        referenceConfig.setGroup("dubbo2");

        //服务引用
        GreetingServiceAsync greetingServiceAsync = referenceConfig.get();

        //设置隐式参数
        RpcContext.getContext().setAttachment("company","alibaba");
        //RpcContext.getContext().set("ip","127.0.0.1");




        //4.设置future并回调
        CompletableFuture<PoJo> future = greetingServiceAsync.sayHello("hello-word");
        future.whenComplete((v,k)->{
            if(k !=null){
                System.out.println("异常：v:"+v+"k:"+k);
                k.printStackTrace();
            }else {
                System.out.println(v);
            }
        });
        Thread.currentThread().join();
    }
}
