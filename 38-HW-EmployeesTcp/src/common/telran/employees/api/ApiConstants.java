package common.telran.employees.api;

public interface ApiConstants {
	
	public static final String SAVE_TO_DB = "saveToDB";
	public static final String LOAD_FROM_DB = "loadFromDB";
	
	public static final String GENERATE_EMPLOYEES = "generateEmployees";
	public static final String POST_EMPLOYEE = "addEmployee";
	public static final String GET_EMPLOYEE = "getEmployee";
	public static final String DELETE_EMPLOYEE = "removeEmployee";
	public static final String PUT_EMPLOYEE = "updateEmployee";
	
	public static final String GET_EMPLOYEES_BY_SALARIES_INTERVAL = "minMaxSalaryEmployees";
	public static final String GET_DEPARTMENT_AVG_SALARY = "getDepartmentAvgSalaryDistribution";
	
	public static final String GET_EMPLOYEES_BY_AGE = "getEmployeesByAge";
	public static final String GET_EMPLOYEES_BY_DEPARTMENT = "getEmployeesByDepartment";
	public static final String GET_EMPLOYEES_BY_SALARY = "getEmployeeBySalary";
	
}
