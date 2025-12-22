package com.dawn.chaos.pvp.service.impl;

import com.dawn.chaos.pvp.manager.MatchManager;
import com.dawn.chaos.pvp.manager.RoomManager;
import com.dawn.chaos.service.MatchService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * 匹配服务
 *
 * @author peach
 * @since 2025/12/22 21:05
 */
@Service
public class MatchServiceImpl implements MatchService {

    @Resource
    private MatchManager matchManager;
    @Resource
    private RoomManager roomManager;

    @Override
    public boolean addMatchPool(Long playerId) {
        return matchManager.add(playerId);
    }
}
