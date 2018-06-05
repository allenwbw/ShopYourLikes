package com.ucla.shopyourlikes.controller;

import com.ucla.shopyourlikes.payload.external.*;
import com.ucla.shopyourlikes.security.CurrentUser;
import com.ucla.shopyourlikes.service.LinksService;
import com.ucla.shopyourlikes.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * This class is all the API calls for Links controller
 */
@RestController
@RequestMapping("/api/links")
public class LinksController {
    @Autowired
    protected LinksService linksService;

    /**
     *
     * @param currentUser current user's information
     * @param page
     * @param size
     * @return a list PagedResponse of LinkResponse
     */
    @GetMapping("/mylinks")
    public PagedResponse<LinkResponse> getLinks(@CurrentUser Object currentUser,
                                                @RequestParam(value="page",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                @RequestParam(value="size",defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return linksService.getAllLinks(currentUser, page, size);
    }

    /**
     *
     * @param currentUser current user information
     * @param url
     * @return the EcpcResponse
     */
    @GetMapping("/ecpc")
    public EcpcResponse getEcpc(@CurrentUser Object currentUser,
                                @RequestParam(value="url") String url) {
        return linksService.getEcpc(currentUser, url);
    }

    /**
     *
     * @param currentUser current user's information
     * @param request link creation request from the user
     * @return ResponseEntity.ok with createLinksResponse if it is successful otherwise return ResponseEntity.badRequest()
     */
    @PostMapping("/create")
    public ResponseEntity<?> generateLinks(@CurrentUser Object currentUser,
                                           @Valid @RequestBody CreateLinksRequest request) {
        CreateLinksResponse createLinksResponse = linksService.createLinks(currentUser, request.getUrls());
        if(createLinksResponse != null)
            return ResponseEntity.ok(createLinksResponse);
        return  ResponseEntity.badRequest().build();
    }
}
