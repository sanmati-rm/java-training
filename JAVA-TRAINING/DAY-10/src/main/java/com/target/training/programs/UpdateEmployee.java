package com.target.training.programs;

import com.target.training.entity.Employee;
import com.target.training.utils.DateUtil;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Slf4j
public class UpdateEmployee {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.createEntityManager();
        Employee emp = em.find(Employee.class, 2);

        log.debug("emp={}",emp);

        emp.setHireDate(DateUtil.toDate("2010-04-12"));

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        tx.commit();
        //em.merge(emp);
        em.close();
    }


}
