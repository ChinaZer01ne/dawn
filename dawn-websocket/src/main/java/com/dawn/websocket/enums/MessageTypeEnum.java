package com.dawn.websocket.enums;

import lombok.Getter;

/**
 * 定义所有消息类型
 * 游戏中的所有操作都对应一个消息类型
 */
@Getter
public enum MessageTypeEnum {

    MATCH_REQUEST("MATCH_REQUEST"),
    MATCH_CANCEL("MATCH_CANCEL"),
    ANSWER_REQUEST("ANSWER_REQUEST"),
    ;

    private String type;

    MessageTypeEnum(String type) {
        this.type = type;
    }

    //// 系统消息
    //public static final String PING = "PING";  // 心跳请求
    //public static final String PONG = "PONG";  // 心跳响应
    //public static final String ERROR = "ERROR";  // 错误消息
    //
    //// 匹配相关
    //public static final String MATCH_RESPONSE = "MATCH_RESPONSE";  // 匹配响应
    //public static final String MATCH_SUCCESS = "MATCH_SUCCESS";  // 匹配成功
    //public static final String MATCH_TIMEOUT = "MATCH_TIMEOUT";  // 匹配超时
    //
    //// 房间相关
    //public static final String ROOM_JOIN = "ROOM_JOIN";  // 加入房间
    //public static final String ROOM_LEAVE = "ROOM_LEAVE";  // 离开房间
    //public static final String ROOM_INFO = "ROOM_INFO";  // 房间信息
    //public static final String ROOM_PLAYER_READY = "ROOM_PLAYER_READY";  // 玩家准备
    //
    //// 游戏相关
    //public static final String GAME_START = "GAME_START";  // 游戏开始
    //public static final String QUESTION_PUSH = "QUESTION_PUSH";  // 推送题目
    //public static final String ANSWER_SUBMIT = "ANSWER_SUBMIT";  // 提交答案
    //public static final String ANSWER_RESULT = "ANSWER_RESULT";  // 答案结果
    //public static final String ROUND_START = "ROUND_START";  // 回合开始
    //public static final String ROUND_END = "ROUND_END";  // 回合结束
    //public static final String GAME_END = "GAME_END";  // 游戏结束
    //
    //// 聊天相关
    //public static final String CHAT_MESSAGE = "CHAT_MESSAGE";  // 聊天消息
    //public static final String CHAT_BROADCAST = "CHAT_BROADCAST";  // 广播聊天
    //
    //// 状态同步
    //public static final String PLAYER_STATE_UPDATE = "PLAYER_STATE_UPDATE";  // 玩家状态更新
    //public static final String ROOM_STATE_UPDATE = "ROOM_STATE_UPDATE";  // 房间状态更新
}