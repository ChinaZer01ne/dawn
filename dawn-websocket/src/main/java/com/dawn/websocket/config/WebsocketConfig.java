package com.dawn.websocket.config;

import com.dawn.websocket.handler.MyWebsocketHandler;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author peach
 * @since 2025/12/15 22:02
 */
@Component
@ConditionalOnProperty(name = "websocket.enabled", havingValue = "true")
@RequiredArgsConstructor
public class WebsocketConfig implements WebSocketConfigurer {

    private final WebsocketProperties websocketProperties;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyWebsocketHandler(), websocketProperties.getPath()).setAllowedOrigins("*");
    }
}
