package com.kodat.skladovysystem.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    private final StringRedisTemplate redisT;

    public RedisTestController(StringRedisTemplate redisT) {
        this.redisT = redisT;
    }


}
