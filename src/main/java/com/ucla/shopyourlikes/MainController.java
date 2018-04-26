package com.ucla.shopyourlikes;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dashboard(Model model, @RequestParam Map<String, String> map) {
        return "dashboard";
    }

    @RequestMapping(value = "/mylinks", method = RequestMethod.GET)
    public String mylinks(Model model, @RequestParam Map<String, String> map) {
        return "mylinks";
    }

    @RequestMapping(value = "/mystats", method = RequestMethod.GET)
    public String mystats(Model model, @RequestParam Map<String, String> map) {
        return "mystats";
    }

    @RequestMapping(value = "/createlinks", method = RequestMethod.GET)
    public String createlinks(Model model, @RequestParam Map<String, String> map) {
        return "createlinks";
    }

}
