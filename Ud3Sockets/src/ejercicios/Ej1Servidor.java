package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej1Servidor {

	final static int PUERTO = 5000;
	
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			DataInputStream in;
			DataOutputStream out;
			Socket sc = null;
			System.out.println("Inicializado el servidor");
			
			while(true) {
				sc = servidor.accept();
				System.out.println("Conexion establecida");
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				
				out.writeUTF("HOLA QUE TAL");
				System.out.println("Mensaje del cliente " + in.readUTF());
				
				in.close();
				out.close();
				System.out.println("Cliente desconectado");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
