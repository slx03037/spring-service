package com.xinwen.demo.node04.sdk.service.impl;





import com.xinwen.demo.node04.sdk.model.Result;
import com.xinwen.demo.node04.sdk.entity.PoJo;
import com.xinwen.demo.node04.sdk.service.GreetingService;
import org.apache.dubbo.common.json.JSON;
import org.apache.dubbo.rpc.RpcContext;

import java.io.IOException;

/**
 * @author shenlx
 * @description
 * @date 2025/1/7 17:27
 */
public class GreetingServiceimpl  implements GreetingService {
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Hello:%s-%s%n", name, RpcContext.getContext().getAttachment("company"));
        return String.format("Hello:%s-%s", name, RpcContext.getContext().getAttachment("company"));
    }
    @Override
    public Result<String> testGeneric(PoJo poJo) {
        Result<String> result = new Result<String> ();

        result.setSucess (true) ;

        try {
            result.setData(JSON.json(poJo));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("result:%s%n",result);
        return result;
    }
}
