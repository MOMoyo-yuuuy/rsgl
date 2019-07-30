package com.hwadee.rsgl.model;

public class Math {
    private Integer employeeId;

    private String employeeName;

    private Integer grade;

    private Integer courseAmount;

    private Integer class1;

    private Integer class2;

    private Integer class3;

    private Integer class4;

    public Math(Integer employeeId, String employeeName, Integer grade, Integer courseAmount, Integer class1, Integer class2, Integer class3, Integer class4) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.grade = grade;
        this.courseAmount = courseAmount;
        this.class1 = class1;
        this.class2 = class2;
        this.class3 = class3;
        this.class4 = class4;
    }

    public Math() {
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCourseAmount() {
        return courseAmount;
    }

    public void setCourseAmount(Integer courseAmount) {
        this.courseAmount = courseAmount;
    }

    public Integer getClass1() {
        return class1;
    }

    public void setClass1(Integer class1) {
        this.class1 = class1;
    }

    public Integer getClass2() {
        return class2;
    }

    public void setClass2(Integer class2) {
        this.class2 = class2;
    }

    public Integer getClass3() {
        return class3;
    }

    public void setClass3(Integer class3) {
        this.class3 = class3;
    }

    public Integer getClass4() {
        return class4;
    }

    public void setClass4(Integer class4) {
        this.class4 = class4;
    }
}