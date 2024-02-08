package ejerciciosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class Ej2Cliente {

	final static int PUERTO = 5000; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		byte [] buffer = new byte[1024];
		String mensaje;
		DatagramPacket peticion, respuesta;
		DatagramSocket socketUdp = null;
		InetAddress direccion;
		long tiempoInicio, tiempoFin;
		
		
		try {
			direccion = InetAddress.getLocalHost();
			socketUdp = new DatagramSocket();
			mensaje = "Dame fecha";
			buffer = mensaje.getBytes();
			
			peticion = new DatagramPacket(buffer, buffer.length, direccion, PUERTO);
			System.out.println("Enviando ping al server");
			
//			tiempoInicio = System.currentTimeMillis();
			socketUdp.send(peticion);
			buffer = new byte[1024];
			respuesta = new DatagramPacket(buffer, buffer.length);
			socketUdp.setSoTimeout(5000);
			socketUdp.receive(respuesta);
//			tiempoFin = System.currentTimeMillis();
			
//			if(tiempoFin - tiempoInicio <= 5000) {
//				mensaje = new String(respuesta.getData());
//				System.out.println(mensaje);
//			}else {
//				System.err.println("Connection time out");
//			}
			
			
			mensaje = new String(respuesta.getData());
			System.out.println(mensaje);
			socketUdp.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection timeout");
			socketUdp.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
