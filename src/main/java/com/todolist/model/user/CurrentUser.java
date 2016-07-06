package com.todolist.model.user;

import org.springframework.security.core.authority.AuthorityUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by cemkaya on 06/07/16.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}


