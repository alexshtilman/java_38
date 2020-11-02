package common.telran.employees.services.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.telran.employees.dto.*;

public interface EmployeeService {
	ReturnCodes addEmployee(Employee emp1);

	ReturnCodes removeEmployee(long id);
	
	ReturnCodes generateRandomEmployees(int minSalary, int maxSalary, int employeeCount, GeneratorMode mode);

	Employee updateEmployee(long id, Employee newEmployee);

	Employee getEmployee(long id);

	Iterable<Employee> getEmployeesByAge(int ageFrom, int ageTo);

	Iterable<Employee> getEmployeesByDepartment(String department);

	Iterable<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo);

	public MinMaxSalaryEmployees[] getEmployeesBySalariesInterval(int interval);

	public DepartmentSalary[] getDepartmentAvgSalaryDistribution();

	ReturnCodes saveToDB() throws FileNotFoundException, IOException, ClassNotFoundException;

	ReturnCodes loadFromDB() throws FileNotFoundException, IOException,ClassNotFoundException;
}
