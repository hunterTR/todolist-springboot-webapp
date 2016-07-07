package com.todolist.controller;

import com.todolist.model.todo.Todo;
import com.todolist.model.todo.TodoForm;
import com.todolist.model.user.CurrentUser;
import com.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by cemkaya on 06/07/16.
 */
@Controller
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/todo",method = RequestMethod.GET)
    public ModelAndView getTodoList(Authentication authentication) {
        UserDetails currentUser = null;

        if(authentication != null)
        {
            currentUser = (UserDetails) authentication.getPrincipal();
        }
        else
        {
            return new ModelAndView("home");
        }

        List<Todo> todoList = todoRepository.findAll();
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
            todoRepository.save(todo);
        } catch (DataIntegrityViolationException e) {
            return "todoCreate";
        }
        return "redirect:/todo";
    }
}
