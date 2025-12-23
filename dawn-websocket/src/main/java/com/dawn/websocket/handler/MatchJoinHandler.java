package com.dawn.websocket.handler;

import com.dawn.chaos.service.MatchService;
import com.dawn.websocket.enums.MessageTypeEnum;
import com.dawn.websocket.message.WsMessage;
import com.dawn.chaos.request.MatchJoinRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Objects;

/**
 * 匹配消息处理器
 *
 * @author peach
 * @since 2025/12/21 22:23
 */
@Slf4j
@Component
public class MatchJoinHandler implements MessageHandler {

    @Resource
    private MatchService  matchService;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void handle(WebSocketSession session, WsMessage<?> message) {
        Long userId = 1L;
        // 处理匹配请求...
        MatchJoinRequest request = objectMapper.convertValue(message.getData(), MatchJoinRequest.class);
        matchService.matchJoin(userId, request);
    }

    @Override
    public boolean canHandle(String type) {
        return Objects.equals(type, MessageTypeEnum.MATCH_REQUEST.getType());
    }

}