package com.smarte.project.model;

import javax.persistence.*;

@Entity(name = "Dept")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    @Column(name = "deptName")
    private String deptName;
    @Column(name = "region")
    private String region;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    public Department() {
    }

    public Department(int deptId, String deptName, String region) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.region = region;
    }
}