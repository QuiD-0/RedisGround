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
                UserProfile userProfile = userTempRepository.getUserProfile(name);
                userRedisRepository.saveUserProfile(userProfile);
                return userProfile;
            });
    }

    @Override
    public UserProfile getUserProfileFromTemp(String name) {
        return userTempRepository.getUserProfile(name);
    }

}
