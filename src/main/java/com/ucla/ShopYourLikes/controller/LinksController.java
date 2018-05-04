package com.ucla.ShopYourLikes.controller;


import com.ucla.ShopYourLikes.payload.LinkResponse;
import com.ucla.ShopYourLikes.payload.PagedResponse;
import com.ucla.ShopYourLikes.repository.LinkRepository;
import com.ucla.ShopYourLikes.repository.UserRepository;
import com.ucla.ShopYourLikes.security.CurrentUser;
import com.ucla.ShopYourLikes.service.LinkService;
import com.ucla.ShopYourLikes.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/links")
public class LinksController {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkService linkService;

    @GetMapping
    public PagedResponse<LinkResponse> getLinks(@CurrentUser Object currentUser,
                                                @RequestParam(value="page",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size){
        return linkService.getAllLinks(currentUser,page,size);
    }
}
