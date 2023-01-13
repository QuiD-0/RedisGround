package com.quid.redisGround.caching.repository;

import com.quid.redisGround.caching.dto.UserProfile;

public interface UserRepository {

    UserProfile getUserProfile(String name);

}

