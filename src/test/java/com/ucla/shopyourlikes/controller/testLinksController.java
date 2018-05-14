package com.ucla.shopyourlikes.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// TODO: will add more testcase
@RunWith(SpringRunner.class)
@SpringBootTest
public class testLinksController {

    @Autowired
    private LinksController linksController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(linksController).isNotNull();
    }
}
