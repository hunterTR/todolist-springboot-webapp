package com.todolist;

import com.todolist.model.user.User;
import com.todolist.repository.UserRepository;
import com.todolist.service.user.UserService;
import com.todolist.service.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by cemkaya on 10/07/16.
 */
public class UserServiceTest {

    private UserService service;
    private UserRepository userRepository;

    @Before
    public void init(){
        userRepository = mock(UserRepository.class);
        service = new UserServiceImpl(userRepository);
    }


    @Test
    public void getUserByUsername_Test(){
        User user = new User();
        user.setUsername("username");

        when(userRepository.findOneByUsername("username")).thenReturn(Optional.of(user));

        User userFromRepo = service.getUserByUsername("username").get();
        Assert.assertEquals(user,userFromRepo);

    }

    @Test
    public void getUserById_Test(){
        User user = new User();
        user.setId(1l);

        when(userRepository.findOne(1l)).thenReturn(user);

        User userFromService = service.getUserById(1l);
        Assert.assertEquals(user,userFromService);
    }

    @Test
    public void getAllUsers_Test(){
        User user = new User();
        user.setId(1l);

        when(userRepository.findAll()).thenReturn(Arrays.asList(user));

        List<User> users = service.getAllUsers();

        Assert.assertEquals(users.size(),1);
    }

}
