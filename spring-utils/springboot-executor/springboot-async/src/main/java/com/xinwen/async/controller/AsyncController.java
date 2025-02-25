package com.xinwen.async.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author shenlx
 * @description
 * @date 2025/1/2 16:47
 */
@Controller
@Slf4j
public class AsyncController {
    @RequestMapping(value = "/email/servletReq", method = GET)
    public void servletReq (HttpServletRequest request, HttpServletResponse response) {
        AsyncContext asyncContext = request.startAsync();
        //设置监听器:可设置其开始、完成、异常、超时等事件的回调处理
        asyncContext.addListener(new AsyncListener() {
            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                System.out.println("超时了...");
                //做一些超时后的相关操作...
            }
            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                System.out.println("线程开始");
            }
            @Override
            public void onError(AsyncEvent event) throws IOException {
                System.out.println("发生错误："+event.getThrowable());
            }
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                System.out.println("执行完成");
                //这里可以做一些清理资源的操作...
            }
        });
        //设置超时时间
        asyncContext.setTimeout(20000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    System.out.println("内部线程：" + Thread.currentThread().getName());
                    asyncContext.getResponse().setCharacterEncoding("utf-8");
                    asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
                    asyncContext.getResponse().getWriter().println("这是异步的请求返回");
                } catch (Exception e) {
                    System.out.println("异常："+e);
                }
                //异步请求完成通知
                //此时整个请求才完成
                asyncContext.complete();
            }
        });
        //此时之类 request的线程连接已经释放了
        System.out.println("主线程：" + Thread.currentThread().getName());
    }

    @RequestMapping(value = "/email/callableReq", method = GET)
    @ResponseBody
    public Callable<String> callableReq () {
        System.out.println("外部线程：" + Thread.currentThread().getName());

        return new Callable<String>() {

            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                System.out.println("内部线程：" + Thread.currentThread().getName());
                return "callable!";
            }
        };
    }

    @RequestMapping(value = "/email/webAsyncReq", method = GET)
    @ResponseBody
    public WebAsyncTask<String> webAsyncReq () {
        System.out.println("外部线程：" + Thread.currentThread().getName());
        Callable<String> result = () -> {
            System.out.println("内部线程开始：" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (Exception e) {
                // TODO: handle exception
            }
            log.info("副线程返回");
            System.out.println("内部线程返回：" + Thread.currentThread().getName());
            return "success";
        };
        WebAsyncTask<String> wat = new WebAsyncTask<String>(3000L, result);
        wat.onTimeout(new Callable<String>() {

            @Override
            public String call() throws Exception {
                // TODO Auto-generated method stub
                return "超时";
            }
        });
        return wat;
    }

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @RequestMapping(value = "/email/deferredResultReq", method = GET)
    @ResponseBody
    public DeferredResult<String> deferredResultReq () {
        System.out.println("外部线程：" + Thread.currentThread().getName());
        //设置超时时间
        DeferredResult<String> result = new DeferredResult<String>(60*1000L);
        //处理超时事件 采用委托机制
        result.onTimeout(new Runnable() {

            @Override
            public void run() {
                System.out.println("DeferredResult超时");
                result.setResult("超时了!");
            }
        });
        result.onCompletion(new Runnable() {

            @Override
            public void run() {
                //完成后
                System.out.println("调用完成");
            }
        });
        threadPoolTaskExecutor.execute(new Runnable() {

            @Override
            public void run() {
                //处理业务逻辑
                System.out.println("内部线程：" + Thread.currentThread().getName());
                //返回结果
                result.setResult("DeferredResult!!");
            }
        });
        return result;
    }





        //获取ApplicationContext对象方式有多种,这种最简单,其它的大家自行了解一下
        @Autowired
        private ApplicationContext applicationContext;

        @RequestMapping(value = "/email/asyncCall", method = GET)
        @ResponseBody
        public Map<String, Object> asyncCall () {
            Map<String, Object> resMap = new HashMap<String, Object>();
            try{
                //这样调用同类下的异步方法是不起作用的
                //this.testAsyncTask();
                //通过上下文获取自己的代理对象调用异步方法
                AsyncController emailController = applicationContext.getBean(AsyncController.class);
                emailController.testAsyncTask();
                resMap.put("code",200);
            }catch (Exception e) {
                resMap.put("code",400);
                log.error("error!",e);
            }
            return resMap;
        }

        //注意一定是public,且是非static方法
        @Async
        public void testAsyncTask() throws InterruptedException {
            Thread.sleep(10000);
            System.out.println("异步任务执行完成！");
        }


}
