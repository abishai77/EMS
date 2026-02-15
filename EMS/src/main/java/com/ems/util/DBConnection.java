package com.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ems_db?useSSL=false&serverTimezone=UTC",
                    "root",
                    "Abishai@1701"
            );

            System.out.println("DB CONNECTED SUCCESSFULLY");

        } catch (Exception e) {
            System.out.println("DB CONNECTION FAILED");
            e.printStackTrace();
        }
        return con;
    }
}