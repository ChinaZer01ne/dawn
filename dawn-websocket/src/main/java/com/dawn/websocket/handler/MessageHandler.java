package com.dawn.websocket.handler;

import com.dawn.websocket.message.MessageType;
import com.dawn.websocket.message.WsMessage;
import org.springframework.web.socket.WebSocketSession;

public interface MessageHandler {
    boolean canHandle(String messageType);
    void handle(WebSocketSession session, WsMessage message);
}