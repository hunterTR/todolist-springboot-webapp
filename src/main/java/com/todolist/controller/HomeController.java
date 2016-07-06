package com.todolist.controller;

import com.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by cemkaya on 02/07/16.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home(Authentication authentication) {
        UserDetails currentUser = null;
        if(authentication != null)
        {
            currentUser = (UserDetails) authentication.getPrincipal();
        }


        return new ModelAndView("home", "user", currentUser);
    }
}
