package com.todolist.service.todo;

import com.todolist.model.todo.Todo;
import com.todolist.model.todo.TodoForm;
import com.todolist.repository.TodoRepository;
import com.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cemkaya on 10/07/16.
 */
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getByStatusAndUserId(int status,long userid) {
        return todoRepository.findByStatusAndUserid(status,userid);
    }

    @Override
    public Todo create(TodoForm form,long userid) {
        Todo todo = new Todo();
        todo.setName(form.getName());
        todo.setContent(form.getContent());
        todo.setUserId(userid);
        todo.setStatus(1);
        todo.setCreatedate(new Date());
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(int status,long id) {

        Todo todo = todoRepository.findOne(id);
        todo.setStatus(status);
        todo.setUpdatedate(new Date());

        return todoRepository.save(todo);
    }
}
