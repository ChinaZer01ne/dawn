-- 实际情况可能是用户基础信息表，用户pvp表
CREATE TABLE user_info (
       id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
       username VARCHAR(50) UNIQUE NOT NULL COMMENT '用户名',
       nickname VARCHAR(50) NOT NULL COMMENT '昵称',
       avatar VARCHAR(255) COMMENT '头像URL',
       current_tickets INT DEFAULT 5 COMMENT '当前门票数量',
       last_ticket_recovery_time DATETIME COMMENT '上次门票恢复时间',
       season_score INT DEFAULT 0 COMMENT '赛季积分',
       rank_score INT DEFAULT 0 COMMENT '排位积分',
       level INT DEFAULT 1 COMMENT '等级',
       win_count INT DEFAULT 0 COMMENT '胜利场次',
       lose_count INT DEFAULT 0 COMMENT '失败场次',
       draw_count INT DEFAULT 0 COMMENT '平局场次',
       total_games INT DEFAULT 0 COMMENT '总对局数',
       create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
       update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

