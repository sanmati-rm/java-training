package com.target.training.programs;

import com.target.training.entity.Supplier;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneSupplierAndItsProducts {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            Supplier s = em.find(Supplier.class, 2);
            log.debug("Supplier name is = {}",s.getCompanyName());
            log.debug("The Products supplied by this supplier are: ");
            s.getProductList().forEach(p -> System.out.println(p));
        }finally {
            if(em!=null){
                em.close();
            }
        }
    }
}
