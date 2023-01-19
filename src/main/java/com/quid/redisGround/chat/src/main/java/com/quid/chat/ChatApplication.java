package com.quid.chat;

import com.quid.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ChatApplication implements CommandLineRunner {

    private final ChatService chatService;

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        chatService.enterRoom("room1");
    }
}
