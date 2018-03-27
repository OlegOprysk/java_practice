package com.olegoprysk.jpa.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    private int employeeId;

    private String name;


    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    @Column(name = "employee_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Employee [employeeId= " + employeeId + ", name= " + name + "]";
    }
}
