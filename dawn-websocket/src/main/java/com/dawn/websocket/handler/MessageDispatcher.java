package com.dawn.websocket.handler;

import com.dawn.websocket.message.WsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息分发器
 *
 * @author peach
 * @since 2025/12/20 00:08
 */
@Component
public class MessageDispatcher {
    
    private List<MessageHandler> handlers = new ArrayList<>();
    
    @Autowired
    public void setHandlers(List<MessageHandler> handlers) {
        this.handlers = handlers;
    }
    
    public void dispatch(WebSocketSession session, WsMessage<?> message) {
        for (MessageHandler handler : handlers) {
            if (handler.canHandle(message.getType())) {
                handler.handle(session, message);
                break;
            }
        }
    }
}