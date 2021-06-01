package com.example.restservice.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LocalDBConnection {

    private static Connection connection = null;

    static
    {
        String url = "jdbc:mysql://35.198.181.70:3306/SEP6";
        String user = "root";
        String password = "pwAEa20vt88zxy5a!xD";
        try
        {
            //Class.forName("com.mysql.jdbc.Driver"); not necessary
            connection = DriverManager.getConnection(url,user,password);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static  Connection getConnection()
    {
        return connection;
    }
}
