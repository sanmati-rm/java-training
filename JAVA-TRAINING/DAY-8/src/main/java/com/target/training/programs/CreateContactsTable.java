package com.target.training.programs;

import com.target.training.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class CreateContactsTable {

    public static void main(String[] args) {
        String cmd = "create table contacts(\n" +
                " id integer primary key,\n" +
                " firstname varchar(50) not null,\n" +
                " lastname varchar(50),\n" +
                " gender varchar(10),\n" +
                " email varchar(50),\n" +
                " phone varchar(50),\n" +
                " address varchar(50),\n " +
                " city varchar(50) default 'Bangalore',\n" +
                " state varchar(50) default 'Karnataka',\n" +
                " pincode varchar(50),\n" +
                " country varchar(50) default 'India',\n " +
                "dob date\n" +
                ")";

        try(
                Connection conn = DbUtil.createConnection();
                Statement stat = conn.createStatement();
        ){
            stat.execute(cmd);
            log.debug("SQL command executed successfully on database server");
        }
        catch (Exception e)
        {
            log.error("There was an error", e);
        }
    }
}
