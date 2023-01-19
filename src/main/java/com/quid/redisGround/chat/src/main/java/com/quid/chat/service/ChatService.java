package com.quid.chat.service;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService implements MessageListener {

    private final RedisMessageListenerContainer container;

    private final RedisTemplate<String, String> redisTemplate;

    public void enterRoom(String roomName) {
        container.addMessageListener(this, new ChannelTopic(roomName));

        Scanner sc = new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();
            if (message.equals("exit")) {
                break;
            }
            redisTemplate.convertAndSend(roomName, message);
        }
        container.removeMessageListener(this);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("Message received: " + message.toString());
    }
}
