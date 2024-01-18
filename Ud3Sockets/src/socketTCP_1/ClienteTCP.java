package socketTCP_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteTCP {
	final static String HOST = "10.11.0.206"; //Aquí va la direccion del servidor en red
	final static int PORT = 5000;

	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;

		try {
			// 1) Creaci�n del socket
			Socket sc;
			// 2) Conexi�n con el socket
			sc = new Socket(HOST, PORT);
			System.out.println("Cliente conectado!");

			// 3) Env�o y recepci�n de mensajes
			// Recepci�n de mensajes
			in = new DataInputStream(sc.getInputStream());
			// Env�o de mensajes
			out = new DataOutputStream(sc.getOutputStream());

			// Escritura de mensaje
			out.writeUTF("�Hola y mi regalo? Salu2 jeje");
			// Lectura de mensaje
			String mensaje = in.readUTF();

			System.out.println("Mensaje recibido en el cliente: " + mensaje);
			// 4) Cierre de la conexi�n
			sc.close();
			in.close();
			out.close();

			System.out.println("Cerramos el cliente.java");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
