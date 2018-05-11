package com.ucla.shopyourlikes.controller;


import com.ucla.shopyourlikes.payload.CreateLinksRequest;
import com.ucla.shopyourlikes.payload.LinkResponse;
import com.ucla.shopyourlikes.payload.PagedResponse;
import com.ucla.shopyourlikes.repository.LinkRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.security.CurrentUser;
import com.ucla.shopyourlikes.service.LinkService;
import com.ucla.shopyourlikes.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/links")
public class LinksController {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkService linkService;

    @GetMapping("/mylinks")
    public PagedResponse<LinkResponse> getLinks(@CurrentUser Object currentUser,
                                                @RequestParam(value="page",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return linkService.getAllLinks(currentUser,page,size);
    }

    @PostMapping("/createlinks")
    public ResponseEntity<?> generateLinks(@CurrentUser Object currentUser,
                                           @Valid @RequestBody CreateLinksRequest request){
        return ResponseEntity.ok(linkService.createLinks(currentUser,request.getUrls()));
    }

}
