package com.quid.redisGround.basic;

import java.util.Optional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicRedisController {

    private final StringRedisTemplate stringRedisTemplate;

    @PostMapping
    public void set(@RequestBody BasicReq req) {
        stringRedisTemplate.opsForValue().set(req.key, req.value);
    }

    @GetMapping("/{key}")
    public String get(@PathVariable String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @DeleteMapping
    public void del(@RequestBody String key) {
        stringRedisTemplate.delete(key);
    }

    @GetMapping("/keys")
    public String keys() {
        return Optional.ofNullable(stringRedisTemplate.keys("*"))
                .map(Object::toString)
                .orElse("No keys found");
    }

    @Data
    private static class BasicReq{
        String key;
        String value;
    }
}
