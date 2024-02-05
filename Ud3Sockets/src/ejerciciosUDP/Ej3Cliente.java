package ejerciciosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import librerias.IO;

public class Ej3Cliente {
	final static int PUERTO_SERVIDOR = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte[] buffer;
		String mensaje = "";
		DatagramPacket entrada;
		InetAddress direccionServidor;
		DatagramSocket socketUDP;
		DatagramPacket salida;
		try {
		
			direccionServidor = InetAddress.getLocalHost();

	
			socketUDP = new DatagramSocket();
			
			
			while(true) {
				System.out.println("Escribe una cadena o * para salir");
				
			mensaje = IO.readString();
			
			if(mensaje.equals("*")) {
				break;
			}
			
			buffer = new byte[mensaje.length()]; //me aseguro de no enviar espacios(creo que da igual porque con el buffer del server se me generan)
			buffer = mensaje.getBytes();

			
			salida = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

			socketUDP.send(salida);

			buffer = new byte[1024]; //reinicio el buffer
			entrada = new DatagramPacket(buffer, buffer.length);
			socketUDP.receive(entrada);

			mensaje = new String(entrada.getData()).trim(); //elimino espacios
			System.out.println(mensaje);
			}
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
