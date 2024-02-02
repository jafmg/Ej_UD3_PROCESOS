package ejerciciosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Ej1Cliente {

	final static int PUERTO_SERVIDOR = 5000;
	
	public static void main(String[] args) {
		
		byte[] buffer = new byte[1024];
		String mensaje;
		DatagramPacket respuesta;
		InetAddress direccion;
		DatagramSocket socketUDP;
		DatagramPacket peticion;
		
		try {
			direccion = InetAddress.getByName("localhost");
			socketUDP = new DatagramSocket();
			mensaje = "Ecoo";
			buffer = mensaje.getBytes();
			
			peticion = new DatagramPacket(buffer, buffer.length, 
					direccion, PUERTO_SERVIDOR);
			System.out.println("Enviado mensaje: " + mensaje);
			socketUDP.send(peticion);
			respuesta = new DatagramPacket(buffer, buffer.length);
			socketUDP.receive(respuesta);
			mensaje = new String(respuesta.getData());
			System.out.println(mensaje + "recibido");
			socketUDP.close();
			
			
		}catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
