package com.kodat.skladovysystem.interfaces.IsecretService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecretConfig {
    @Bean
    public PasswordEncoder encoder(){
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
