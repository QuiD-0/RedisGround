package com.quid.redisGround.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Duration;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisBase {

    private final RedisTemplate redisTemplate;

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public <T> Optional<T> get(String key, Class<T> classType) {
        Object result = redisTemplate.opsForValue().get(key);
        return result == null ? Optional.empty()
            : Optional.of(objectMapper.convertValue(result, classType));
    }

    public <T> void save(String key, T value, Duration expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

}