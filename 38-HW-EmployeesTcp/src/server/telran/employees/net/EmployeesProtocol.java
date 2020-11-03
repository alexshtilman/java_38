package server.telran.employees.net;

import java.io.Serializable;
import java.lang.reflect.Method;

import common.telran.employees.dto.*;
import common.telran.employees.services.interfaces.EmployeeService;
import common.telran.net.*;

import server.telran.net.server.ProtocolJava;

public class EmployeesProtocol implements ProtocolJava {
	EmployeeService service;

	public EmployeesProtocol(EmployeeService service) {
		super();
		this.service = service;
	}

	@Override
	public ResponseJava getResponse(RequestJava request) {
		Class<?> clazz = this.getClass();
		try {
			Method method = clazz.getDeclaredMethod(request.requestType, Serializable.class);
			method.setAccessible(true);
			return (ResponseJava) method.invoke(this, request.requestData);
		} catch (NoSuchMethodException e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, "wrong request type: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseJava(TcpResponseCode.INTERNAL_ERROR, "INTERNAL SERVER ERROR " + e.getMessage());
		}

	}

	ResponseJava addEmployee(Serializable requestData) {
		try {
			Employee empl = (Employee) requestData;
			ReturnCodes res = service.addEmployee(empl);
			return new ResponseJava(TcpResponseCode.OK, res);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava getEmployee(Serializable requestData) {
		try {
			Long id = (Long) requestData;
			Employee empl = service.getEmployee(id);
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava removeEmployee(Serializable requestData) {
		try {
			Long id = (Long) requestData;
			ReturnCodes empl = service.removeEmployee(id);
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava updateEmployee(Serializable requestData) {
		try {
			Object[] data = (Object[]) requestData;
			Employee empl = service.updateEmployee((Long) data[0], (Employee) data[1]);
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava generateEmployees(Serializable requestData) {
		try {
			Integer[] data = (Integer[]) requestData;
			ReturnCodes empl = service.generateRandomEmployees(data[0], data[1], data[2], GeneratorMode.RANDOM);
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava getStatisticsOperationsItem(Serializable requestData) {
		try {
			Integer[] data = (Integer[]) requestData;
			ReturnCodes empl = service.generateRandomEmployees(data[0], data[1], data[2], GeneratorMode.RANDOM);
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava getDepartmentAvgSalaryDistribution(Serializable requestData) {
		try {
			DepartmentSalary[] empl = service.getDepartmentAvgSalaryDistribution();
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava minMaxSalaryEmployees(Serializable requestData) {
		try {
			MinMaxSalaryEmployees[] empl = service.getEmployeesBySalariesInterval((Integer) requestData);
			return new ResponseJava(TcpResponseCode.OK, empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava getEmployeesByAge(Serializable requestData) {
		try {
			BiIntParam data = (BiIntParam) requestData;
			Iterable<Employee> empl = service.getEmployeesByAge(data.getFrom(), data.getTo());
			return new ResponseJava(TcpResponseCode.OK, (Serializable) empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava getEmployeesByDepartment(Serializable requestData) {
		try {
			Iterable<Employee> empl = service.getEmployeesByDepartment((String) requestData);
			return new ResponseJava(TcpResponseCode.OK, (Serializable) empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava getEmployeeBySalary(Serializable requestData) {
		try {
			BiIntParam data = (BiIntParam) requestData;
			Iterable<Employee> empl = service.getEmployeesBySalary(data.getFrom(), data.getTo());
			return new ResponseJava(TcpResponseCode.OK, (Serializable) empl);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava saveToDB(Serializable requestData) {
		try {
			ReturnCodes code = service.saveToDB();
			return new ResponseJava(TcpResponseCode.OK, code);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

	ResponseJava loadFromDB(Serializable requestData) {
		try {
			ReturnCodes code = service.loadFromDB();
			return new ResponseJava(TcpResponseCode.OK, (Serializable) code);
		} catch (Exception e) {
			return new ResponseJava(TcpResponseCode.WRONG_REUEST, e.getMessage());
		}
	}

}
