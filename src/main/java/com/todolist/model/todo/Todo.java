package com.todolist.model.todo;

import com.todolist.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by cemkaya on 02/07/16.
 */
@Entity
public class Todo extends BaseModel {

    public int UserId;
    public String Name;
    public String Content;
    public int Status;

    public Todo(){

    }


}
