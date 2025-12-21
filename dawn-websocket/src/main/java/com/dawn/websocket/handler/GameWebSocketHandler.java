package com.dawn.websocket.handler;

import com.dawn.websocket.config.WebSocketProperties;
import com.dawn.websocket.message.WsMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

/**
 * 游戏处理器
 *
 * 继承TextWebSocketHandler表示我们处理文本消息（JSON格式）
 *
 * 消息分发：将不同类型的消息路由到不同的处理器
 * 状态管理：管理用户连接状态
 * 心跳处理：维持连接活性
 * 异常处理：优雅处理各种异常
 *
 * @author peach
 * @since 2025/12/19 21:54
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class GameWebSocketHandler extends TextWebSocketHandler  {

    private final WebSocketProperties properties;
    private final ObjectMapper objectMapper;
    //private final SessionManager sessionManager;
    private final MessageDispatcher messageDispatcher;
    private final ApplicationEventPublisher eventPublisher;

    /**
     * 连接建立成功时调用（相当于TCP三次握手完成）
     * 客户端连接成功后，服务器会调用这个方法
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished");
    }



    /**
     * 收到客户端消息时调用
     * 这是游戏通信的核心！所有客户端操作（匹配、答题、聊天）都从这里进入
     */
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String sessionId = session.getId();
        Long userId = getUserIdFromSession(session);
        String payload = message.getPayload();
        // 记录接收到的消息（生产环境可能只需要DEBUG级别）
        log.info("📨 收到消息 - userId={}, sessionId={}, 长度={}", userId, sessionId, payload.length());

        // 1. 解析消息
        try {
            // 1. 解析消息
            WsMessage<?> wsMessage = parseMessage(payload);

            // 2. 更新心跳时间（收到任何消息都视为活跃）
            //heartbeatTimestamps.put(sessionId, System.currentTimeMillis());

            // 3. 特殊处理心跳消息
            //if (MessageType.HEARTBEAT.equals(wsMessage.getType())) {
            //    handleHeartbeat(session, wsMessage);
            //    return;
            //}

            // 4. 验证消息基本格式
            //validateMessage(wsMessage);

            // 5. 分发消息给对应的处理器（核心！）
            messageDispatcher.dispatch(session, wsMessage);

            // 6. 记录成功处理
            log.trace("消息处理成功: type={}, userId={}",
                    wsMessage.getType(), userId);

        }  catch (IOException e) {
            log.error("消息解析失败: userId={}", userId, e);
            //sendErrorMessage(session, "PARSE_ERROR", "消息解析失败");

        } catch (Exception e) {
            log.error("消息处理异常: userId={}", userId, e);
            //sendErrorMessage(session, "SERVER_ERROR", "服务器内部错误");
        }
        System.out.println("handleMessage");
    }
    /**
     * 解析消息
     */
    private WsMessage<?> parseMessage(String payload) throws IOException {
        return objectMapper.readValue(payload, WsMessage.class);
    }
    private Long getUserIdFromSession(WebSocketSession session) {
        return (Long) session.getAttributes().get("userId");
    }

    /**
     * 传输过程中出现错误时调用
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("handleTransportError");
    }

    /**
     * 连接关闭时调用（客户端断开、网络异常等）
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("afterConnectionClosed");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
