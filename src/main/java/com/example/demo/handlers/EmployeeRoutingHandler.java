package com.example.demo.handlers;

import java.util.List;
import com.example.demo.pojos.Employee;
import io.undertow.server.HttpHandler;

public class EmployeeRoutingHandler {

	public static HttpHandler getEmployeeHandler(Employee employee) {
		return new EmployeeHandler(employee);
	}

	public static HttpHandler getEmployeesHandlHttpHandler(List<Employee> employees) {
		return new EmployeesHandler(employees);
	}
}
