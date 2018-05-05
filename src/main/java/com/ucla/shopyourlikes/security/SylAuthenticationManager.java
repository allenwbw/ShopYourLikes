package com.ucla.shopyourlikes.security;

import com.ucla.shopyourlikes.database.User;
import com.ucla.shopyourlikes.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class SylAuthenticationManager implements AuthenticationManager {

    @Autowired
    UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = userRepository.getUserByUsername(authentication.getName());
        if(user != null) {
            if(user.getApiKey().equals(authentication.getCredentials()))
                return authentication;
        }
        throw new SylAuthenticationException("Bad login");
    }
}
