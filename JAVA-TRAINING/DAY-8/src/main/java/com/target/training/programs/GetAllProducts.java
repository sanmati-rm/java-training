package com.target.training.programs;

import com.target.training.utils.DbUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class GetAllProducts {

    @SneakyThrows
    public static void main(String[] args) {
        String sql = "select * from products";
        try(
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                ){
            while ( rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                log.debug("id = {}, name = {}, price = {}", id,name,price);
            }
        }
    }
}
