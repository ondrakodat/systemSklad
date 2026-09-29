package com.kodat.skladovysystem.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;

@Component
public class JwtService {
    private final String secretKey = "opravdu-dlouhy-secret-klic-pro-nase-jwt";
    private final Duration expiration = Duration.ofMinutes(15);

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username) //Vlozime jmeno uzivatele
                .issuedAt(new Date()) //Kdy byl token vytvoren
                .expiration(new Date(System.currentTimeMillis() + expiration.toMillis())) //Kdy expiruje
                .signWith(getSecretKey()) // Podepsani klicem
                .compact(); //Prevedeme na vysledny String
    }


    public boolean validateToken(String token){
        try {
            Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }


}
