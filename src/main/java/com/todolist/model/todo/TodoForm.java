package com.todolist.model.todo;

/**
 * Created by cemkaya on 06/07/16.
 */
public class TodoForm {
    private String name;
    private String content;
    private int status;


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
}
