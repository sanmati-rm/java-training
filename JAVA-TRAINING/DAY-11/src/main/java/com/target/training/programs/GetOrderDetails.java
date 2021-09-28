package com.target.training.programs;

import com.target.training.entity.OrderDetails;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOrderDetails {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            OrderDetails orderDetails = em.find(OrderDetails.class, 10248);
            System.out.println(orderDetails.getOrderList().getOrderId());

        }finally {
            if(em!=null){
                em.close();
            }
        }

    }
}
