package com.ucla.shopyourlikes.security;

import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.service.ConnexityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertNotNull;

public class testCustomAuthenticationProvider {

    @InjectMocks
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ConnexityService connexityService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        customAuthenticationProvider = new CustomAuthenticationProvider();
        customAuthenticationProvider.connexityService = connexityService;
        customAuthenticationProvider.userRepository= userRepository;
    }

    @Test
    public void testAuthenticate_goodcase() {

       Authentication authentication = new Authentication() {
           @Override
           public Collection<? extends GrantedAuthority> getAuthorities() {
               return null;
           }

           @Override
           public Object getCredentials() {
               return "7438a399d83eceffef422e5563a94401";
           }

           @Override
           public Object getDetails() {
               return null;
           }

           @Override
           public Object getPrincipal() {
               return 628626;
           }

           @Override
           public boolean isAuthenticated() {
               return false;
           }

           @Override
           public void setAuthenticated(boolean b) throws IllegalArgumentException {

           }

           @Override
           public String getName() {
               return null;
           }
       };
        when(customAuthenticationProvider.authenticate(authentication)).thenReturn(customAuthenticationProvider.accept(authentication));
        assertNotNull(customAuthenticationProvider.authenticate(authentication));
        customAuthenticationProvider.registerUser(authentication);
    }

    @Test(expected = BadCredentialsException.class)
    public void testAuthenticateThrowAuthenticationException() {

        Authentication authentication = new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public Object getCredentials() {
                return "7438a3effef422e5563a94401";
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return 622323;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean b) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return null;
            }
        };
        customAuthenticationProvider.authenticate(authentication);
    }



}
