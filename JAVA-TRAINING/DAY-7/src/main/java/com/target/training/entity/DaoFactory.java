package com.target.training.entity;

import com.target.training.exception.DaoException;

import java.util.ResourceBundle;

public class DaoFactory {

    private DaoFactory() {
    }

    private static ContactsDao dao = null;

    public static ContactsDao getContactsDao() throws DaoException {

        if (dao != null) return dao;

        ResourceBundle rb = ResourceBundle.getBundle("contacts-dao");
        String discriminator = rb.getString("discriminator");

        switch (discriminator.toLowerCase()) {
            case "arraylist":
                dao = new ArrayListContactsDao();
                break;
            case "jdbc": dao= new JdbcContactsDao();
                    break;
            case "hashmap":
                // dao= new HashMapProductDao(); break;
            case "csv":
                // dao= new CsvProductDao(); break;
            case "jpa":
                // dao= new JpaProductDao(); break;
            default:
                throw new DaoException("Request for unknown type of implementation for ProductDao");
        }
        return dao;
    }
}
