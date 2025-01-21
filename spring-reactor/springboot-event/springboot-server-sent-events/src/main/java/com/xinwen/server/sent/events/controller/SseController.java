package com.xinwen.server.sent.events.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author shenlx
 * @description
 * @date 2025/1/22 12:23
 */
@CrossOrigin
@RestController
@RequestMapping("sse")
public class SseController {

    @GetMapping("/handleSse")
    public SseEmitter handleSse(){
        SseEmitter emitter=new SseEmitter();
        CompletableFuture.runAsync(()->{
           try{
               for(int i=0;i<10;i++){
                   emitter.send(SseEmitter.event().name("message").data("SSE Event #"+ i));
                   Thread.sleep(1000);
               }
           } catch (IOException | InterruptedException e) {
               emitter.completeWithError(e);
           }
        });
        return emitter;
    }
}
