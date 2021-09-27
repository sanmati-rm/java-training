package com.target.training.programs;

import com.target.training.entity.Employee;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;

@Slf4j
public class GetEmployeeById {

    public static void main(String[] args) {

        Integer id = 600;

        EntityManager em = JpaUtil.createEntityManager();

        Employee emp = em.find(Employee.class, id);

        if(emp==null){
            log.debug("The id-{} does not exist", id);
        }
        else {
            log.debug("emp={}", emp);
        }
        em.close();
    }
}
