package com.target.training.programs;

import com.target.training.entity.Customer;
import com.target.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetAllCustomers {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            TypedQuery<Customer> qry = em.createQuery("from Customer", Customer.class);
            List<Customer> list = qry.getResultList();
            list.forEach(System.out::println);

        }finally {
            if(em!=null){
                em.close();
            }
        }
    }
}
