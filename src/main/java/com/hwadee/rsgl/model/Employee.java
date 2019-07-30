package com.hwadee.rsgl.model;

import java.util.Date;

public class Employee {
    private Integer employeeId;

    private String employeeName;

    private Date entryTime;

    private String position;

    private String major;

    private String telephoneNumber;

    private String mail;

    private String location;

    private String file;

    private Integer salary;

    private String gender;

    private String password;

    public Employee(Integer employeeId, String employeeName, Date entryTime, String position, String major, String telephoneNumber, String mail, String location, String file, Integer salary, String gender, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.entryTime = entryTime;
        this.position = position;
        this.major = major;
        this.telephoneNumber = telephoneNumber;
        this.mail = mail;
        this.location = location;
        this.file = file;
        this.salary = salary;
        this.gender = gender;
        this.password = password;
    }

    public Employee() {
        super();
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName == null ? null : employeeName.trim();
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber == null ? null : telephoneNumber.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file == null ? null : file.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}