package com.java_practice.hibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Employee",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true, length = 11)
    private int id;


    @Column(name = "NAME", length = 20, nullable = true)
    private String name;

    @Column(name = "ROLE", length = 20, nullable = true)
    private String role;

    @Column(name = "insert_time", nullable = true)
    private Date insertDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
}
