package com.servletangular.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.servletangular.beans.Employee;
import com.servletangular.dao.util.ConnectionUtil;
import com.servletangular.dao.util.SQLQuery;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> findAll() throws SQLException {
		
		List<Employee> empList = new ArrayList<>();
		Connection con = ConnectionUtil.getNewConnection();
		PreparedStatement ps = con.prepareStatement(SQLQuery.SQL_SELECT_ALL_EMPLOYEE);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int empId = rs.getInt(1);
			String name = rs.getString(2);
			double salary = rs.getDouble(3);
			String designation = rs.getString(4);
			String address = rs.getString(5);
			
			Employee emp = new Employee(empId, name, salary, designation, address);
			empList.add(emp);
			
		}
		return empList;
	}

	@Override
	public int save(Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

}
