package com.todolist.repository;

import com.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cemkaya on 02/07/16.
 */
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
