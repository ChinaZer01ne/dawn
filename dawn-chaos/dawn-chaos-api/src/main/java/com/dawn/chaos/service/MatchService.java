package com.dawn.chaos.service;
/**
 * 匹配服务
 *
 * @author peach
 * @since 2025/12/22 21:05
 */
public interface MatchService {
    /**
     * 将玩家添加到匹配池
     *
     * @param playerId :
     * @return boolean
     */
    boolean addMatchPool(Long playerId);
}
