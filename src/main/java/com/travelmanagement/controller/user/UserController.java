package com.travelmanagement.controller.user;

import com.travelmanagement.model.travelpackage.TravelPackageModel;
import com.travelmanagement.model.user.UsersModel;
import com.travelmanagement.services.packege.PackageServices;
import com.travelmanagement.services.user.UserServices;
import org.hibernate.Session;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServices userServices;
    private final PackageServices packageServices;
    private int USER_ID;
    private Authentication authentication;
    private String USER_ROLE;

    public UserController(UserServices userServices, PackageServices packageServices) {
        this.userServices = userServices;
        this.packageServices = packageServices;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/dashboard")
    public String index(Model model) {
        final String currentUserName = SecurityContextHolder. getContext(). getAuthentication().getName();
        UsersModel usersModel=userServices.getUser(currentUserName);
        USER_ID=usersModel.getId();
        USER_ROLE=usersModel.getRole();
        model.addAttribute("user",usersModel);
        return "dashboard";
    }

    @RequestMapping("/addpackage")
    public String addPackage(Model model) {
        model.addAttribute("user", USER_ID);
        model.addAttribute("package", new TravelPackageModel());
        return "addpackage";
    }

    @RequestMapping("/process-package")
    public String processPackage(@Valid @ModelAttribute("package") TravelPackageModel travelPackageModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addpackage";
        }
        UsersModel model = new UsersModel();
        model.setId(USER_ID);
        packageServices.save(model, travelPackageModel);
        return "redirect:/user/dashboard";
    }

    @RequestMapping("/show-packages")
    public String showPackages(Model model){
        List<TravelPackageModel> travelPackageModels=packageServices.getAllTravelPackage();
        authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user",authentication.getAuthorities());
        model.addAttribute("all_packages",travelPackageModels);
        return "showpackages";
    }

    @RequestMapping("/see-package")
    public String showPackage(Model model,@RequestParam("packageId") int id){
        TravelPackageModel travelPackageModel=packageServices.getTravelPackage(id);
        model.addAttribute("p",travelPackageModel);
        return "see-package";
    }

    @RequestMapping("/buy-package")
    public String showBuyPage(Model model,@RequestParam("packageId") int id){
        TravelPackageModel travelPackageModel=packageServices.getTravelPackage(id);
        model.addAttribute("p",travelPackageModel);
        return "buy-package";
    }

    @RequestMapping("/show-user-packages")
    public String showPackages(Model model,@RequestParam("userId") int id){

        List<TravelPackageModel> travelPackageModels=packageServices.getTravelPackageByUser(id);
        model.addAttribute("all_packages",travelPackageModels);
        model.addAttribute("ROLE",USER_ROLE);
        return "showpackages";
    }

    @RequestMapping("/package-delete")
    public String deletePackage(@RequestParam("packageId") int id){
        packageServices.deleteTravelPackage(id);
        return "redirect:/user/dashboard";
    }

    @RequestMapping("/package-edit")
    public String editPackage(@RequestParam("packageId") int id,Model model){
        TravelPackageModel travelPackageModel=packageServices.getTravelPackage(id);
        model.addAttribute("user", USER_ID);
        model.addAttribute("p",travelPackageModel);
        return "edit-package";
    }

    @RequestMapping("/process-edit-package")
    public String processEditPackage(@Valid @ModelAttribute("p") TravelPackageModel travelPackageModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-package";
        }
        packageServices.updateTravelPackage(travelPackageModel);
        return "redirect:/user/show-user-packages?userId="+USER_ID;
    }
}
