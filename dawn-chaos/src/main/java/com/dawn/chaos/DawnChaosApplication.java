package com.dawn.chaos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"com.dawn.websocket"})
public class DawnChaosApplication {

    public static void main(String[] args) {
        // 开启debug模式查看自动配置
        System.setProperty("debug", "true");
        SpringApplication.run(DawnChaosApplication.class, args);
        log.info("============Dawn chaos application started=========");
    }
}
