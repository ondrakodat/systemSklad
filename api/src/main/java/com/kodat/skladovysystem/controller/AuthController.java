package com.kodat.skladovysystem.controller;

import com.kodat.skladovysystem.Dto.LoginDto;
import com.kodat.skladovysystem.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public String over(@RequestBody LoginDto dto){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getSecret()));
        System.out.printf("Prihlaseni probehlo v poradku");
        return jwtService.generateToken(dto.getUsername());
    }

}
