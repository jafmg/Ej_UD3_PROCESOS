package ejerciciosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Ej3Servidor {
	final static int PUERTO = 5000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] buffer;
		int puertoCliente;
		InetAddress direccion;
		DatagramPacket entrada;
		DatagramPacket salida = null;
		DatagramSocket socketUDP = null;
		int numCaracteres;
		try {
			System.out.println("Inicializado servidor UDP");
			socketUDP = new DatagramSocket(PUERTO);
			String mensaje;
			while (true) {

				buffer = new byte[1024]; //cada petición tiene un buffer de 1024
				
				entrada = new DatagramPacket(buffer, buffer.length);
				
				socketUDP.receive(entrada);
				mensaje = new String(entrada.getData()).trim(); //elimino los espacios generados por el buffer
				
				
				numCaracteres = mensaje.length();
				
				

				
				puertoCliente = entrada.getPort();
				direccion = entrada.getAddress();

				
				
				mensaje = String.valueOf(numCaracteres);
				buffer = new byte[mensaje.length()]; //me aseguro de enviar el mensaje sin espacios
				buffer = mensaje.getBytes();
				
				salida = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

				
				socketUDP.send(salida);

				System.out.println("Finalizado el envio");

			}
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			
			socketUDP.close();
		}
	}

}
