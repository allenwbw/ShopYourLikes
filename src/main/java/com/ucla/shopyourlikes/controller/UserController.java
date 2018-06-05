package com.ucla.shopyourlikes.controller;


import com.ucla.shopyourlikes.payload.external.UserSummary;
import com.ucla.shopyourlikes.security.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is responsible for getting the current user information.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     *
     * @param currentUser
     * @return UserSummary about the current user
     */
    @RequestMapping("/me")
    public UserSummary getCurrentUser(@CurrentUser Object currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.toString());
        return userSummary;
    }
}