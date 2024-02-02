package socketUDP_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {
	final static int PUERTO = 5000;

	public static void main(String[] args) {
		byte[] buffer = new byte[1024];
		int puertoCliente;
		InetAddress direccion;
		DatagramPacket respuesta;
		DatagramPacket peticion = null;
		DatagramSocket socketUDP = null;
		try {
			System.out.println("Inicializado servidor UDP");
			// Creamos el socket
			socketUDP = new DatagramSocket(PUERTO);
			String mensaje;
			while (true) {

				// Creamos el contenedor del mensaje que vamos a recibir, UDP
				peticion = new DatagramPacket(buffer, buffer.length);
				// Recibimos el mensaje
				socketUDP.receive(peticion);
				System.out.println("Recibimos la petición del cliente");
				mensaje = new String(peticion.getData());
				System.out.println(mensaje);

				// Obtenemos los datos de la persona que nos ha mandado el paquete
				puertoCliente = peticion.getPort();
				direccion = peticion.getAddress();

				mensaje = "Hola desde el Servidor!";
				buffer = mensaje.getBytes();
				// Le enviamos una respuesta
				respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

				System.out.println("Enviamos información al cliente");
				socketUDP.send(respuesta);

				System.out.println("Finalizado el envío desde servidor UDP");

			}
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// Cerramos el socket cuando se salga del bucle infinito
			socketUDP.close();
		}
	}
}
