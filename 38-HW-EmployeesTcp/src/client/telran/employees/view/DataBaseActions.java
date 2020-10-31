package client.telran.employees.view;

import common.telran.employees.services.interfaces.EmployeeService;

import java.io.FileNotFoundException;
import java.io.IOException;

import client.telran.view.InputOutput;
import client.telran.view.Item;
import client.telran.view.Menu;
import common.telran.employees.dto.GeneratorMode;

public class DataBaseActions {
static EmployeeService service;
	
	public static Item getItems(InputOutput io, String name, EmployeeService serviceP) {
		service = serviceP;
		return new Menu(name,
							Item.of("load employees from DB", DataBaseActions::loadFromDB),
							Item.of("generate random employees", DataBaseActions::generateEmployees),
							Item.of("save current employees to DB", DataBaseActions::saveToDB),
							Item.exit());
	}
	private static void generateEmployees(InputOutput io) {
		int minSalary = io.readInteger("Enter min salary", 5000, 30000);
		int maxSalary = io.readInteger("Enter max salary", 5001, 30000);
		int employeeCount = io.readInteger("Enter employee count", 1, 10000000);
		io.writeLn(service.generateRandomEmployees(minSalary, maxSalary, employeeCount, GeneratorMode.RANDOM));
	}
	private static void loadFromDB(InputOutput io)  {
		try {
			io.writeLn(service.loadFromFiles());
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	private static void saveToDB(InputOutput io)  {
		try {
			io.writeLn(service.saveToFiles());
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
