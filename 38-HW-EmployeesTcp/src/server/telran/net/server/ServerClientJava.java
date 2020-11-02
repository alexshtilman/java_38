package server.telran.net.server;

import java.net.*;

import common.telran.net.*;
import java.io.*;

public class ServerClientJava implements Runnable {
	ObjectInputStream input;
	ObjectOutputStream output;
	ProtocolJava protocol;

	public ServerClientJava(Socket socket, ProtocolJava protocol) {
		try {
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
			this.protocol = protocol;

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		try {
			while (true) {
				output.writeObject(protocol.getResponse((RequestJava) input.readObject()));
			}
		} catch (EOFException e) {
			System.out.println("client closed connection");
		} catch (Exception e) {
			System.out.println("client abnormally closed connection " + e.getMessage());
		}

	}

}
