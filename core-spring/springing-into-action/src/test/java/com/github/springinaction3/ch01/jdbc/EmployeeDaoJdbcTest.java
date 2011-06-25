package com.github.springinaction3.ch01.jdbc;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.junit.Test;

public abstract class EmployeeDaoJdbcTest {
    private DataSource dataSource = mock(DataSource.class);
    private Connection conn = mock(Connection.class);
    private PreparedStatement stmt = mock(PreparedStatement.class);
    private ResultSet rs = mock(ResultSet.class);
    private EmployeeDao dao = newEmployeeDao(dataSource);

    protected abstract EmployeeDao newEmployeeDao(DataSource dataSource);

    @Test
    public final void getEmployeeById() throws Exception {
        Employee expected = new Employee(1L, "Joe", "Blow", BigDecimal.valueOf(3.65));
        when(dataSource.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        when(stmt.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getLong("id")).thenReturn(expected.getId());
        when(rs.getString("firstname")).thenReturn(expected.getFirstName());
        when(rs.getString("lastname")).thenReturn(expected.getLastName());
        when(rs.getBigDecimal("salary")).thenReturn(expected.getSalary());
        Employee actual = dao.getEmployeeById(expected.getId());
        verify(conn, times(1)).close();
        verify(stmt, times(1)).close();
        assertEquals(expected, actual);        
    }
    
    @Test
    public final void cleansUpAfterException() throws Exception {
        when(dataSource.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(stmt);
        RuntimeException re1 = new RuntimeException();
        when(stmt.executeQuery()).thenThrow(re1);
        try {
            dao.getEmployeeById(1L);
            fail("should have thrown " + re1);
        } catch (RuntimeException re2) {
            assertSame(re1, re2);
        }
        verify(stmt, times(1)).close();
        verify(conn, times(1)).close();
        
    }
}
