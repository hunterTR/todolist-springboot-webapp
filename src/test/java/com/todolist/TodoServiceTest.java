package com.todolist;

import com.todolist.model.todo.Todo;
import com.todolist.repository.TodoRepository;
import com.todolist.service.todo.TodoServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by cemkaya on 10/07/16.
 */
public class TodoServiceTest {

    private TodoServiceImpl service;
    private TodoRepository todoRepository;

    @Before
    public void init(){
        todoRepository = mock(TodoRepository.class);
        service = new TodoServiceImpl(todoRepository);
    }

    @Test
    public void getByStatusAndUserId_Test(){
        Todo todo = new Todo();
        todo.setId(1l);

        when(todoRepository.findByStatusAndUserid(1,1l)).thenReturn(Arrays.asList(todo));

        List<Todo> todoList = service.getByStatusAndUserId(1,1l);

        Assert.assertEquals(todoList.size(),1);
    }


}
