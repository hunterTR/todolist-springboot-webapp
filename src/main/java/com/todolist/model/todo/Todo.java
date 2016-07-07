package com.todolist.model.todo;

import com.todolist.model.BaseModel;

import javax.persistence.*;

/**
 * Created by cemkaya on 02/07/16.
 */
@Entity
@Table(name = "todo")
public class Todo extends BaseModel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, unique = true)
    private long Id;
    @Column(name = "Userid", nullable = false)
    public long UserId;
    @Column(name = "Name")
    public String Name;
    @Column(name = "Content")
    public String Content;
    @Column(name = "Status")
    public int Status;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        this.UserId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        this.Status = status;
    }



}
