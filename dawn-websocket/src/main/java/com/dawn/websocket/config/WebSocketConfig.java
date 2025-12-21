package com.dawn.websocket.config;

import com.dawn.websocket.handler.GameWebSocketHandler;
import com.dawn.websocket.interceptor.WebSocketInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author peach
 * @since 2025/12/15 22:02
 */
@Configuration
@ConditionalOnProperty(name = "websocket.enabled", havingValue = "true")
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketProperties websocketProperties;
    private final GameWebSocketHandler gameWebSocketHandler;
    private final WebSocketInterceptor webSocketInterceptor;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(gameWebSocketHandler, websocketProperties.getPath())
                .addInterceptors(webSocketInterceptor)
                .setAllowedOrigins("*");
    }


}
