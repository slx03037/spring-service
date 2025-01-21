package com.xinwen.websocket.javax.client.controller;

import com.xinwen.websocket.javax.client.service.JavaxWebSocketClientEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author shenlx
 * @description
 * @date 2025/2/27 12:02
 */
@RestController
public class ClientController {
    @GetMapping("/sendToServer")
    public void websocket1(@RequestParam("message") String message) throws IOException {
        new JavaxWebSocketClientEndpoint().sendMessage(message);
    }
}
