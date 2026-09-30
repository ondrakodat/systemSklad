package com.kodat.skladovysystem.jwt;

import com.kodat.skladovysystem.interfaces.Iservices.IZamestnanecService;
import com.kodat.skladovysystem.service.ZamestnanecDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.sql.ast.tree.expression.Summarization;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;


import java.io.IOException;
@Component
public class JwtAuthenticatorFiltr extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final ZamestnanecDetailService detailService;

    public JwtAuthenticatorFiltr(JwtService jwtService, ZamestnanecDetailService iZamestnanecService) {
        this.jwtService = jwtService;
        detailService = iZamestnanecService;
    }


    /*
        * Metoda pro filtrování provozu na end point ještě než by k němu dorazil
        * HttpServletRequest - objekt reprezentující Http požadavek
        *       - tedy uchovává informace o tom co klient poslal na stranu serveru
        *       - také obsahuje např. typ metody (Get, Post atd.) pomocí request.getMethod()
        *       - na jakou adresu se dotaz poslal tedy pomocí .getRequestUri()
        *       - také můžeme vytáhnout hlavičku podle názvu .getHeader("nazev")
        *       - celou URL adresu pomocí .getRequestURL
        *       - IP addresa klienta .getRemoteAddr
        *       - získání Cookies : Cookie [] cookies = request.getCookies();
        * HttpServletResponse - objekt ktery reprezentuje odpověď serveru směrem ke klientovi
        * FilterChain - cesta po které jde request přes filtry až k endpointu
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String ZACATEK_HLAVICKY = "Bearer ";
        String auuthrorizationHeader = request.getHeader("Authorization");
        /*
        Pokud request nemá JWT posíláme ho dál a nestaráme se zde o něj
         */
        if(auuthrorizationHeader == null || !auuthrorizationHeader.startsWith(ZACATEK_HLAVICKY))
        {
            filterChain.doFilter(request, response);
            return;
        }
        String token = auuthrorizationHeader.substring(ZACATEK_HLAVICKY.length());
        /*
        Token není platný např. vypršel a request posíláme dál
         */
        if (!jwtService.validateToken(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String username = jwtService.getUsernameFromToken(token);
        UserDetails userDetails = detailService.loadUserByUsername(username);
        /*
        Pokud máme platný JWT uděláme objekt a předáme ho jako autentizovaného uzivatele
         */
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response); //Předání requestu dalšímu filtru v našem řetězci
    }
}
