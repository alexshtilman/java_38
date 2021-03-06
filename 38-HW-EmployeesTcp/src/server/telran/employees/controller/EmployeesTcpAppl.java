package server.telran.employees.controller;

import server.telran.employees.net.EmployeesProtocol;
import server.telran.employees.services.impl.EmployeeServiceImpl;
import server.telran.net.server.ServerJava;

public class EmployeesTcpAppl {

	public static void main(String[] args) {
		int port = 5000;
		if(args.length>0)
		{
			try {
				port = Integer.parseInt(args[0]);
			}
			catch (Exception e) {
				throw new IllegalArgumentException("port number shuld be in range 1-65500");
			}
		}
		
		ServerJava server = new ServerJava(port, new EmployeesProtocol(new EmployeeServiceImpl()));
		server.run();
	}

}
