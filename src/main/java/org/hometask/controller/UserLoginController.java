package org.hometask.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserLoginController {
    @RequestMapping("/login")
    public ModelAndView getLogin(Authentication authentication, HttpServletRequest request, ModelAndView model, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        if(authentication!=null){
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
                httpServletResponse.sendRedirect("/admin");
            }
            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("USER"))) {
                httpServletResponse.sendRedirect("/user");
            }
        }
        if (request.getParameterMap().containsKey("error")) {
            model.setViewName("user-login");
            model.addObject("status", "Не верная почта или пароль");
            return model;
        }
        model.setViewName("user-login");
        return model;
    }
}
