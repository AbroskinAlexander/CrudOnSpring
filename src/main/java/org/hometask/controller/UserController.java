package org.hometask.controller;

import org.hometask.model.User;
import org.hometask.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private UserService serv;

    public UserController(UserService serv) {
        this.serv = serv;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView home(Authentication authentication, ModelAndView model) {
            List<User> user = new ArrayList<>();
            user.add(serv.getUserByEmail(authentication.getName()));
            model.addObject("user", user);
            model.setViewName("user-info");
            return model;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView allUsers(ModelAndView modelAndView) {
        List<User> allUser = serv.getAllUsers();
        modelAndView.setViewName("user-main");
        modelAndView.addObject("users", allUser);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        serv.addUser(user);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView editPage(@RequestParam("id") Long id, ModelAndView modelAndView) {
        List<User> list = new ArrayList<>();
        list.add(serv.getUserById(id));
        modelAndView.addObject("list", list);
        modelAndView.setViewName("user-edit");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        serv.updateUser(user);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("id") Long id) {
        serv.deleteUser(serv.getUserById(id));
        return "redirect:/admin";
    }

}
