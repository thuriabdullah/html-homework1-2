package com.example.demo.User;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String fullName;
    private String userName;
    private int password;
    private int age;
    private Date creationDate;
    private boolean status;
    public User(){}
    public User(Long userId, String fullName, String userName, int password, int age, Date creationDate, boolean status) {
        this.userId = userId;
        this.fullName = fullName;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.creationDate = creationDate;
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
