package com.example.demo.handlers;

import com.example.demo.pojos.Employee;
import com.google.gson.Gson;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import java.util.*;

public class EmployeesHandler implements HttpHandler {

	private List<Employee> employeesList = null;

	public EmployeesHandler(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		// TODO Auto-generated method stub
		exchange.getResponseSender().send(new Gson().toJson(employeesList));
	}

}
