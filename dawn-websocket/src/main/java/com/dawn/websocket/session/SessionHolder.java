package com.dawn.websocket.session;

import org.springframework.web.socket.WebSocketSession;

import java.util.HashMap;
import java.util.Map;

/**
 * session 管理
 *
 * @author peach
 * @since 2025/12/23 22:42
 */
public class SessionHolder {

    /**
     * session池
     */
    private static Map<Long, WebSocketSession> sessions = new HashMap<>();

    /**
     * 保存session信息
     *
     * @param userId :
     * @param session :
     */
    public static void addSession(Long userId, WebSocketSession session) {
        sessions.put(userId, session);
    }

    /**
     * 获取session
     *
     * @param userId :
     * @return org.springframework.web.socket.WebSocketSession
     */
    public static WebSocketSession getSession(Long userId) {
        return sessions.get(userId);
    }
}
