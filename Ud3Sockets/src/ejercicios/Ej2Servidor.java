package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Ej2Servidor {

	final static int PUERTO = 5000;
	
	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(PUERTO);
			DataInputStream in;
			DataOutputStream out;
			Socket sc = null;
			int numPalabras;
			int numCaracteres = 0;
			System.out.println("Inicializado el servidor");
		
			
			while(true) {
				sc = servidor.accept();
				System.out.println("Conexion establecida");
				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());
				
				numPalabras = in.readInt();
				
				for(int i = 1; i<= numPalabras; i++) {
					numCaracteres += in.readUTF().length();
					
				}
				out.writeInt(numCaracteres);
				
				in.close();
				out.close();
				sc.close();
				servidor.close();
				
				System.out.println("Cliente desconectado");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Cliente desconectado");
		}
		
		
	}
}
