package com.todolist.service.user;

import com.todolist.model.user.User;
import com.todolist.model.user.UserForm;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by cemkaya on 03/07/16.
 */
public interface UserService {
    User getUserById(long id);
    Optional<User> getUserByUsername(String email);
    List<User> getAllUsers();
    User create(UserForm form);
}
