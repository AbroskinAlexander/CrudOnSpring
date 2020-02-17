package org.hometask.controller;

import org.hometask.model.User;
import org.hometask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller()
public class UserController {
    private UserService serv;

    @Autowired
    public void setServ(UserService serv) {
        this.serv = serv;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> allUser = serv.getAllUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-main");
        modelAndView.addObject("users", allUser);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest req) {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User newUser = new User(name, email, password, role);
        serv.addUser(newUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public ModelAndView editPage(@RequestParam("id") Long id) {
        List<User> list = new ArrayList<>();
        list.add(serv.getUserById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("user-edit");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUser(HttpServletRequest req) {
        Long id = Long.parseLong(req.getParameter("id"));
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        User newUser = new User(id, name, email, password, role);
        serv.updateUser(newUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam("id") Long id) {
        serv.deleteUser(serv.getUserById(id));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

}
