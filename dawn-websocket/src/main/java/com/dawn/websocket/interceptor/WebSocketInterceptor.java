package com.dawn.websocket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * 拦截器
 *
 * @author peach
 * @since 2025/12/19 22:24
 */
@Component
public class WebSocketInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        System.out.println("before handshake");
        // 1. 认证解析用户
        String authorization = request.getHeaders().getFirst("Authorization");
        // authService.validateToken(token);
        // TODO 解析出用户id
        Long userId = 1L;
        // 2. 存储用户，方便后边使用
        attributes.put("userId", userId);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        System.out.println("after handshake");
    }
}
