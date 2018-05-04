package com.ucla.shopyourlikes.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security
        .authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.*;
import static java.util.Collections.emptyList;

import javax.servlet.http.Cookie;

public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 864_000_000;
    static final String SECRET = "ThisIsASecret";
    static final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse res, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(HS512, SECRET)
                .compact();
        res.addHeader(HEADER_STRING, JWT);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies == null)
            return null;
        for (Cookie c : cookies) {
            if(c.getName().equals(HEADER_STRING)) {
                String token = c.getValue();
                String user = Jwts.parser()
                        .setSigningKey(SECRET)
                        .parseClaimsJws(token)
                        .getBody().getSubject();
                return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
            }
        }
        return null;
    }
}
