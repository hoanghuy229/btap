package com.pm05.Servlet.model;

public class model {
    private String firstName;
    private String lastName;
    private String email;
    private String reenteredEmail;
    private String password;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private boolean sex;

    public model(){
    }
     public model(String firstName,String lastName,String email,String reenteredEmail,String password,int birthMonth,int birthDay,int birthYear, boolean sex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.reenteredEmail = reenteredEmail;
        this.password = password;
        this.birthMonth = birthMonth;
        this.birthDay = birthDay;
        this.birthYear = birthYear;
        this.sex = sex;
    }

    // Các phương thức getter và setter cho các thuộc tính

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReenteredEmail() {
        return reenteredEmail;
    }

    public void setReenteredEmail(String reenteredEmail) {
        this.reenteredEmail = reenteredEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
     public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
