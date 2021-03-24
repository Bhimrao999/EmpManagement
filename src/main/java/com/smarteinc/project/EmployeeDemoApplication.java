package com.smarteinc.project;

import com.smarteinc.project.controller.NonDFunctions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeDemoApplication.class, args);
    NonDFunctions db=new NonDFunctions();
    db.getemployee();

  }


}
