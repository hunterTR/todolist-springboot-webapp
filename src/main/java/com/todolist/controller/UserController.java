package com.todolist.controller;

import com.todolist.model.user.UserForm;
import com.todolist.model.user.UserFormValidator;
import com.todolist.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by cemkaya on 03/07/16.
 */
@Controller
public class UserController {
    private final UserService userService;
    private final UserFormValidator formValidator;

    @Autowired
    public UserController(UserService userService, UserFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.formValidator = userCreateFormValidator;
    }

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(formValidator);
    }


    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage(Model model) {

        return new ModelAndView("userCreate", "form", new UserForm());
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserForm(@Valid @ModelAttribute("form") UserForm form, BindingResult bindingResult,Authentication authentication) {

        if (bindingResult.hasErrors()) {
            return "userCreate";
        }
        try {

            userService.create(form);
        } catch (DataIntegrityViolationException e) {
            bindingResult.reject("username.exists", "username already exists");
            return "userCreate";
        }
        return "redirect:/";
    }



    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error,Authentication authentication) {
        if(authentication != null)
        {
            return new ModelAndView("home");
        }
        return new ModelAndView("login", "loginError", error.isPresent());
    }



}
