package com.github.springinaction3.ch01.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class EmployeeDaoJdbcSpring implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDaoJdbcSpring(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee getEmployeeById(final long id) {
        return jdbcTemplate.execute("select id, firstname, lastname, salary from employee where id=?", new PreparedStatementCallback<Employee>() {

            public Employee doInPreparedStatement(PreparedStatement stmt) throws SQLException, DataAccessException {

                stmt.setLong(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("id"));
                    employee.setFirstName(rs.getString("firstname"));
                    employee.setLastName(rs.getString("lastname"));
                    employee.setSalary(rs.getBigDecimal("salary"));
                    return employee;
                }
                return null;
            }
        });
    }

}
