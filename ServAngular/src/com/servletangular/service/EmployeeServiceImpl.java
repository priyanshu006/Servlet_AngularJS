package com.servletangular.service;

import java.util.ArrayList;
import java.util.List;

import com.servletangular.beans.Employee;

import com.servletangular.dao.EmployeeDAO;
import com.servletangular.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDAO employeeDAO = new EmployeeDAOImpl(); 
	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<>();
		try {
			list = employeeDAO.findAll();
		}
		catch (Exception e) {
			System.err.println(e);
		}
		return list;
		
		
	}
	

}
