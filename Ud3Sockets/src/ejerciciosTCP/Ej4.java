package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import librerias.IO;

public class Ej4 {

	final static String HOST = "127.0.0.1";
	final static int PORT = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ej4Servidor s1 = new Ej4Servidor();
		Ej4Cliente1 c1 = new Ej4Cliente1();
		Ej4Cliente2 c2 = new Ej4Cliente2();
		
		
		s1.start();
//		c1.start();
		c2.start();
		
	}

}

class Ej4Cliente1 extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private int numPalabras;
	private int numCaracteres;
	private String palabra = "";

	public Ej4Cliente1() {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			
			Socket sc = new Socket(Ej4.HOST, Ej4.PORT);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			while (!palabra.equals("*")) {
				System.out.println("Cliente 1: Introduce una cadena ");
				palabra = IO.readString();
				out.writeUTF(palabra);
				if (!palabra.equals("*")) {
					numCaracteres = in.readInt();
					System.out.println(numCaracteres);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Ej4Cliente2 extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private int numPalabras;
	private int numCaracteres;
	private String palabra = "";

	public Ej4Cliente2() {
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			Socket sc = new Socket(Ej4.HOST, Ej4.PORT);
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			while (!palabra.equals("*")) {
				System.out.println("Cliente 2: Introduce una cadena ");
				palabra = IO.readString();
				out.writeUTF(palabra);
				if (!palabra.equals("*")) {
					numCaracteres = in.readInt();
					System.out.println(numCaracteres);
				}
			}
			sc.close();
			in.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Ej4Servidor extends Thread {

	private ServerSocket servidor;
	private DataInputStream in;
	private DataOutputStream out;
	private Socket sc = null;
	private int numPalabras;
	private int numCaracteres;
	private String palabra = "";

	public Ej4Servidor() {
		

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			servidor = new ServerSocket(Ej4.PORT);
			sc = servidor.accept();
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			while (!palabra.equals("*")) {

				palabra = in.readUTF();
				numCaracteres = palabra.length();
				if (!palabra.equals("*")) {
					out.writeInt(numCaracteres);
				}
			}
			
			in.close();
			out.close();
			sc.close();
			servidor.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
