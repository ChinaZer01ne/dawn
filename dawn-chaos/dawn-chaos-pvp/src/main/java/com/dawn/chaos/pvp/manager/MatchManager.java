package com.dawn.chaos.pvp.manager;

import com.dawn.chaos.domain.MatchPlayerInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 匹配管理器
 *
 * @author peach
 * @since 2025/12/22 21:07
 */
@Component
public class MatchManager {

    /**
     * 匹配池
     */
    private List<MatchPlayerInfo> matchPool = new CopyOnWriteArrayList<>();

    /**
     * 将玩家添加到匹配池
     * @param playerId :
     * @return boolean
     */
    public boolean add(Long playerId) {
        MatchPlayerInfo matchPlayerInfo = new MatchPlayerInfo();
        matchPlayerInfo.setPlayerId(playerId);
        return matchPool.add(matchPlayerInfo);
    }
}
