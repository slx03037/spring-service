package com.xinwen.websocket.javax.client;

import com.xinwen.websocket.javax.client.service.JavaxWebSocketClientEndpoint;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * @author shenlx
 * @description
 * @date 2025/2/27 11:39
 */
@SpringBootTest
public class ApplicationTest {

//    @Autowired
//    private JavaxWebSocketClientEndpoint clientEndpoint;

    @Test
    public void testMethod() throws IOException {
        String message="hello word";
        new JavaxWebSocketClientEndpoint().sendMessage(message);
        //clientEndpoint.onMessage(message);
    }
}
