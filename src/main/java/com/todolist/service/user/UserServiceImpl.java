package com.todolist.service.user;

import com.todolist.model.user.User;
import com.todolist.model.user.UserForm;
import com.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

/**
 * Created by cemkaya on 03/07/16.
 */
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public Collection<User> getAllUsers() {
        return null;
    }

    @Override
    public User create(UserForm form) {
        return null;
    }
}
