package com.target.training.programs;

import com.target.training.entity.Order;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetCustomerAndEmployeeOfParticularOrder {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            Order o = em.find(Order.class,10249);
            log.debug("Order is {}", o);
            log.debug("The customer of this order is:");
            log.debug(String.valueOf(o.getCustomerId()));
            log.debug("The employee of this order is:");
            log.debug(o.getEmployeeId().getFirstname());


        }finally {
            if(em!=null){
                em.close();
            }
        }

    }
}
