package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej1Cliente {

	final static String HOST = "192.168.1.36"; 
	final static int PORT = 5000;
	
	public static void main(String[] args) {
		
		DataInputStream in;
		DataOutputStream out;
		
		try {
			Socket sc = new Socket(HOST, PORT);
			System.out.println("Cliente conectado");
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			String mensaje = in.readUTF();
			System.out.println("Mensaje del servidor: " + mensaje);
			mensaje.toLowerCase();
			mensaje = mensaje.toLowerCase();
			out.writeUTF(mensaje);
			
			sc.close();
			in.close();
			out.close();
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
