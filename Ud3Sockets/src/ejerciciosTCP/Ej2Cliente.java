package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ej2Cliente {

	final static String HOST = "10.11.0.136"; 
	final static int PORT = 5000;
	
	public static void main(String[] args) {
		
		DataInputStream in;
		DataOutputStream out;
		int numPalabras;
		int numCaracteres;
		String palabra;
		
		try {
			Socket sc = new Socket(HOST, PORT);
			System.out.println("Cliente conectado");
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			System.out.println("Introduce número de líneas a enviar");
			numPalabras = IO.readInt();
			out.writeInt(numPalabras);
			
			for(int i = 1; i <=numPalabras; i++) {
				System.out.println("Introduce la palabra " + i);
				palabra = IO.readString();
				out.writeUTF(palabra);
				
			}
			
			numCaracteres = in.readInt();
			System.out.println(numCaracteres);
			
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

