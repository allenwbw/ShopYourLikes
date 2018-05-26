package com.ucla.shopyourlikes.controller;

import static org.junit.Assert.*;

import com.ucla.shopyourlikes.model.Link;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.external.UserSummary;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

// TODO: will add more testcase

public class testUserController {

    private UserController userController;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        userController = new UserController();
    }

    @Test
    public void testGetCurrentUser() {
        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");
        UserSummary userSummary = userController.getCurrentUser(user);
        assertNotNull(userSummary);
    }
}
