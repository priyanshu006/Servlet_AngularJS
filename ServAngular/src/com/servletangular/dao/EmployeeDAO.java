package com.servletangular.dao;

import java.sql.SQLException;
import java.util.List;

import com.servletangular.beans.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll() throws SQLException;
	public int save(Employee employee);
	
}
