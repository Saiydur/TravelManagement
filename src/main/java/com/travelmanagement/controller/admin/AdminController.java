package com.travelmanagement.controller.admin;

import com.travelmanagement.model.user.UsersModel;
import com.travelmanagement.services.user.UserServices;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserServices userServices;

    public AdminController(UserServices userServices) {
        this.userServices = userServices;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userServices.getAllUsers());
        return "users-list";
    }

    @RequestMapping("/users/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userServices.deleteUser(id);
        return "redirect:/admin/users";
    }

    @RequestMapping("/users/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userServices.getUserById(id));
        return "edit-user";
    }

    @RequestMapping("/users/update-edit")
    public String updateUser(@Valid @ModelAttribute("user") UsersModel user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }
        userServices.updateUser(user);
        return "redirect:/admin/users";
    }
}
