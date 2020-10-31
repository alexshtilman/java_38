package client.telran.employees.view;

import java.time.LocalDate;
import java.util.Arrays;

import common.telran.employees.services.interfaces.EmployeeService;
import client.telran.view.*;
import common.telran.employees.dto.Employee;

public class AdministratorActions {
	private static final String ENTER_EMPLOYEE_ID = "Enter employee ID";
	static EmployeeService service;
	
	public static Item getItems(InputOutput io, String name, EmployeeService serviceP) {
		service = serviceP;
		return new Menu(name,
							Item.of("get employee", AdministratorActions::getEmployee),
							Item.of("add new employee", AdministratorActions::addNewEmployee),
							Item.of("update employee", AdministratorActions::updateEmployee),
							Item.of("remove employee", AdministratorActions::removeEmployee), 
							Item.exit());
	}

	private static void addNewEmployee(InputOutput io) {
		String pattern = "dd/MM/yyyy";
		long id = io.readLong(ENTER_EMPLOYEE_ID);
		String name = io.readString("Enter employee name");
		LocalDate birtDay = io.readDate("Enter date in format " + pattern, pattern);
		String department = io.readOption("Enter employee department", Arrays.asList("Managment", "Development", "Operations"));
		int salary = io.readInteger("Enter employee salary", 5000, 30000);
		io.writeLn(service.addEmployee(new Employee(id, name, birtDay, department, salary)),true);
	}

	private static void getEmployee(InputOutput io) {
		long id = io.readLong(ENTER_EMPLOYEE_ID);
		Employee emp = service.getEmployee(id);
		if (emp != null) {
			io.writeLn(emp,true);
		} else
			io.writeLn("Employee not found by id!",true);
	}
	private static void removeEmployee(InputOutput io) {
		long id = io.readLong(ENTER_EMPLOYEE_ID);
		io.writeLn(service.removeEmployee(id),true);
	}
	private static void updateEmployee(InputOutput io) {
		long id = io.readLong(ENTER_EMPLOYEE_ID);
		Employee emp = service.getEmployee(id);
		if (emp != null) {
			String pattern = "dd/MM/yyyy";
			String name = io.readString("Enter employee name");
			LocalDate birtDay = io.readDate("Enter date in format " + pattern, pattern);
			String department = io.readOption("Enter employee department", Arrays.asList("Managment", "Development", "Operations"));
			int salary = io.readInteger("Enter employee salary", 5000, 30000);
			io.writeLn(service.updateEmployee(id, new Employee(id, name, birtDay, department, salary)),true);
			
		} else
			io.writeLn("Employee not found by id!",true);
		
	}
	
}
