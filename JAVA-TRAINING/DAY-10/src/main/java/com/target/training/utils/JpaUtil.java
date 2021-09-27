package com.target.training.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class JpaUtil {

    private JpaUtil(){

    }

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TRAINING");

    public static EntityManager createEntityManager(){

        return emf.createEntityManager();
    }

}
