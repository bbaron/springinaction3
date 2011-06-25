package com.github.springinaction3.ch01.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDaoJdbcLegacy implements EmployeeDao {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    private DataSource dataSource;
    
    public EmployeeDaoJdbcLegacy(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Employee getEmployeeById(long id) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = dataSource.getConnection();
            stmt = conn.prepareStatement("select id, firstname, lastname, salary from employee where id=?"); // <co
                                                                                                             // id="co_selectEmployee"/>
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            Employee employee = null;
            if (rs.next()) {
                employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setFirstName(rs.getString("firstname"));
                employee.setLastName(rs.getString("lastname"));
                employee.setSalary(rs.getBigDecimal("salary"));
            }

            return employee;
        } catch (SQLException e) {
            logger.error("Error executing query", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error("Error closing rs", e);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    logger.error("Error closing stmt", e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    logger.error("Error closing conn", e);
                }
            }

        }

        return null;
    }

}
