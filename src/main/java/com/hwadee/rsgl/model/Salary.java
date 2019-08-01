package com.hwadee.rsgl.model;

public class Salary {
    private int chinese;
    private int coding;
    private int english;
    private int math;
    private int pe;
    private int master;
    private int teacher;
    private int oldTeacher;
    private int manager;

    public int getChinese() {
        return chinese;
    }
    public void setChinese(int chinese) {
        this.chinese = chinese;
    }
    public int getCoding() {
        return coding;
    }
    public void setCoding(int coding) {
        this.coding = coding;
    }
    public int getEnglish() {
        return english;
    }
    public void setEnglish(int english) {
        this.english = english;
    }
    public int getMath() {
        return math;
    }
    public void setMath(int math) {
        this.math = math;
    }
    public int getPe() {
        return pe;
    }
    public void setPe(int pe) {
        this.pe = pe;
    }
    public int getMaster() {
        return master;
    }
    public void setMaster(int master) {
        this.master = master;
    }
    public int getTeacher() {
        return teacher;
    }
    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }
    public int getOldTeacher() {
        return oldTeacher;
    }
    public void setOldTeacher(int oldTeacher) {
        this.oldTeacher = oldTeacher;
    }
    public int getManager() {
        return manager;
    }
    public void setManager(int manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "chinese=" + chinese +
                ", coding=" + coding +
                ", english=" + english +
                ", math=" + math +
                ", pe=" + pe +
                ", master=" + master +
                ", teacher=" + teacher +
                ", oldTeacher=" + oldTeacher +
                ", manager=" + manager +
                '}';
    }
}
