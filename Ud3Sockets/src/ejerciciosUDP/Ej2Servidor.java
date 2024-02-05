package ejerciciosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.Random;

public class Ej2Servidor {
	final static int PUERTO = 5000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mensaje;
		DatagramPacket entrada, salida;
		byte[] buffer = new byte[10124];
		DatagramSocket socketUdp =  null;
		InetAddress direccion;
		int puertoCliente;
		Random aleatorio = new Random();
		int espera = 0;
		LocalDateTime fechaHora;
		
		
		
		System.out.println("Iniciando servidor");
		
		try {
			
			socketUdp = new DatagramSocket(PUERTO);
			
			while(true) {
			
			entrada = new DatagramPacket(buffer, buffer.length);
			socketUdp.receive(entrada);
			espera = aleatorio.nextInt(2500, 6000);
			System.out.println(espera);
			Thread.sleep(espera);
			fechaHora = LocalDateTime.now();
			
			mensaje = fechaHora.toString();
			buffer = mensaje.getBytes();
			direccion = entrada.getAddress();
			puertoCliente = entrada.getPort();
			
			salida = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
			socketUdp.send(salida);
			
			
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			// Cerramos el socket cuando se salga del bucle infinito
			socketUdp.close();
		}
	}

}
