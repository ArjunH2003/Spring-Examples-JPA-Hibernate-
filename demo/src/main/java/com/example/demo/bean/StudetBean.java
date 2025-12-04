package com.example.demo.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Student111")
public class StudetBean {

    @Id
    @GeneratedValue
    private int sid;
    private String name;
    private String email;
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    

    
}