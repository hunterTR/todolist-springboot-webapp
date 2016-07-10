package com.todolist.repository;

import com.todolist.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by cemkaya on 03/07/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findOneByUsername(String username);
}
