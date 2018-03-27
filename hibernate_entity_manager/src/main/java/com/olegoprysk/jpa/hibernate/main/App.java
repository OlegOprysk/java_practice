package com.olegoprysk.jpa.hibernate.main;

import com.olegoprysk.jpa.hibernate.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        System.out.println("Starting Transaction");

        entityManager.getTransaction().begin();

        Employee employee = new Employee();

        employee.setName("Oleg");

        System.out.println("Saving Employee to Database");


        entityManager.persist(employee);

        entityManager.getTransaction().commit();

        System.out.println("Generated Employee ID = " + employee.getEmployeeId());


//        Get an object using primary key.
        Employee emp = entityManager.find(Employee.class, employee.getEmployeeId());

        System.out.println("got object " + emp.getName() + " " + emp.getEmployeeId());


//        get all the objects from Employee table
        @SuppressWarnings("unchecked")
        Optional<List<Employee>> resultList = Optional.ofNullable(entityManager.createQuery("SELECT e from Employee e").getResultList());
        if (!resultList.isPresent()) {
            System.out.println("No employee found . ");
        } else {
            resultList.get().stream().map(e -> "Employee name= " + e.getName() + ", Employee id " + e.getEmployeeId()).forEach(System.out::println);
        }


//        remove an entity
        entityManager.getTransaction().begin();
        System.out.println("Deleting Employee with ID = " + emp.getEmployeeId());

        entityManager.remove(emp);
        entityManager.getTransaction().commit();


//        close the entity manager
        entityManager.close();
        entityManagerFactory.close();



    }
}
