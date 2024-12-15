package com.xinwen.thread.pool.channel;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * @author shenlx
 * @description
 * @date 2024/2/5 9:50
 */
public interface TCPProtocol {
    void handleAccept(SelectionKey key)throws IOException;

    void handlerRead(SelectionKey key)throws IOException;

    void handlerWrite(SelectionKey key)throws IOException;
}
