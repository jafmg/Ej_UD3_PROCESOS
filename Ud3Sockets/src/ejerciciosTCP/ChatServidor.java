package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;


public class ChatServidor {
	final static int PUERTO = 5000;
	public static HashMap<Socket, String> conectados = new HashMap<Socket, String>();
	
	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket sc = null;

		
		
		
		DataInputStream entrada;
		DataOutputStream salida;

		
		
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor incializado, esperando clientes");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true) {
			try {
				sc = servidor.accept();
				conectados.put(sc, entrada.readUTF());
//				MultiServer ms = 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized static void guardarNick(Socket sc, String nick) {
		
		conectados.put(sc, nick);
		
	}
	
	public synchronized static void eliminarNick(Socket sc, String nick) {
		conectados.remove(sc);
	}
	
	class hiloServer{
		private DataInputStream entrada;
		private DataOutputStream salida;
		private Socket sc;
		
		public hiloServer(Socket sc) {
			this.sc = sc;
		}
		
		
		
	}
}