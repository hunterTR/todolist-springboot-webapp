package com.todolist.repository;

import com.todolist.model.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cemkaya on 02/07/16.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
    List<Todo> findByStatusAndUserid(int status,long userid);
}
