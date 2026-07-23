package com.endeavour.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRepository
{
    String url = "jdbc:mysql://localhost:3306/student";
    String name = "root";
    String password = "Priyansh@B787";

    public void createUser()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO students(name, email, age) VALUES ('Rohit', 'rohit123@gmail.com', 24)";
            int result = statement.executeUpdate(sql);
            if(result==1) System.out.println("Operation Successful");
            else System.out.println("Operation Failed");
            connection.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }
}
