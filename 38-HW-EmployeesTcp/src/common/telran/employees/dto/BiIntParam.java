package common.telran.employees.dto;

import java.io.Serializable;

public class BiIntParam implements Serializable {
	private static final long serialVersionUID = 1L;
	int from;
	int to;

	public BiIntParam(int from, int to) {
		super();
		this.from = from;
		this.to = to;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "BiIntParam [from=" + from + ", to=" + to + "]";
	}

}
