package com.todolist.controller;

import com.todolist.model.todo.Todo;
import com.todolist.model.todo.TodoForm;
import com.todolist.model.user.CurrentUser;
import com.todolist.repository.TodoRepository;
import org.omg.CORBA.Current;
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

import java.util.Date;
import java.util.List;

/**
 * Created by cemkaya on 06/07/16.
 */
@Controller
public class TodoController {


    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository)
    {
        this.todoRepository = todoRepository;
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

        List<Todo> todoList = todoRepository.findByStatusAndUserid(1,currentUser.getId());
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


        List<Todo> todoList = todoRepository.findByStatusAndUserid(2,currentUser.getId());
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
            Todo todo = new Todo();
            todo.setName(form.getName());
            todo.setContent(form.getContent());
            todo.setUserId(currentUser.getId());
            todo.setStatus(1);
            todo.setCreatedate(new Date());
            todoRepository.save(todo);
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
            Todo todo = todoRepository.findOne(id);
            todo.setStatus(2);
            todo.setUpdatedate(new Date());
            todoRepository.save(todo);
        } catch (DataIntegrityViolationException e) {
            return "todoCreate";
        }
        return "redirect:/todo/ongoing";
    }
}
