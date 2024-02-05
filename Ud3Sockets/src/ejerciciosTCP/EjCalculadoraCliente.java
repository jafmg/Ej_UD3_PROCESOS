package ejerciciosTCP;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import librerias.IO;

public class EjCalculadoraCliente {

	final static String HOST = "127.0.0.1";
	final static Integer PORT = 5000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Socket sc;
		DataInputStream input;
		DataOutputStream output;
		BufferedWriter bw;
		EjCalculadoraOperacionPaquete p1;
		int operando1;
		int operando2;
		String operador;
		String cadena[];
		String resultado;

		try {
			sc = new Socket(HOST, PORT);
			input = new DataInputStream(sc.getInputStream());
			output = new DataOutputStream(sc.getOutputStream());

			while (true) {

				System.out.println("Qué necesita calcular?");
				cadena = IO.readString().split(" ");
				
				if(cadena.length != 3) {
					break;
				}
				
				operando1 = Integer.valueOf(cadena[0]);
				operador = cadena[1];
				operando2 = Integer.valueOf(cadena[2]);

				p1 = new EjCalculadoraOperacionPaquete(operando1, operando2, operador);

				
				output.writeUTF(p1.toString());
				resultado = input.readUTF();
				
				System.out.println("Resultado calculado en el servidor" + resultado);
				
				

			}
			
			input.close();
			sc.close();
			output.close();
			
			
		} catch (IOException err) {
			err.printStackTrace();
		} 

	}
}
