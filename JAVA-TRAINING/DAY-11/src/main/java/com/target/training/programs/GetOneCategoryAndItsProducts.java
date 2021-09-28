package com.target.training.programs;

import com.target.training.entity.Category;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetOneCategoryAndItsProducts {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            Category c = em.find(Category.class, 1);
            log.debug("Category name is = {}",c.getCategoryName());
            log.debug("The Products in this category are: ");
            c.getProductList().forEach(p -> System.out.println(p));
        }finally {
            if(em!=null){
                em.close();
            }
        }
    }
}
