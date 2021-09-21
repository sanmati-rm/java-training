package com.target.training.programs;

import com.target.training.utils.DbUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.Statement;

@Slf4j
public class CreateProductsTable {

    @SneakyThrows
    public static void main(String[] args) {

        String cmd = "create table products(\n" +
                " id integer primary key,\n" +
                " name varchar(50) not null,\n" +
                " price double\n" +
                ")";

        try(
                Connection conn = DbUtil.createConnection();
                Statement stat = conn.createStatement();
                ){
            stat.execute(cmd);
            log.debug("SQL command executed successfully on H2 server");
        }
        catch (Exception e)
        {
            log.error("There was an error", e);
        }
    }
}
