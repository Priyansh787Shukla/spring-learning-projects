package com.endeavour.repository;

import com.endeavour.model.Student;

import java.sql.*;

public class StudentRepository
{
    String url = "jdbc:mysql://localhost:3306/student";
    String name = "root";
    String password = "Priyansh@B787";

    public void createUser(Student student)
    {
        String sql = """
                     INSERT INTO students(name, email, age)
                     VALUES(?, ?, ?)
                     """;
        try(Connection connection = DriverManager.getConnection(url, name, password); PreparedStatement pst = connection.prepareStatement(sql))
        {
            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setInt(3, student.getAge());
            int res = pst.executeUpdate();
            if(res==1) System.out.println("Student created successfully");
            else System.out.println("Student not created");
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }

    public void updateUser(Student student, long id)
    {
        String sql = """
                     UPDATE students SET name = ?, email = ?, age = ? WHERE id = ?
                     """;
        try(Connection connection = DriverManager.getConnection(url, name, password); PreparedStatement pst = connection.prepareStatement(sql))
        {
            pst.setString(1, student.getName());
            pst.setString(2, student.getEmail());
            pst.setInt(3, student.getAge());
            pst.setLong(4, id);
            int res = pst.executeUpdate();
            if(res==1) System.out.println("Student updated successfully");
            else System.out.println("Student not updated");
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }

    public void deleteUser(long id)
    {
        String sql = """
                     DELETE FROM students WHERE id=?
                     """;
        try(Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement pst = connection.prepareStatement(sql))
        {
            pst.setLong(1, id);
            int res = pst.executeUpdate();
            if(res==1) System.out.println("Student deleted successfully");
            else System.out.println("Student not deleted");
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }

    public void getUserById(long id)
    {
        String sql = """
                     SELECT id, name, email, age FROM STUDENTS WHERE id=?
                     """;
        try(Connection connection = DriverManager.getConnection(url, name, password);
            PreparedStatement pst = connection.prepareStatement(sql))
        {
            pst.setLong(1, id);
            ResultSet res = pst.executeQuery();
            System.out.println(getStudent(res));
        }
        catch(SQLException e)
        {
            System.out.println("Database Connection Failed");
            e.printStackTrace();
        }
    }

    private Student getStudent(ResultSet result) throws SQLException
    {
        result.next();
        Student student = new Student();
        student.setId(result.getLong(1));
        student.setName(result.getString(2));
        student.setEmail(result.getString(3));
        student.setAge(result.getInt(4));
        return student;
    }
}















