package ejercicios;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej1Cliente {

	final static String HOST = "10.11.0.206"; 
	final static int PORT = 5000;
	
	public static void main(String[] args) {
		
		DataInputStream in;
		DataInputStream out;
		
		try {
			Socket sc = new Socket(HOST, PORT);
			System.out.println("Cliente conectado");
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
