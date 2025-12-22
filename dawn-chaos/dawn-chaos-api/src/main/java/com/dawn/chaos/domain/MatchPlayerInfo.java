package com.dawn.chaos.domain;

import com.dawn.chaos.enums.MatchStatusEnum;
import lombok.Data;

/**
 * 匹配池用户信息
 *
 * @author peach
 * @since 2025/12/22 21:21
 */
@Data
public class MatchPlayerInfo {

    /**
     * 玩家id
     */
    private Long playerId;
    /**
     * 匹配状态
     * @see MatchStatusEnum
     */
    private MatchStatusEnum status;
}
