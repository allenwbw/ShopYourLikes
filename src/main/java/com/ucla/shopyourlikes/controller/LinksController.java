package com.ucla.shopyourlikes.controller;

import com.ucla.shopyourlikes.database.SylLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LinksController {

    @Autowired
    SylLinkRepository sylLinkRepo;

    @RequestMapping(value = "/api/links/epc", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getEpc()
    {
        return "{\"epc\":0}";
    }

}
