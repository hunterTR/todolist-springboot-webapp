package com.todolist.controller;

import com.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cemkaya on 02/07/16.
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){

        return "home";
    }
}
