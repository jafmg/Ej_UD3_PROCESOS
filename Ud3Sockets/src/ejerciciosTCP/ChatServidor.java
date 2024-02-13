package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class ChatServidor {
	final static int PUERTO = 5000;
	public static HashMap<Socket, String> conectados = new HashMap<Socket, String>();
	
	
	public static void main(String[] args) {
		ChatServidor chat = new ChatServidor();
		chat.inicializarServidor();
	}
	
	public void inicializarServidor() {
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
				System.out.println("Clientes conectados");
//				conectados.put(sc, entrada.readUTF());
				
				
				new HiloServer(sc, this).start();
//				hilo.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized static void guardarNick(Socket sc, String nick) {
		
		conectados.put(sc, nick);
		System.out.println("guardado" + nick);
		
	}
	
	public synchronized static void eliminarNick(Socket sc) {
		conectados.remove(sc);
		System.out.println("eliminado");
	}
	
	public synchronized static String obtenerNick(Socket sc) {
		
		return conectados.get(sc);
		
	}
	
	public synchronized static void enviarATodos(String mensaje, HashMap<Socket, String> listaUsuarios) {
		
		DataOutputStream salida;
		for (Socket conexiones : listaUsuarios.keySet()) {
			
			try {
				salida = new DataOutputStream(conexiones.getOutputStream());
				System.out.println("Mensaje para " + conexiones);
				salida.writeUTF(mensaje);
				
				System.out.println(conexiones+ "\n");
//				salida.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
		
	}
	
	
}


class HiloServer extends Thread{
	private DataInputStream entrada;
	private DataOutputStream salida;
	private Socket sc;
	private ChatServidor chat;
	
	public HiloServer(Socket sc, ChatServidor chat) {
		this.sc = sc;
		this.chat = chat;
	}
	
	@Override
	public void run() {
		String mensajeEntrante = null;
		String mensajeSalida = null;
		try {
			
			entrada = new DataInputStream(sc.getInputStream());
			salida = new DataOutputStream(sc.getOutputStream());
			mensajeEntrante = entrada.readUTF();
			chat.guardarNick(sc, mensajeEntrante);
			mensajeSalida = "Cliente conectado con nick: " + mensajeEntrante;
			salida.writeUTF(mensajeSalida);
			
			while(!mensajeEntrante.equalsIgnoreCase("Salir")) {
				
				mensajeEntrante = entrada.readUTF();
				System.out.println("El cliente" + chat.obtenerNick(sc) + " dice: " + mensajeEntrante);
				mensajeSalida = "Servidor dice: El usuario " + chat.obtenerNick(sc) + " dice: " + mensajeEntrante;
				
				chat.enviarATodos(mensajeSalida, chat.conectados);
				
				System.out.println(chat.conectados.size());
				
				if(mensajeSalida.equalsIgnoreCase("Salir")) {
					System.out.println("El usuario " + chat.obtenerNick(sc) + "se va a salir");
					salida.writeUTF("El usuario " + chat.obtenerNick(sc) + "ha dejado el chat");
				}
				
				
			}
			
			
			chat.eliminarNick(sc);
			entrada.close();
			salida.close();
			sc.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}