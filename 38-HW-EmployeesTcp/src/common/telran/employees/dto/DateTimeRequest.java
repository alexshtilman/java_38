package common.telran.employees.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DateTimeRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	LocalDate dt;
	public DateTimeRequest(LocalDate dt) {
		this.dt = dt;
	}
}
