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

    @Mock
    private UserController userController;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation() {
        assertNotNull(userController);
    }

    @Test
    public void testGetCurrentUser() {
        User user = new User();
        user.setUserId(1000);
        user.setApiKey("10000");

        List<Link> f =  new ArrayList<>();
        Link link = new Link();

        link.setRedirects(100);
        link.setUrl("http://go.shopyourlikes.com/pi/e8eeb2b83bc433c0a5762331f4d80ba113362b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");
        link.setCreationDate("12:00");
        link.setOriginalUrl("dddddd");
        link.setEarnings(10f);
        link.setUserId(1000);
        link.setEcpc(90);
        f.add(link);
        user.setLinks(f);
        UserSummary userSummary = new UserSummary("1000");
        userSummary.setUserId("1000");

        when(userController.getCurrentUser(user)).thenReturn(userSummary);
        assertEquals(userSummary,userController.getCurrentUser(user));
    }

}
