package com.todolist.model.user;

import com.todolist.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by cemkaya on 03/07/16.
 */

@Entity
@Table(name = "users")
public class User extends BaseModel {

    public String Username;
    public String Password;
}
