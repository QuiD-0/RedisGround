package com.quid.redisGround.caching.repository;

import com.quid.redisGround.caching.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRedisRepository userRedisRepository;
    private final UserTempRepository userTempRepository;

    @Override
    public UserProfile getUserProfile(String name) {
        return userRedisRepository.getUserProfile(name)
            .orElseGet(() -> {
                userRedisRepository.saveUserProfile(new UserProfile(name, 20));
                return userTempRepository.getUserProfile(name);
            });
    }

}
