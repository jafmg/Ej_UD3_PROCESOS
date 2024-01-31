package ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorEJ4 {

	final static Integer PORT = 5000;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
		ServerSocket ssc = null;
		Socket sc;
		
		try {
			ssc = new ServerSocket(PORT);
			//EL SSC CREA EL CANAL ENTRE SERVIDOR Y CLIENTE(S) EN EL PUERTO
			//DESIGNADO ES POR ESTO QUE SOLO INSTANCIAMOS UNA VEZ EL SSC
			System.out.println("Servidor encendido.\nEsperando conexiones...\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		while (true) {
			try {
				sc = ssc.accept();
				System.out.println("Conexion Establecida\n");
				MultiServer ms = new MultiServer(sc);
				ms.start();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class MultiServer extends Thread{
	DataInputStream dis;
	DataOutputStream dos;
	Socket sc;
	
	public MultiServer(Socket sc) {
		this.sc = sc;
	}
	
	public void run() {
		try {
			dis = new DataInputStream(sc.getInputStream());
			dos = new DataOutputStream(sc.getOutputStream());
			
			String cadena = null;
			Integer contador = 0;
			
			System.out.println("Recibiendo cadena...");
			do {
				cadena = dis.readUTF();
				contador = cadena.length();
				if (!cadena.equals("*")) {
					dos.writeInt(contador);
					System.out.println("Enviando resultado de cadena...");
				}
			} while (!cadena.equals("*"));
			
			dis.close();
			dos.close();
			sc.close();
			System.out.println("Conexion con cliente finalizada");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

