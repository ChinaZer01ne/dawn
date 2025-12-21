package com.dawn.websocket.handler;

import com.dawn.websocket.message.MessageType;
import com.dawn.websocket.message.WsMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Objects;

// 业务模块实现接口
@Component
public class MatchMessageHandler implements MessageHandler {
    
    @Override
    public boolean canHandle(String type) {
        return Objects.equals(type, MessageType.MATCH_REQUEST);
    }
    
    @Override
    public void handle(WebSocketSession session, WsMessage message) {
        //MatchRequest request = (MatchRequest) message.getData();
        // 处理匹配请求...
    }
}