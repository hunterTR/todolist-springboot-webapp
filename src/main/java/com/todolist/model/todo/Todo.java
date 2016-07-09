package com.todolist.model.todo;

import com.todolist.model.BaseModel;

import javax.persistence.*;
import javax.print.attribute.DateTimeSyntax;
import java.util.Date;

/**
 * Created by cemkaya on 02/07/16.
 */
@Entity
@Table(name = "todo")
public class Todo extends BaseModel {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, unique = true)
    private long id;
    @Column(name = "Userid", nullable = false)
    public long userid;
    @Column(name = "Name")
    public String name;
    @Column(name = "Content")
    public String content;
    @Column(name = "Status")
    public int status;
    @Column(name = "CreateDate")
    public Date createdate;
    @Column(name = "UpdateDate")
    public Date updatedate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userid;
    }

    public void setUserId(long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }
}

