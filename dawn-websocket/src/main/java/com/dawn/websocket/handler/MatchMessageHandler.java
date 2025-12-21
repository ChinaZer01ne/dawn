package com.dawn.websocket.handler;

import com.dawn.websocket.enums.MessageTypeEnum;
import com.dawn.websocket.message.WsMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Objects;

/**
 * 匹配消息处理器
 *
 * @author peach
 * @since 2025/12/21 22:23
 */
@Component
public class MatchMessageHandler implements MessageHandler {
    
    @Override
    public boolean canHandle(String type) {
        return Objects.equals(type, MessageTypeEnum.MATCH_REQUEST);
    }
    
    @Override
    public void handle(WebSocketSession session, WsMessage message) {
        //MatchRequest request = (MatchRequest) message.getData();
        // 处理匹配请求...
    }
}