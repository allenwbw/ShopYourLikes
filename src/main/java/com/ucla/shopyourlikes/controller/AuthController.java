package com.ucla.shopyourlikes.controller;


import com.google.common.base.Strings;
import com.ucla.shopyourlikes.payload.external.JwtAuthenticationResponse;
import com.ucla.shopyourlikes.payload.external.LoginRequest;
import com.ucla.shopyourlikes.repository.RoleRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    protected AuthenticationManager authenticationManager;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){

        if(Strings.isNullOrEmpty(loginRequest.getUserId()) || Strings.isNullOrEmpty(loginRequest.getApiKey())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getApiKey()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));

    }


}
