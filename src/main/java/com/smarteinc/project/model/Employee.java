package com.smarteinc.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "age")
    private int age;
    @Column(name = "CTC")
    private int CTC;
    @Column(name = "JOIdate")
    @Temporal(TemporalType.DATE)
    private Date JOIdate;
    @Column(name = "status")
    private boolean status;


    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;


}
