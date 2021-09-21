package com.target.training.programs;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import com.target.training.utils.DbUtil;

@Slf4j
public class ConnectToDatabase {

    @SneakyThrows
    public static void main(String[] args) {

//       String driverClassName = "org.h2.Driver";
//        String url="jdbc:h2:tcp://localhost/~/target_trainihg_db";
//        String username = "root";
//        String password = "root";

        log.debug("These JDBC drivers are registered");
        DriverManager.drivers().forEach(d->log.debug("{}",d.getClass().getName()));

       // Connection conn = DriverManager.getConnection(url,username,password);
        Connection conn = DbUtil.createConnection();
        log.debug("Conn is an instance of {}" , conn.getClass().getName());

    }
}
