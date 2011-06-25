package com.github.springinaction3.ch01.jdbc;

import javax.sql.DataSource;

public class EmployeeDaoJdbcLegacyTest extends EmployeeDaoJdbcTest {

    @Override
    protected EmployeeDao newEmployeeDao(DataSource dataSource) {
        return new EmployeeDaoJdbcLegacy(dataSource);
    }
}
