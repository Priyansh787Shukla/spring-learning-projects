package com.endeavour.springJDBCdemo.repository;

import com.endeavour.springJDBCdemo.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student>
{

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Student st = new Student();
        st.setId(rs.getLong("id"));
        st.setName(rs.getString("name"));
        st.setEmail(rs.getString("email"));
        st.setAge(rs.getInt("age"));
        return st;
    }
}
