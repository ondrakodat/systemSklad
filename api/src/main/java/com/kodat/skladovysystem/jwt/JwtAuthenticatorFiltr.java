package com.kodat.skladovysystem.jwt;

import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;
import com.kodat.skladovysystem.service.ZamestnanecDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;


import java.io.IOException;

public class JwtAuthenticatorFiltr extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final ZamestnanecDetailService detailService;

    public JwtAuthenticatorFiltr(JwtService jwtService, ZamestnanecDetailService iZamestnanecService) {
        this.jwtService = jwtService;
        detailService = iZamestnanecService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String ZACATEK_HLAVICKY = "Bearer ";
        String auuthrorizationHeader = request.getHeader("Authorization");
        if(auuthrorizationHeader == null || !auuthrorizationHeader.startsWith(ZACATEK_HLAVICKY))
        {
            filterChain.doFilter(request, response);
            return;
        }
        String token = auuthrorizationHeader.substring(ZACATEK_HLAVICKY.length());
        if (!jwtService.validateToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = jwtService.getUsernameFromToken(token);
        UserDetails userDetails = detailService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }
}
