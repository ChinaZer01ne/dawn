package com.dawn.websocket.utiils;

import com.dawn.chaos.exception.ServerException;
import com.dawn.websocket.enums.MessageTypeEnum;
import com.dawn.websocket.message.WsMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 工具类
 *
 * @author peach
 * @since 2025/12/21 22:47
 */
@Component
public class MessageUtils {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 解析前端消息字符串→通用消息体
     *
     * @param msg :
     * @param dataClass :
     * @return com.dawn.websocket.utiils.WebSocketBaseMsg<T>
     */
    public <T> WsMessage<T> parseMessage(String msg, Class<T> dataClass) {
        try {
            WsMessage<T> baseMsg = objectMapper.readValue(msg, WsMessage.class);
            // 反序列化data字段为指定类型
            String dataJson = objectMapper.writeValueAsString(baseMsg.getData());
            T data = objectMapper.readValue(dataJson, dataClass);
            baseMsg.setData(data);
            return baseMsg;
        } catch (JsonProcessingException e) {
            throw new ServerException(1001, "消息解析失败：" + e.getMessage());
        }
    }

    /**
     * 构建后端响应/通知消息
     * @param msgId :
     * @param type :
     * @param data :
     * @return java.lang.String
     */
    public <T> String buildResponseMsg(String msgId, MessageTypeEnum type, T data) {
        WsMessage<T> msg = new WsMessage<>();
        msg.setReqId(msgId);
        msg.setType(type.getType());
        msg.setTimestamp(System.currentTimeMillis());
        msg.setData(data);
        try {
            return objectMapper.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            throw new ServerException(4002, "消息构建失败：" + e.getMessage());
        }
    }
}
