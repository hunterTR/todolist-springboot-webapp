package com.todolist.repository;

import com.todolist.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cemkaya on 03/07/16.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByUsername(String username);
}
