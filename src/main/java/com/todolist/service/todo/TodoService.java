package com.todolist.service.todo;

import com.todolist.model.todo.Todo;
import com.todolist.model.todo.TodoForm;

import java.util.List;

/**
 * Created by cemkaya on 10/07/16.
 */

public interface TodoService {

    List<Todo> getByStatusAndUserId(int status,long userid);
    Todo create(TodoForm form,long userid);
    Todo update(int status,long id);

}
