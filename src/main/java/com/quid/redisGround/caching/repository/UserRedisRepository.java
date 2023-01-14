package com.quid.redisGround.caching.repository;

import com.quid.redisGround.config.RedisBase;
import com.quid.redisGround.caching.dto.UserProfile;
import java.time.Duration;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRedisRepository {

    private final RedisBase redisBase;

    public Optional<UserProfile> getUserProfile(String name) {
        return redisBase.get(name, UserProfile.class);
        }


    public void saveUserProfile(UserProfile userProfile) {
        redisBase.save(userProfile.getName(), userProfile, Duration.ofSeconds(10));
    }

}

