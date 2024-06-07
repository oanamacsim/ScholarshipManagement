package org.example.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
    private static final String URL = "jdbc:mysql://localhost:3306/scholarship_manager";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "adminadmin";
    private static Connection connection = null;

    private DatabaseConnection() {} // Private constructor to prevent instantiation

    public static Connection getConnection() throws SQLException
    {
        if (connection == null || connection.isClosed())
        {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return connection;
    }
}

