package ejerciciosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Ej1Servidor {
	final static int PUERTO = 5000;
	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		int puertoCliente;
		InetAddress direccion;
		DatagramPacket respuesta;
		DatagramPacket peticion = null;
		DatagramSocket socketUDP = null;
		String mensaje;
		try {
		socketUDP = new DatagramSocket(PUERTO);
		while(true) {
			peticion = new DatagramPacket(buffer, buffer.length);
			socketUDP.receive(peticion);
			mensaje = new String(peticion.getData());
			System.out.println(mensaje);
			mensaje = new String("Eco del servidor: " + peticion.getData());
			puertoCliente = peticion.getPort();
			direccion = peticion.getAddress();
			buffer = mensaje.getBytes();
			respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
			socketUDP.send(respuesta);
			
		}
		
		}catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			
			socketUDP.close();
		}
	}

}
