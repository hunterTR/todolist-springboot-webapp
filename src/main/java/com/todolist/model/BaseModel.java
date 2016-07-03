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
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Id;
}
