package com.todolist.model.user;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by cemkaya on 03/07/16.
 */
public class UserForm {
    @NotEmpty
    private String username = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";
}
