package com.todolist.repository;

import com.todolist.model.todo.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cemkaya on 02/07/16.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> {
}
