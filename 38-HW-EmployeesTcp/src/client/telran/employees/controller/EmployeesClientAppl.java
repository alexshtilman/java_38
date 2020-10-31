package client.telran.employees.controller;

import java.io.IOException;

import client.telran.employees.net.EmployeesTcpProxy;
import client.telran.employees.view.*;
import client.telran.view.*;

public class EmployeesClientAppl {

	private static final int PORT = 5000;
	private static final String HOSTNAME = "localhost";

	public static void main(String[] args) {
		InputOutput io = new ConsoleInputOutput();
		EmployeesTcpProxy service = new EmployeesTcpProxy(HOSTNAME, PORT);
		Menu menu = new Menu("Menu", 
				DataBaseActions.getItems(io, "Database actions", service),
				AdministratorActions.getItems(io, "Admin actions", service),
				UserActions.getItems(io, "Users actions", service),
				StatisticsActions.getItems(io, "Statistics actions", service),
				Item.of("Exit", iox -> {
					try {
						service.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}, true));
		menu.perform(io);
	}

}
