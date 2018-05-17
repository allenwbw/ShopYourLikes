package com.ucla.shopyourlikes.security;

import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.service.ConnexityService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConnexityService connexityService;

    private boolean authenticateLocal(Authentication authentication) {
        Integer publisherId = Integer.valueOf(authentication.getPrincipal().toString());
        String apiKey = authentication.getCredentials().toString();

        return userRepository.existsByUserIdAndAndApiKey(publisherId, apiKey);
    }

    private boolean authenticateConnexity(Authentication authentication) {
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
        return response.getStatusCode().value() == 200;
    }

    private void registerUser(Authentication authentication) {
        Integer userId = Integer.valueOf(authentication.getPrincipal().toString());
        User user = new User(userId, authentication.getCredentials().toString());
        userRepository.saveAndFlush(user);
    }

    private Authentication accept(Authentication authentication) {
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal().toString(), authentication.getCredentials(), grantedAuths);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if(authenticateLocal(authentication)) {
            logger.debug("User " + authentication.getPrincipal().toString() + " logged in with local authentication");
            return accept(authentication);
        } else if (authenticateConnexity(authentication)) {
            registerUser(authentication);
            logger.debug("User " + authentication.getPrincipal().toString() + " logged in with Connexity authentication");
            return accept(authentication);
        }
        throw new BadCredentialsException("Wrong publisher id or api key.");
    }

    @Override
    public boolean supports(Class<?> authentication){
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
