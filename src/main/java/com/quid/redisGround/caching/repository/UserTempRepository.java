package com.quid.redisGround.caching.repository;

import com.quid.redisGround.caching.dto.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class UserTempRepository {

    public UserProfile getUserProfile(String name) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("cache not hit");
        return new UserProfile(name, 20);
    }

}
