package com.smarteinc.project.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public
class Employee1 {
    int id;

    String name;

    int age;

    boolean Status;

    String department;

    int yearOfJoining;

    double salary;

    String city;

    public Employee1(int id, String name, int age, boolean status, String department, int yearOfJoining, double salary, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.Status = status;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.city = city;
    }


}