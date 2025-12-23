package com.dawn.websocket.handler;

import com.dawn.chaos.service.MatchService;
import com.dawn.websocket.enums.MessageTypeEnum;
import com.dawn.websocket.message.WsMessage;
import com.dawn.websocket.utiils.WebSocketUtils;
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
public class MatchCancelHandler implements MessageHandler {

    @Resource
    private MatchService  matchService;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void handle(WebSocketSession session, WsMessage<?> message) {
        try {
            matchService.matchCancel();
        } catch (Exception e) {
            log.error(e.getMessage());
            WebSocketUtils.sendMessage(session, e.getMessage());
        }
    }

    @Override
    public boolean canHandle(String type) {
        return Objects.equals(type, MessageTypeEnum.MATCH_CANCEL.getType());
    }

}