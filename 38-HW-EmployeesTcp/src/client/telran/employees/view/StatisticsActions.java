package client.telran.employees.view;

import common.telran.employees.services.interfaces.EmployeeService;
import client.telran.view.*;
import common.telran.employees.dto.*;

public class StatisticsActions {
	static EmployeeService service;

	public static Item getItems(InputOutput io, String name, EmployeeService serviceP) {
		service = serviceP;
		return new Menu(name, Item.of("Salarys by interval", StatisticsActions::minMaxSalaryEmployees),
				Item.of("Department avg salarys", StatisticsActions::getDepartmentAvgSalaryDistribution), Item.exit());
	}

	public static void minMaxSalaryEmployees(InputOutput iop) {
		int interval = iop.readInteger("Please type interval of salary's", 100, 30000);
		MinMaxSalaryEmployees[] employees = service.getEmployeesBySalariesInterval(interval);
		if (employees != null) {
			for (MinMaxSalaryEmployees empl : employees) {
				iop.writeLn(String.format("Salary from %s to %s %d employee(s)", empl.getMinSalary(), empl.getMaxSalary(),
						empl.size()));
			}

		} else
			iop.writeLn("Cant not query data in given interval...");
	}

	public static void getDepartmentAvgSalaryDistribution(InputOutput iop) {
		DepartmentSalary[] salarys = service.getDepartmentAvgSalaryDistribution();
		if (salarys != null) {
			for (DepartmentSalary empl : salarys) {
				iop.writeLn(empl);
			}
		}

		else
			iop.writeLn("Cant not query data");
	}
}
