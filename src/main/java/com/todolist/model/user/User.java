package com.todolist.model.user;

import com.todolist.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cemkaya on 03/07/16.
 */

@Entity
@Table(name = "users")
public class User{


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false, unique = true)
    private long id;
    @Column(name = "Username", nullable = false, unique = true)
    private String username;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Email" , unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "CreateDate")
    public Date createdate;
    @Column(name = "UpdateDate")
    public Date updatedate;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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


