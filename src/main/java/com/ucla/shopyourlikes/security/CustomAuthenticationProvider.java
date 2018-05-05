package com.ucla.shopyourlikes.security;

import com.ucla.shopyourlikes.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String publisherid = authentication.getPrincipal().toString();
        String apikey = authentication.getCredentials().toString();
        String url = "http://api.shopyourlikes.com/api/link/ecpc?url=http%3A%2F%2Fwww.shopzilla.com&"
                +"publisherId="+publisherid+"&apiKey="+apikey;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        try {
            response = restTemplate.getForEntity(url,String.class);
        } catch (HttpClientErrorException ce) {
            logger.error("Fail to authenticate user with SYL server",ce);
        }

        if (response.getStatusCode().value() != 200) {
            throw new BadCredentialsException("Wrong publisher id or api key.");
        }
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal().toString(), authentication.getCredentials(), grantedAuths);
    }

    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
