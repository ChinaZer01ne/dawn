package com.dawn.websocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author peach
 * @since 2025/12/15 22:02
 */
@Data
@Component
@ConfigurationProperties(prefix = "websocket")
public class WebsocketProperties {
    /**

     * 是否开启websocket
     */
    private boolean enabled;
    /**
     * 路径
     */
    private String path;
}
