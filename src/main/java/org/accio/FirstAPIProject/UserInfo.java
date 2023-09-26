package org.accio.FirstAPIProject;

public class UserInfo {
    private int userId;
    private String name;
    private int age;
    private String emailId;

    public UserInfo(int userId, String name, int age, String emailId) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}