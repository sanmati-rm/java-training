package com.target.training.programs;

import com.target.training.entity.OrderDetails;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetOrderDetails {
    public static void main(String[] args) {
        EntityManager em = null;
        try{

            em = JpaUtil.createEntityManager();
            TypedQuery<OrderDetails> qry = em.createQuery("from ORDER_DETAILS", OrderDetails.class);
            List<OrderDetails> list = qry.getResultList();
            list.forEach(System.out::println);

        }finally {
            if(em!=null){
                em.close();
            }
        }

    }
}
