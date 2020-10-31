package client.telran.employees.net;

import static common.telran.employees.api.ApiConstants.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import common.telran.employees.services.interfaces.EmployeeService;
import common.telran.net.TcpClientJava;
import common.telran.employees.dto.*;

public class EmployeesTcpProxy extends TcpClientJava implements EmployeeService {

	public EmployeesTcpProxy(String hostname, int port) {
		super(hostname, port);
	}

	@Override
	public ReturnCodes addEmployee(Employee emp1) {
		return sendRequest(POST_EMPLOYEE, emp1);
	}

	@Override
	public ReturnCodes removeEmployee(long id) {
		return sendRequest(DELETE_EMPLOYEE, id);
	}

	@Override
	public Employee updateEmployee(long id, Employee newEmployee) {
		Object[] data = { id, newEmployee };
		return sendRequest(PUT_EMPLOYEE, data);
	}

	@Override
	public Employee getEmployee(long id) {
		return sendRequest(GET_EMPLOYEE, id);
	}

	@Override
	public Iterable<Employee> getEmployeesByAge(int ageFrom, int ageTo) {
		Object[] data = { ageFrom, ageTo };
		return sendRequest(GET_EMPLOYEES_BY_AGE, data);
	}

	@Override
	public Iterable<Employee> getEmployeesByDepartment(String department) {
		return sendRequest(GET_EMPLOYEES_BY_DEPARTMENT, department);
	}

	@Override
	public Iterable<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo) {
		Object[] data = { salaryFrom, salaryTo };
		return sendRequest(GET_EMPLOYEES_BY_SALARY, data);
	}

	@Override
	public MinMaxSalaryEmployees[] getEmployeesBySalariesInterval(int interval) {
		return sendRequest(GET_EMPLOYEES_BY_SALARIES_INTERVAL, interval);
	}

	@Override
	public DepartmentSalary[] getDepartmentAvgSalaryDistribution() {
		return sendRequest(GET_DEPARTMENT_AVG_SALARY, "");
	}

	@Override
	public ReturnCodes generateRandomEmployees(int minSalary, int maxSalary, int employeeCount, GeneratorMode mode) {
		Object[] data = { minSalary, maxSalary,employeeCount, GeneratorMode.RANDOM };
		return sendRequest(GENERATE_EMPLOYEES, data);
	}

	@Override
	public ReturnCodes saveToFiles() throws FileNotFoundException, IOException, ClassNotFoundException {
		return sendRequest(SAVE_TO_FILES, "");
	}

	@Override
	public ReturnCodes loadFromFiles() throws FileNotFoundException, IOException, ClassNotFoundException {
		return sendRequest(LOAD_FROM_FILES, "");
	}

}
