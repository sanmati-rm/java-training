package com.target.training.entity;

import com.target.training.exception.DaoException;
import com.target.training.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcContactsDao implements ContactsDao {


    @Override
    public void addContact(Contact contact) throws DaoException {
        String sql = "insert into contacts values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql); // first visit to db server for compiling sql command
        ) {
            stmt.setInt(1, contact.getId());
            stmt.setString(2, contact.getFirstname());
            stmt.setString(3, contact.getLastname());
            stmt.setString(4, contact.getGender().toString());
            stmt.setString(5, contact.getEmail());
            stmt.setString(6, contact.getPhone());
            stmt.setString(7, contact.getAddress());
            stmt.setString(8, contact.getCity());
            stmt.setString(9, contact.getState());
            stmt.setString(10, contact.getPincode());
            stmt.setString(11, contact.getCountry());
            stmt.setDate(12, contact.getBirthDate());
            stmt.execute();
        } catch (Exception e) {
            throw new DaoException(e); // wrapping "e" with a new instance of DaoException
        }

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

        List<Contact> list = new ArrayList<>();
        String sql = "select * from contacts";
        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                // convert data from result-set to a contact object
                Contact c = new Contact(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        Gender.valueOf(rs.getString("gender")),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("state"),
                        rs.getString("pincode"),
                        rs.getString("country"),
                        rs.getDate("dob")
                );
                list.add(c);
            }
        } catch (Exception e) {
            throw new DaoException(e); // wrapping "e" with a new instance of DaoException
        }
        return list;
    }

    @Override
    public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException {
        return null;
    }

}
