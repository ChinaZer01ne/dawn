package com.dawn.websocket.handler;

import com.dawn.chaos.service.AnswerService;
import com.dawn.chaos.service.MatchService;
import com.dawn.websocket.enums.MessageTypeEnum;
import com.dawn.websocket.message.WsMessage;
import com.dawn.websocket.request.AnswerRequest;
import com.dawn.websocket.request.MatchRequest;
import com.dawn.websocket.utiils.WebSocketUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Objects;

/**
 * 答题消息处理器
 *
 * @author peach
 * @since 2025/12/21 22:23
 */
@Slf4j
@Component
public class AnswerMessageHandler implements MessageHandler {

    @Resource
    private AnswerService answerService;
    @Resource
    private ObjectMapper objectMapper;
    @Override
    public void handle(WebSocketSession session, WsMessage<?> message) {
        // 处理匹配请求...
        AnswerRequest request = objectMapper.convertValue(message.getData(), AnswerRequest.class);

        //WebSocketUtils.sendMessage(session, request);
    }

    @Override
    public boolean canHandle(String type) {
        return Objects.equals(type, MessageTypeEnum.ANSWER_REQUEST.getType());
    }

}