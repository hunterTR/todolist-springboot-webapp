package com.todolist.service.user;

import com.todolist.model.user.User;
import com.todolist.model.user.UserForm;
import java.util.Collection;

/**
 * Created by cemkaya on 03/07/16.
 */
public interface UserService {
    User getUserById(long id);
    User getUserByEmail(String email);
    Collection<User> getAllUsers();
    User create(UserForm form);
}
