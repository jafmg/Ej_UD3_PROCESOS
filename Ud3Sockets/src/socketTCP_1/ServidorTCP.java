package socketTCP_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
	final static int PUERTO = 5000;

	public static void main(String[] args) {
		// 1)Creaci�n del socket
		ServerSocket servidor = null;
		Socket sc = null;

		DataInputStream in;
		DataOutputStream out;

		try {
			// 2) Asignaci�n de puerto, de IP vamos a utilizar la nuestra
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor incializado, esperando clientes");

			while (true)// 3)Escuchar, en este intervalor ya estamos escuchando alguna petici�n por
						// parte del cliente
			{
				// 4) Aceptamos la conexi�n
				sc = servidor.accept();
				System.out.println("Comunicaci�n establecida.");

				// 5) Env�o y recepci�n de mensajes
				// Lectura de mensajes
				in = new DataInputStream(sc.getInputStream());
				// Escritura de mensajes
				out = new DataOutputStream(sc.getOutputStream());

				// Leemos el mensaje
				String mensaje = in.readUTF();

				System.out.println("Mensaje recibido en servidor: " + mensaje);
				// Enviamos un mensaje al cliente
				out.writeUTF("�Hola mundo desde el servidor!");
				in.close();
				out.close();
				sc.close();
				System.out.println("Cliente desconectado");

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
