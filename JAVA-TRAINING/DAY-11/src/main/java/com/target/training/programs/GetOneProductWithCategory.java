package com.target.training.programs;

import com.target.training.entity.Product;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
public class GetOneProductWithCategory {
    public static void main(String[] args) {
        EntityManager em = null;
        try{
            em= JpaUtil.createEntityManager();
            Product p = em.find(Product.class,12);
            log.debug("Product Category is {}",p.getCategory().getCategoryName());
            FileOutputStream file = new FileOutputStream(p.getCategory().getCategoryName()+".png");
            file.write(p.getCategory().getPicture());
            file.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally {
            if(em!=null){
                em.close();
            }
        }
    }
}
