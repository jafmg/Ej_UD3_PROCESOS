package socketUDP_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {
	final static int PUERTO_SERVIDOR = 5000;

	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		String mensaje;
		DatagramPacket respuesta;
		InetAddress direccionServidor;
		DatagramSocket socketUDP;
		DatagramPacket peticion;
		try {
			// Otra forma de obtener nuestra IP
			// Misma funci�n InetAddress.getLocalHost()
			direccionServidor = InetAddress.getByName("localhost");
			
			// No es necesario un puerto, se lo asigna autom�tica mente el OS
			socketUDP = new DatagramSocket();
			mensaje = "Hola, soy el cliente!!!";
			buffer = mensaje.getBytes();

			// Creamos el paquete, mensaje
			peticion = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

			// enviamos el mensaje
			System.out.println("Enviamos el datagrama");
			socketUDP.send(peticion);

			respuesta = new DatagramPacket(buffer, buffer.length);
			System.out.println("Recibida la petici�n del servidor");
			socketUDP.receive(respuesta);

			
			mensaje = new String(respuesta.getData());
			System.out.println(mensaje);
			// Cerramos el socket
			socketUDP.close();

		} catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
