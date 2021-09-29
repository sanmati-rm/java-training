package com.target.training.programs;

import com.target.training.entity.Shipper;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetAllOrdersOfOneShipper {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            Shipper s = em.find(Shipper.class, 1);
            log.debug("Shipper is = {}",s);
            log.debug("The orders shipped by this shipper are: ");
            s.getOrderList().forEach(o -> System.out.println(o));
        }finally {
            if(em!=null){
                em.close();
            }
        }
    }
}
