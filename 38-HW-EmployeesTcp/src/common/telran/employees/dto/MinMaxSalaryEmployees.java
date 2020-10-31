package common.telran.employees.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSalaryEmployees implements Serializable{

	private static final long serialVersionUID = 1L;
	private int minSalary;
	private int maxSalary;
	private List<Employee> employees;// list of employees receiving salary in the range from minSalary (inclusive) to
	// maxSalary (exclusive)

	public int getMinSalary() {
		return minSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + maxSalary;
		result = prime * result + minSalary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MinMaxSalaryEmployees other = (MinMaxSalaryEmployees) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (maxSalary != other.maxSalary)
			return false;
		if (minSalary != other.minSalary)
			return false;
		return true;
	}

	public MinMaxSalaryEmployees(int minSalary, int maxSalary, List<Employee> employees) {
		super();
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "MinMaxSalaryEmployees [minSalary=" + minSalary + ", maxSalary=" + maxSalary + ", employees=\n" + employees
				+ "]";
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public List<Employee> getEmployees() {
		return employees.stream().collect(Collectors.toList());
	}
	
	public int size() {
		return employees.size();
	}
}
