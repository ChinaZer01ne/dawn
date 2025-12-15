package com.dawn.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class DawnWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(DawnWebsocketApplication.class, args);
    }

}
