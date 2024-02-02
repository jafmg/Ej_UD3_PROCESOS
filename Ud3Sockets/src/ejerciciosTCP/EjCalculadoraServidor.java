package ejerciciosTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EjCalculadoraServidor {

	final static Integer PORT = 5000;

	public static void main(String[] args) {

		ServerSocket ssc = null;
		Socket sc;
		DataInputStream input;
		DataOutputStream output;
		double operando1;
		double operando2 = 3;
		String operador;
		String[] cadena;
		double resultado = 0;

		try {
			ssc = new ServerSocket(PORT);
			System.out.println("Esperando clientes");
			sc = ssc.accept();
			input = new DataInputStream(sc.getInputStream());
			output = new DataOutputStream(sc.getOutputStream());
			System.out.println("Conexion establecida\n");

			while (true) {
				
				cadena = input.readUTF().split(" ");
				operando1 = Double.valueOf(cadena[0]);
				operador = cadena[1];
				operando2 = Double.valueOf(cadena[2]);
				switch (operador) {

				case "+":
					resultado = operando1 + operando2;
					break;
				case "-":
					resultado = operando1 - operando2;
					break;
				case "/":
					resultado = operando1 / operando2;
					break;
				case "*":
					resultado = operando1 * operando2;
					break;
				default:
					break;
				}
				output.writeUTF(String.valueOf(resultado));

				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
