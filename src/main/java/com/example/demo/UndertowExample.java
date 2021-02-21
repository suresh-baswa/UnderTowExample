package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.example.demo.handlers.EmployeeRoutingHandler;
import com.example.demo.pojos.Employee;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.RoutingHandler;

public class UndertowExample {

	public static void main(String a[]) {
		Undertow server = Undertow.builder().addHttpListener(8080, "localhost", ROUTES).build();
		server.start();
	}

	public static List<Employee> getEmployeesList() {
		Stream<Employee> employeeList = Stream.of(new Employee("101", "suresh", "Hyderabad"),
				new Employee("102", "ramesh", "Banglore"));
		return employeeList.collect(Collectors.toList());
	}

	public static HttpHandler ROUTES = new RoutingHandler()
			.get("/getEmployee", EmployeeRoutingHandler.getEmployeeHandler(new Employee("101", "suresh", "Hyderabad")))
			.get("/getEmployees", EmployeeRoutingHandler.getEmployeesHandlHttpHandler(getEmployeesList()));
}
