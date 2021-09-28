package com.target.training.programs;

import com.target.training.entity.Customer;
import com.target.training.entity.Employee;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetAllOrdersOfOneCustomerAndEmployee {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            Customer c= em.find(Customer.class,"ALFKI");
            log.debug("Customer id is {}", c.getCustomerId());
            log.debug("The orders by this customer are: ");
            c.getOrderList().forEach(order -> System.out.println(order));

            Employee e= em.find(Employee.class,6);
            log.debug("Employee id is {}", e.getEmployeeId());
            log.debug("The orders of this employee are: ");
            e.getOrderList().forEach(order -> System.out.println(order));


        }finally {
            if(em!=null){
                em.close();
            }
        }

    }
}
