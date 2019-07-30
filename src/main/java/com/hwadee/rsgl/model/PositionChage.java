package com.hwadee.rsgl.model;

public class PositionChage {
    private Integer number;

    private Integer employeeId;

    private String employeeName;

    private String oldMajor;

    private String newMajor;

    public PositionChage(Integer number, Integer employeeId, String employeeName, String oldMajor, String newMajor) {
        this.number = number;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.oldMajor = oldMajor;
        this.newMajor = newMajor;
    }

    public PositionChage() {
        super();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getOldMajor() {
        return oldMajor;
    }

    public void setOldMajor(String oldMajor) {
        this.oldMajor = oldMajor == null ? null : oldMajor.trim();
    }

    public String getNewMajor() {
        return newMajor;
    }

    public void setNewMajor(String newMajor) {
        this.newMajor = newMajor == null ? null : newMajor.trim();
    }
}