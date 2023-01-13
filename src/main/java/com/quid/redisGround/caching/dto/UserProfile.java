package com.quid.redisGround.caching.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserProfile {

    @JsonProperty
    private String name;
    @JsonProperty
    private int age;

    public UserProfile(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
