package com.target.training.entity;

import java.util.Date;
import java.util.List;
import com.target.training.exception.DaoException;
import com.target.training.utils.JpaUtil;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

@Slf4j
public class JpaContactsDao implements ContactsDao{

    @Override
    public void addContact(Contact contact) throws DaoException {

        EntityManager em = JpaUtil.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            em.persist(contact);
            tx.commit();
            log.debug("Contacts data saved", contact);
        }catch (Exception e){
            tx.rollback();
            log.error("Couldn't save contacts data",e);
        }

        em.close();


    }

    @Override
    public Contact getContact(int id) throws DaoException {
        return null;
    }

    @Override
    public void updateContact(Contact contact) throws DaoException {

    }

    @Override
    public void deleteContact(int id) throws DaoException {

    }

    @Override
    public Contact getContactByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public Contact getContactByPhone(String phone) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContactsByLastname(String lastname) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContactsByCity(String city) throws DaoException {
        return null;
    }

    @Override
    public List<Contact> getContacts() throws DaoException {

        String jpql = "from contacts";
        EntityManager em = JpaUtil.createEntityManager();
        TypedQuery<Contact> qry = em.createQuery(jpql, Contact.class);
        return qry.getResultList();


    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        return null;
    }
}
