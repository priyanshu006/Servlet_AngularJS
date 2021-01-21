package com.servletangular.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.servletangular.beans.Employee;
import com.servletangular.service.EmployeeService;
import com.servletangular.service.EmployeeServiceImpl;

@WebServlet("/EmployeeController")

public class EmployeeController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmployeeService empService;
	@Override
	public void init() throws ServletException {
		super.init();
		empService = new EmployeeServiceImpl(); 
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		List<Employee> list = empService.findAll();
		res.setContentType("application/json");
		PrintWriter out=res.getWriter();
		Gson gson=new Gson();
		
		if(list.size()>0) {
			String jsonData = gson.toJson(list);
			out.print(jsonData);
		}
		out.close();
	}
}
