package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import librerias.IO;



public class ClienteEJ4 {

	final static Integer PORT = 5000;
	final static String HOST = "127.0.0.1";

	public static void main(String[] args) {
		Socket sc;
		DataInputStream dis;
		DataOutputStream dos;
		
		try {
			sc = new Socket(HOST, PORT);
			System.out.println("Conexion establecida\n");
			
			dis = new DataInputStream(sc.getInputStream());
			dos = new DataOutputStream(sc.getOutputStream());
			
			String cadena = null;
			Integer contador = 0;
			System.out.println("Introduzca texto, para finalizar termine con un asterisco\n");
			
			do {
				System.out.println("Escribe");
				cadena = IO.readString();
				dos.writeUTF(cadena);
				if (!cadena.equals("*")) {
					contador = dis.readInt();
					System.out.println("La cadena tiene "+contador+" caracteres");
				}	
			} while (!cadena.equals("*"));	
			
			dos.close();
			dis.close();
			sc.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			System.out.println("Conexion finalizada");	
		}
	}
}
