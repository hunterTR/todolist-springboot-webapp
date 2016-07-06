package com.todolist.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by cemkaya on 03/07/16.
 */
@MappedSuperclass
public class BaseModel {
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long Id;
}
