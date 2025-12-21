package com.dawn.chaos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
// 依赖的websocket包需要被识别到，后面优化
@ComponentScan(basePackages = {"com.dawn.websocket"})
public class DawnChaosApplication {

    public static void main(String[] args) {
        // 开启debug模式查看自动配置
        System.setProperty("debug", "true");
        SpringApplication.run(DawnChaosApplication.class, args);
        log.info("============Dawn chaos application started=========");
    }
}
