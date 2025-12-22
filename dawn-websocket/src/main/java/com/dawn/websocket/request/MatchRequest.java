package com.dawn.websocket.request;

import lombok.Data;

/**
 * 匹配请求
 *
 * @author oeach
 * @since 2025/12/22 21:11
 */
@Data
public class MatchRequest {

    /**
     * 匹配类型
     */
    private String matchType;
}
