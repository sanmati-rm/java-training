package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.training.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class GetProductsByPriceRange {

    public static void main(String[] args) {
        Double min = 50.0;
        Double max = 500.0;

        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            String jpql="from Product where unitPrice between ?0 and ?1 order by unitPrice desc";
            TypedQuery<Product> qry = em.createQuery(jpql, Product.class);
            qry.setParameter(0, min);
            qry.setParameter(1, max);
            List<Product> list = qry.getResultList();
            list.forEach(System.out::println);
        }finally {
            if(em!=null){
                em.close();
            }
        }

    }
}
