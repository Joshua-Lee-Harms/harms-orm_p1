package com.revature.util.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            Properties props = new Properties();
            try {

                props.load(DBConnection.class.getClassLoader().getResourceAsStream("connection.properties"));

                String endpoint = props.getProperty("endpoint");
                String url = "jdbc:postgresql://" + endpoint + "/postgres";
                String username = props.getProperty("username");
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
            return conn;
    }
}
