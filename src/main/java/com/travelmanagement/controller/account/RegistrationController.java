package com.travelmanagement.controller.account;

import com.travelmanagement.model.user.UsersDetailsModel;
import com.travelmanagement.model.user.UsersModel;
import com.travelmanagement.services.user.UserServices;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final UserServices userServices;

    public RegistrationController(UserServices userServices) {
        this.userServices = userServices;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/register")
    public String registration(Model model){
        model.addAttribute("user", new UsersModel());
        return "register";
    }

    @RequestMapping("/process-register")
    public String processRegistration(@Valid @ModelAttribute("user") UsersModel user,
                                      BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userServices.createUser(user);
        return "redirect:/login";
    }
}
