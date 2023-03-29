package com.quid.redisGround.caching.controller;

import com.quid.redisGround.caching.dto.UserProfile;
import com.quid.redisGround.caching.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile/{name}")
    public UserProfile getUserProfile(@PathVariable String name) {
        return userService.getUserProfile(name);
    }

    @GetMapping("/name/{name}")
    public UserProfile getUserName(@PathVariable String name) {
        return userService.getUserName(name);
    }

}
