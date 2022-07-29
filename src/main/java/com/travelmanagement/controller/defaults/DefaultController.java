package com.travelmanagement.controller.defaults;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class DefaultController {

    @RequestMapping({ "/", "/index", "/home" })
    public String index(Principal principal) {
        return principal != null ? "redirect:/user/dashboard" : "index";
    }
}
