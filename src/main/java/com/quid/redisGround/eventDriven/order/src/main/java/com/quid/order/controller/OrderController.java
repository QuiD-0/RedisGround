package com.quid.order.controller;

import com.quid.order.dto.OrderCreateReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/order")
    public String order(OrderCreateReq orderCreateReq) {
        redisTemplate.opsForStream().add("order-event", orderCreateReq.toMap());
        log.info("order: {}", orderCreateReq);
        return "success";
    }

}
