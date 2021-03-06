package com.ucla.shopyourlikes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom Jwt Authentication Filter
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    /**
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);
            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                Integer userId = tokenProvider.getUserIdFromJWT(jwt);
                List<GrantedAuthority> grantedAuths = new ArrayList<>();
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId.toString(), null, grantedAuths);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request,response);
    }

    /**
     *
     * @param request
     * @return the jwt from request
     */
    private String getJwtFromRequest(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if(auth == null)
            return null;
        return auth.substring(7);
    }
}