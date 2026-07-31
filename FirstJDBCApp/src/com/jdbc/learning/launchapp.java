package com.jdbc.learning;
import java.sql.*;

public class launchapp
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded");
        String user = "root";
        String pass = "Priyansh@B787";
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        Connection connect = DriverManager.getConnection(url, user, pass);
        System.out.println("Connection Established");
        Statement statement = connect.createStatement();
        String sql = "UPDATE studentinfo SET sage = 13 WHERE id = 2";
        int raf = statement.executeUpdate(sql);
        if(raf>0)
            System.out.println("Record Inserted");
        else
            System.out.println("Record Not Inserted");
        sql = "SELECT * FROM studentinfo";
        ResultSet rs = statement.executeQuery(sql);
        statement.close();
        connect.close();



        /*//Load and Register the Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish the connection
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        user = "root";
        String password = "Priyansh@B787";
        Connection connect = DriverManager.getConnection(url, user, password);

        //creating statement
        Statement statement = connect.createStatement();

        //execute the query
        String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(3, 'Roh', 18, 'Bengaluru')";
        int rowsaffected = statement.executeUpdate(sql);
        //process the result
        if (rowsaffected > 0)
            System.out.println("Record inserted successfully");
        else
            System.out.println("Record not inserted");

        //close the resources
        statement.close();
        connect.close();*/
    }
}
