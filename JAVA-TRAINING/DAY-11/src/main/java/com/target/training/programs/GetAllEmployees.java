package com.target.training.programs;

import com.target.training.entity.Employee;
import com.target.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetAllEmployees {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            TypedQuery<Employee> qry = em.createQuery("from Employee", Employee.class);
            List<Employee> list = qry.getResultList();
            list.forEach(System.out::println);

        }finally {
            if(em!=null){
                em.close();
            }
        }
    }
}
