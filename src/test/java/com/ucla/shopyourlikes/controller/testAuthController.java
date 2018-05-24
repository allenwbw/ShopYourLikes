package com.ucla.shopyourlikes.controller;

import static org.junit.Assert.assertEquals;

import com.ucla.shopyourlikes.payload.external.LoginRequest;
import com.ucla.shopyourlikes.repository.RoleRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.security.JwtTokenProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;


// TODO: will add more testcase
public class testAuthController {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private JwtTokenProvider tokenProvider;

    private AuthController authController;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        authController = new AuthController();
        authController.authenticationManager= authenticationManager;
        authController.userRepository = userRepository;
        authController.roleRepository = roleRepository;
        authController.tokenProvider = tokenProvider;

    }

    @Test
    public void authenticateUser_ok()  {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setApiKey("ucla");
        loginRequest.setUserId("bruin");
        ResponseEntity<?> responseEntity = authController.authenticateUser(loginRequest);

        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
    }

    @Test
    public void authenticateUser_BAD_REQUEST_emptyApiKey()  {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setApiKey("");
        loginRequest.setUserId("bruin");

        ResponseEntity<?> responseEntity = authController.authenticateUser(loginRequest);

        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    public void authenticateUser_BAD_REQUEST_emptyUserId()  {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setApiKey("ucla");
        loginRequest.setUserId("");

        ResponseEntity<?> responseEntity = authController.authenticateUser(loginRequest);

        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

}
