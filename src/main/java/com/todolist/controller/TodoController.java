package com.todolist.controller;

import com.todolist.model.todo.Todo;
import com.todolist.model.todo.TodoForm;
import com.todolist.model.user.CurrentUser;
import com.todolist.service.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * Created by cemkaya on 06/07/16.
 */
@Controller
public class TodoController {



    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService)
    {
        this.todoService = todoService;
    }

    @RequestMapping(value = "/todo/ongoing",method = RequestMethod.GET)
    public ModelAndView ongoing(Authentication authentication) {
        CurrentUser currentUser = null;

        if(authentication != null)
        {
             currentUser = (CurrentUser) authentication.getPrincipal();
        }
        else
        {
            return new ModelAndView("home");
        }

        List<Todo> todoList = todoService.getByStatusAndUserId(1,currentUser.getId());
        ModelAndView modelAndView = new ModelAndView("todo");
        modelAndView.addObject("todoList",todoList);
        modelAndView.addObject("user",currentUser);
        return modelAndView;
    }

    @RequestMapping(value = "/todo/done",method = RequestMethod.GET)
    public ModelAndView done(Authentication authentication) {
        CurrentUser currentUser = null;

        if(authentication != null)
        {
            currentUser = (CurrentUser) authentication.getPrincipal();
        }
        else
        {
            return new ModelAndView("home");
        }


        List<Todo> todoList = todoService.getByStatusAndUserId(2,currentUser.getId());
        ModelAndView modelAndView = new ModelAndView("todo");
        modelAndView.addObject("todoList",todoList);
        modelAndView.addObject("user",currentUser);
        return modelAndView;
    }




    @RequestMapping(value = "/todo/create",method = RequestMethod.GET)
    public ModelAndView createTodo(Authentication authentication) {
        UserDetails currentUser = null;
        if(authentication != null)
        {
            currentUser = (UserDetails) authentication.getPrincipal();
        }
        else
        {
            return new ModelAndView("home");
        }

        ModelAndView modelAndView = new ModelAndView("todoCreate");
        modelAndView.addObject("user",currentUser);
        modelAndView.addObject("form",new TodoForm());
        return modelAndView;
    }

    @RequestMapping(value = "/todo/create", method = RequestMethod.POST)
    public String handleTodoForm(@ModelAttribute("form") TodoForm form, Authentication authentication) {
        if(authentication == null)
        {
            return "redirect:/";
        }
        try {
            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            todoService.create(form,currentUser.getId());
        } catch (DataIntegrityViolationException e) {
            return "todoCreate";
        }
        return "redirect:/todo/ongoing";
    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.GET)
    public String updateTodo(@RequestParam long id, Authentication authentication) {
        if(authentication == null)
        {
            return "redirect:/";
        }
        try {
            CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
            todoService.update(2,id);

        } catch (DataIntegrityViolationException e) {
            return "todoCreate";
        }
        return "redirect:/todo/ongoing";
    }
}
