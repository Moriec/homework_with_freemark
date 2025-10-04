package com.vinogradov.demo7.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static Connection conn;

    public static void main(String[] args) {
        System.out.print(getConnection());
    }

    public static Connection getConnection() {
        try {
            if (conn == null) {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/oris_practice", "postgres", "1234"
                );
            }
            return conn;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
