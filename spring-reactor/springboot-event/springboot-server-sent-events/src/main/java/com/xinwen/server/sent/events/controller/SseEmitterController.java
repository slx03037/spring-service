package com.xinwen.server.sent.events.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shenlx
 * @description
 * @date 2025/3/3 16:27
 */
@RestController
public class SseEmitterController {
    private static final Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();

    @CrossOrigin(origins = "*")
    @GetMapping("/events/{userId}")
    public SseEmitter stream(@PathVariable String userId) throws IOException {
        sseCache.put(userId,new SseEmitter(10 * 60 * 1000L));
        SseEmitter emitter = sseCache.get(userId);
        Map<String,String> map = new HashMap<>();
        map.put("id", userId);
        map.put("content", "连接成功");
        emitter.send(map);
        return emitter;
    }

    @GetMapping("/sendMessage/{userId}")
    public String sendMessage(@PathVariable String userId,
                              @RequestParam(name = "message", required = false) String message) throws IOException {
        SseEmitter emitter = sseCache.get(userId);
        Map<String,String> map = new HashMap<>();
        map.put("id", userId);
        map.put("content", message);
        emitter.send(map);
        return "成功";
    }

    @GetMapping("/close/{userId}")
    public String close(@PathVariable String userId
    ) throws IOException {
        SseEmitter emitter = sseCache.get(userId);
        emitter.complete();
        return "成功";
    }
}
