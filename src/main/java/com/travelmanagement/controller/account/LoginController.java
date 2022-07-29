package com.travelmanagement.controller.account;

import com.travelmanagement.model.user.UsersDetailsModel;
import com.travelmanagement.model.user.UsersModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(Principal principal) {
        if (principal == null) {
            return "login";
        } else {
            return "redirect:/user/dashboard";
        }
    }
}
