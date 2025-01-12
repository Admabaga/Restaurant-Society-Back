package com.project.RestaurantSociety.Entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    @Column(unique = true)
    private String userMail;
    private String password;
    private String phoneNumber;

    public User() {
    }

    public User(Long userId, String userName, String userMail, String password, String phoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userMail = userMail;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMail='" + userMail + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
