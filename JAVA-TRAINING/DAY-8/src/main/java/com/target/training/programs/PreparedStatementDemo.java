package com.target.training.programs;

import com.target.training.utils.DbUtil;
import com.target.training.utils.KeyboardUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Slf4j
public class PreparedStatementDemo {    //To prevent database from SQL injection
    public static void main(String[] args) {

        String sql = "insert into products values (?,?,?)";
        String choice;

        int id;
        String name;
        Double price;

        try(
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt= conn.prepareStatement(sql);
        )
        {
            do{
                try{
                    id= KeyboardUtil.getInt("Enter id:");
                    name = KeyboardUtil.getString("Enter name:");
                    price = KeyboardUtil.getDouble("Enter price: ");

                    stmt.setInt(1, id);
                    stmt.setString(2, name);
                    stmt.setDouble(3, price);

                    stmt.execute();
                }
                catch (Exception e){
                    log.warn("there was an error - {}",e.getMessage());
                }
                choice = KeyboardUtil.getString("want to add another?");
                if(choice.trim().equals("")){
                    choice = "yes";
                }

            }
            while (choice.equalsIgnoreCase("yes"));

        }
        catch(Exception e){
            log.error("error while acquiring db resources" ,e);
        }


    }
}
