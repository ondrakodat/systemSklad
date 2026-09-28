package com.kodat.skladovysystem.jwt;

import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class JwtService {
    private final String secretKey = "";
    private final Duration expiration = Duration.ofMinutes(15);

    public String generateToken(String username){
        return null;

    }


}
