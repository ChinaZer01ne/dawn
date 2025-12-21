package com.dawn.websocket.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 通用的websocket消息体
 * @author peach
 * @since 2025/12/21 22:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WsMessage<T> {
    /**
     * 请求id
     */
    private String reqId;
    /**
     * 消息类型，例如：MATCH、ANSWER、CHAT等
     */
    private String type;

    /**
     * 消息数据，可以是任意对象，由业务决定
     */
    private T data;

    /**
     * 时间戳
     */
    private Long timestamp;
}