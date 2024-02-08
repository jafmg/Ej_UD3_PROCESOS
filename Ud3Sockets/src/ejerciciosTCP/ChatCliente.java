package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import librerias.IO;

public class ChatCliente {

	final static String HOST = "10.11.0.136"; // Aquí va la direccion del servidor en red
	final static int PORT = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataInputStream recibir;
		DataOutputStream enviar;
		String nick;

		try {
			// 1) Creaci�n del socket
			Socket sc;
			// 2) Conexi�n con el socket
			sc = new Socket(HOST, PORT);
			System.out.println("Escribe tu nick");
			nick = IO.readString();

			// 3) Env�o y recepci�n de mensajes
			// Recepci�n de mensajes
			recibir = new DataInputStream(sc.getInputStream());
			// Env�o de mensajes
			enviar = new DataOutputStream(sc.getOutputStream());
			
			enviar.writeUTF(nick);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
