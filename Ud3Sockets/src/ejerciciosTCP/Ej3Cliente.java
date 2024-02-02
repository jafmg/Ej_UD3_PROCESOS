package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej3Cliente {

	final static String HOST = "10.11.0.136"; 
	final static int PORT = 5000;
	
	public static void main(String[] args) {
		
		DataInputStream in;
		DataOutputStream out;
		int numPalabras;
		int numCaracteres;
		String palabra = "";
		
		try {
			Socket sc = new Socket(HOST, PORT);
			System.out.println("Cliente conectado");
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			
			while(!palabra.equals("*")) {
				System.out.println("Introduce una cadena ");
				palabra = IO.readString();
				out.writeUTF(palabra);
				if(!palabra.equals("*")) {
				numCaracteres = in.readInt();
				System.out.println(numCaracteres);
				}
			}
			
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

