package com.quid.redisGround.caching.service;

import com.quid.redisGround.caching.dto.UserProfile;
import com.quid.redisGround.caching.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserProfile getUserProfile(String name) {
        return userRepository.getUserProfile(name);
    }


}
