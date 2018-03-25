package com.java_practice.hibernate.main;

import com.java_practice.hibernate.model.EmployeeXmlMapping;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Date;


public class HibernateMain {
    public static void main(String[] args) {
        EmployeeXmlMapping emp = new EmployeeXmlMapping();
        emp.setName("Oleg");
        emp.setRole("CEO");
        emp.setInsertDate(new Date());

//        Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

//        Start transaction
        session.beginTransaction();

//        Save the Model object
        session.save(emp);


//        Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());


//        Terminate session factory, otherwise program won't end

        HibernateUtil.getSessionFactory().close();


    }
}
