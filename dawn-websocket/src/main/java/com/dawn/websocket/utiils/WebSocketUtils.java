package com.dawn.websocket.utiils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

/**
 * 通信工具
 * @author peach
 * @since 2025/12/22 21:27
 */
@Slf4j
@Component
public class WebSocketUtils {

    /**
     * 消息发送
     * @param session :
     * @param message :
     */
    public static void sendMessage(WebSocketSession session, String message) {
        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
