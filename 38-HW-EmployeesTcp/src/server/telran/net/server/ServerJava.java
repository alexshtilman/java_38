package server.telran.net.server;

import java.io.IOException;
import java.net.*;

public class ServerJava implements Runnable {
	ServerSocket serverSocket;
	int port;
	ProtocolJava protocol;

	public ServerJava(int port, ProtocolJava protocol) {
		this.port = port;
		this.protocol = protocol;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw new RuntimeException("Port in use " + port);
		}
	}

	@Override
	public void run() {
		System.out.println("Server is listening on port " + port);
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				ServerClientJava client = new ServerClientJava(socket, protocol);
				client.run();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
