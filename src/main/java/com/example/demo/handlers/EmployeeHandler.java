package com.example.demo.handlers;

import com.example.demo.pojos.Employee;
import com.google.gson.Gson;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

public class EmployeeHandler implements HttpHandler {

	private Employee employee = null;

	public EmployeeHandler(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		// TODO Auto-generated method stub
		exchange.getResponseSender().send(new Gson().toJson(employee));
	}

}
