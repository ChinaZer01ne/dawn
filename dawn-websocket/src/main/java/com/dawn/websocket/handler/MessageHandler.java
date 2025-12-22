package com.dawn.websocket.handler;

import com.dawn.websocket.message.WsMessage;
import org.springframework.web.socket.WebSocketSession;

public interface MessageHandler {
    /**
     * 判断消息类型是否能处理
     *
     * @param messageType :
     * @return boolean
     */
    boolean canHandle(String messageType);
    /**
     * 消息处理方法
     *
     * @param session :
     * @param message :
     */
    void handle(WebSocketSession session, WsMessage<?> message);
}