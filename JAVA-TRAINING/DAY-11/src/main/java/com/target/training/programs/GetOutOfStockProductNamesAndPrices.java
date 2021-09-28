package com.target.training.programs;

import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
public class GetOutOfStockProductNamesAndPrices {
    public static void main(String[] args) {
        String jpql = "select productName from Product where unitsInStock=0";
        String jpql1 = "select productName,unitPrice from Product where unitsInStock=0";

        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            TypedQuery<String> qry = em.createQuery(jpql, String.class);
            List<String> list = qry.getResultList();
            list.forEach(log::debug);

            TypedQuery<Object[]> qry1 = em.createQuery(jpql1, Object[].class);
            List<Object[]> list1 = qry1.getResultList();
            list1.forEach(arr -> log.debug("Name = {}, Price = {}", arr[0],arr[1]));

        }finally {
            if(em!=null){
                em.close();
            }
        }
    }

}
