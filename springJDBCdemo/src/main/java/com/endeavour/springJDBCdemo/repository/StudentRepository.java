package com.endeavour.springJDBCdemo.repository;

import com.endeavour.springJDBCdemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository
{
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String create(Student st)
    {
        String sql = """
                     INSERT INTO students(name, email, age) VALUES(?, ?, ?)
                     """;
        int rowsAffected = jdbcTemplate.update(sql, st.getName(), st.getEmail(), st.getAge());
        if(rowsAffected == 1)
        {
            return "DONE";
        }
        return "FAILED";
    }

    public Student get(long id)
    {
        String sql = """
                     SELECT id, name, email, age FROM students WHERE id=?
                     """;
        return jdbcTemplate
                .queryForObject(sql, new StudentRowMapper(), id);
    }

    public List<Student> getAll()
    {
        String sql = """
                     SELECT id, name, email, age FROM students
                     """;
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }

    public String update(Student st, long id)
    {
        String sql = """
                     UPDATE students SET name=?, email=?, age=? WHERE id=?
                     """;
        int rowsAffected = jdbcTemplate.update(sql, st.getName(), st.getEmail(), st.getAge(), id);
        if(rowsAffected == 1)
            return "DONE";
        else  return "FAILED";
    }

    public String delete(long id)
    {
        String sql = """
                     DELETE FROM students WHERE id=?
                     """;
        int rowsAffected = jdbcTemplate.update(sql, id);
        if(rowsAffected == 1)
            return "DONE";
        else  return "FAILED";
    }
}
