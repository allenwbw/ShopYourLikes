package com.ucla.shopyourlikes.controller;


import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.LinkId;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.ConnexityCreateLinkResponse;
import com.ucla.shopyourlikes.payload.CreateLinkRequest;
import com.ucla.shopyourlikes.payload.CreateLinkResponse;
import com.ucla.shopyourlikes.repository.LinkRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


// This is basic function to insert a raw data to our database
@RestController
@RequestMapping("/api/links")
public class LinkCreationController {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<CreateLinkResponse> createLink(@RequestBody CreateLinkRequest createLinkRequest, @CookieValue("Authorization") String token) {

        // jwtTokenProvider check validate the token
        if (!jwtTokenProvider.validateToken(token)) {
            throw new BadRequestException("Unauthorized request");
        }
        // after validate the token then we can get the user id from jwTokenProvider
       int userId = jwtTokenProvider.getUserIdFromJWT(token);
        // we can find the user with the userId
        User user = userRepository.findByUserId(userId);

        // raw data
        // TODO: we need to use the real data
        ConnexityCreateLinkResponse connexityCreateLinkResponse = new ConnexityCreateLinkResponse();
        connexityCreateLinkResponse.setEcpc(0.0f);
        connexityCreateLinkResponse.setLink("https://test.com");
        connexityCreateLinkResponse.setOriginalUrl("https://orig.com");

        // raw data
        // TODO: we need to use the real data
        Link link = new Link();
        link.setOriginalUrl(connexityCreateLinkResponse.getOriginalUrl());
        link.setEpc(connexityCreateLinkResponse.getEcpc());
        DateFormat dateFormat =  new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        link.setCreationDate(dateFormat.format(new Date()));
        link.setUserId(userId);
        link.setUrl(connexityCreateLinkResponse.getLink());
        link.setMerchantId(0);
        link.setEarnings(0.0f);
        link.setRedirects(0);
        link.setHash("d000000");

        linkRepository.saveAndFlush(link);

        CreateLinkResponse createLinkResponse = new CreateLinkResponse();
        return ResponseEntity.ok(null);
    }
}
