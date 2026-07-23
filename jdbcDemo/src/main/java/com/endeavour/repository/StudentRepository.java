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
            if(result==1) System.out.println("Create Operation Successful");
            else System.out.println("Create Operation Failed");
            connection.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }

    public void updateUser()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            String sql = "UPDATE students SET age=31 WHERE id=1";
            int result = statement.executeUpdate(sql);
            if(result==1) System.out.println("Update Operation Successful");
            else System.out.println("Update Operation Failed");
            connection.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }

    public void deleteUser()
    {
        try
        {
            Connection connection = DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM students WHERE id=2";
            int result = statement.executeUpdate(sql);
            if(result==1) System.out.println("Delete Operation Successful");
            else System.out.println("Delete Operation Failed");
            connection.close();
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }
}















