package com.quid.redisGround.leaderBoard.service;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaderBoardService {

    private final RedisTemplate redisTemplate;

    private static final String LEADER_BOARD_KEY = "leaderBoard";

    public void addRanking(String value, double score) {
        redisTemplate.opsForZSet().add(LEADER_BOARD_KEY, value, score);
    }

    public Long getRanking(String key) {
        return redisTemplate.opsForZSet().rank(LEADER_BOARD_KEY, key);
    }

    public Set<String> getTopRanking(int limit) {
        return redisTemplate.opsForZSet().reverseRange(LEADER_BOARD_KEY, 0, limit - 1);
    }

}
