package com.dawn.chaos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DawnChaosApplication {

    public static void main(String[] args) {
        SpringApplication.run(DawnChaosApplication.class, args);
        log.info("============Dawn chaos application started=========");
    }

}
