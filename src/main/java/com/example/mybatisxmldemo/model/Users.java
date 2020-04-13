package com.example.mybatisxmldemo.model;


import java.io.Serializable;

public class Users implements Serializable {

    private Long id;

    private String userName;

    private Integer sex;

    private String note;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public Users withId(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public Users withUserName(String userName) {
        this.setUserName(userName);
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }


    public Integer getSex() {
        return sex;
    }


    public Users withSex(Integer sex) {
        this.setSex(sex);
        return this;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getNote() {
        return note;
    }

    public Users withNote(String note) {
        this.setNote(note);
        return this;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", note=").append(note);
        sb.append("]");
        return sb.toString();
    }
}