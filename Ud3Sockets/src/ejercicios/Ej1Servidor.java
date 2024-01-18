package ejercicios;

import java.io.IOException;
import java.net.ServerSocket;

public class Ej1Servidor {

	final static int PUERTO = 5000;
	
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			System.out.println("Inicializado el servidor");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
