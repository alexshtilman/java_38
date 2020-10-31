package client.telran.employees.view;

import java.util.Arrays;

import common.telran.employees.services.interfaces.EmployeeService;
import client.telran.view.*;
import common.telran.employees.dto.Employee;

public class UserActions {

	static EmployeeService service;

	public static Item getItems(InputOutput io, String name, EmployeeService serviceP) {
		service = serviceP;
		return new Menu(name, 
				Item.of("Get employees by age interval", UserActions::getEmployeesByAge),
				Item.of("Get employees by department", UserActions::getEmployeesByDepartment), 
				Item.of("Get employees by salary interval", UserActions::getEmployeesBySalary), 
				Item.exit());
	}
	private static void getEmployeesByAge(InputOutput io) {
	
		io.writeLn("Select eymployees from age to age");
		int ageFrom = io.readInteger("type eage from");
		int ageTo = io.readInteger("type eage to");
		Iterable<Employee> empl =  service.getEmployeesByAge(ageFrom, ageTo);
		empl.forEach(emp->io.writeLn(emp.toString(),true));
		
	}
	private static void getEmployeesByDepartment(InputOutput io) {
		String department = io.readOption("Enter employee department", Arrays.asList("Managment", "Development", "Operations"));
		Iterable<Employee> empl =  service.getEmployeesByDepartment(department);
		empl.forEach(emp->io.writeLn(emp.toString(),true));
	}
	
	private static void getEmployeesBySalary(InputOutput io) {
		io.writeLn("Get employees by salary from to salary to");
		int salaryFrom = io.readInteger("Enter employee salary from", 5000, 30000);
		int salaryTo = io.readInteger("Enter employee salary from", 5000, 30000);
		Iterable<Employee> empl =  service.getEmployeesBySalary(salaryFrom, salaryTo);
		empl.forEach(emp->io.writeLn(emp.toString(),true));
	}
}
