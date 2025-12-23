package com.dawn.chaos.pvp.service.impl;

import com.dawn.chaos.pvp.manager.MatchManager;
import com.dawn.chaos.pvp.manager.RoomManager;
import com.dawn.chaos.pvp.utils.JsonUtils;
import com.dawn.chaos.request.MatchJoinRequest;
import com.dawn.chaos.service.MatchService;
import com.dawn.websocket.utiils.WebSocketUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * 匹配服务
 *
 * @author peach
 * @since 2025/12/22 21:05
 */
@Slf4j
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

    @Override
    public void matchJoin(Long userId, MatchJoinRequest request) {
        // 添加到匹配池
        matchManager.add(userId);
        // TODO 匹配
        //getOpponentInfo();
        try {
            WebSocketUtils.sendMessage(userId, JsonUtils.toJson(request));
        } catch (Exception e) {
            log.error(e.getMessage());
            WebSocketUtils.sendMessage(userId, e.getMessage());
        }
    }

    @Override
    public void matchCancel() {

    }
}
