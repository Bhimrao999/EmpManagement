package com.smarteinc.project.controller;


import com.smarteinc.project.model.Employee1;

import java.util.*;
import java.util.stream.Collectors;

public class NonDFunctions {


    List<Employee1> employeeList = new ArrayList<Employee1>();

    public void getemployee() {
        employeeList.add(new Employee1(111, "Jiya Brein", 32, "Female", "HR", 2011, 250000.0));
        employeeList.add(new Employee1(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 135000.0));
        employeeList.add(new Employee1(133, "Martin Theron", 29, "Male", "IT", 2012, 180000.0));
        employeeList.add(new Employee1(144, "Murali Gowda", 28, "Male", "IT", 2014, 325000.0));
        employeeList.add(new Employee1(155, "Nima Roy", 27, "Female", "HR", 2013, 227000.0));
        employeeList.add(new Employee1(166, "Iqbal Hussain", 43, "Male", "Sales And Marketing", 2016, 105000.0));
        employeeList.add(new Employee1(177, "Manu Sharma", 45, "Male", "IT", 2010, 270000.0));
        employeeList.add(new Employee1(188, "Wang Liu", 41, "Male", "HR", 2015, 345000.0));
        employeeList.add(new Employee1(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 115000.0));
        employeeList.add(new Employee1(200, "Jaden Dough", 48, "Male", "IT", 2015, 110000.5));
        employeeList.add(new Employee1(211, "Jasna Kaur", 27, "Female", "IT", 2014, 157000.0));
        employeeList.add(new Employee1(222, "Nitin Joshi", 45, "Male", "IT", 2016, 282000.0));
        employeeList.add(new Employee1(233, "Jyothi Reddy", 27, "Female", "IT", 2013, 213000.0));

        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n-------Employee Details ------------");
            System.out.println("  1.find employee in department");
            System.out.println("  2.find employees below a given age having CTC greater than 2 lakh.");
            System.out.println("  3. Exit the program...\n");
            System.out.println("Choose one:");
            choice = sc.nextInt();

            System.out.println("");
            switch (choice) {
                case 1:
                    System.out.println("");
                    System.out.println("enter the  age of employee to find how many employees present in given department");

                    int givenEmployeeAge = sc.nextInt();

                    Map<String, Long> employeeCountByDepartment =
                            employeeList.stream().filter(e -> e.getAge() > givenEmployeeAge).collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));

                    Set<Map.Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();

                    for (Map.Entry<String, Long> entry : entrySet) {
                        System.out.println(entry.getKey() + " : " + entry.getValue());
                    }
                    break;
                case 2:
                    System.out.println("enter age of employee");
                    int givenEmployeeAge1 = sc.nextInt();
                    Map<String, List<Employee1>> employeeListByDepartment =
                            employeeList.stream().filter(e -> e.getAge() < givenEmployeeAge1 && e.getSalary() > 200000).collect(Collectors.groupingBy(Employee1::getDepartment));

                    Set<Map.Entry<String, List<Employee1>>> entrySet1 = employeeListByDepartment.entrySet();

                    for (Map.Entry<String, List<Employee1>> entry : entrySet1) {
                        System.out.println("--------------------------------------");

                        System.out.println("Employees In " + entry.getKey() + " : ");

                        System.out.println("--------------------------------------");

                        List<Employee1> list = entry.getValue();

                        for (Employee1 employee1 : list) {
                            System.out.println(employee1.getName());
                        }

                    }
                    break;
                case 3:
                    return;

            }
        }


    }
}
