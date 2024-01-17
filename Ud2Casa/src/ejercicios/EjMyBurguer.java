package ejercicios;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EjMyBurguer {
	public static int numeroTipos = 0;
	public static boolean electricidad = false;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		MiMonitor monitor = new MiMonitor(electricidad, input);
		Fabricante f1 = new Fabricante("FABRICANTE 1", monitor);
		
		ConsumidorHamburguesa c1 = new ConsumidorHamburguesa("CONSUMIDOR_1", f1, monitor);
		ConsumidorHamburguesa c2 = new ConsumidorHamburguesa("CONSUMIDOR_2", f1, monitor);
		ConsumidorHamburguesa c3 = new ConsumidorHamburguesa("CONSUMIDOR_3", f1, monitor);
		
		System.out.println("\t\t\t Pulse 1 para inciar el ciclo de producción.");
		electricidad = (input.nextInt() == 1) ? true : false;
		
		f1.start();
		c1.start();
		c2.start();
		c3.start();

	}

}

class Fabricante extends Thread {

	private String nombre;
	private String[] tipos = { "Bacon", "Cebolla", "Huevo" };
	private MiMonitor monitor;

	public Fabricante(String nombre, MiMonitor monitor) {
		this.nombre = nombre;
		this.monitor = monitor;

	}

	public String[] getTipos() {
		return tipos;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 5; i++) {
//			monitor.put(this);
		}
	}
}

class ConsumidorHamburguesa extends Thread {
	private String nombre;
	private String tipo;
	private MiMonitor monitor;

	public ConsumidorHamburguesa(String nombre, Fabricante fabricante, MiMonitor monitor) {
		this.nombre = nombre;
		tipo = fabricante.getTipos()[EjMyBurguer.numeroTipos++];
		this.monitor = monitor;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for(int i = 0; i < 5; i++) {
//			monitor.consume(this);
		}
		
		
	}

}

class MiMonitor {

	private ArrayList<String> cadenaMontaje;

	public MiMonitor(boolean electricidad, Scanner input) {

		cadenaMontaje = new ArrayList<String>();
	}

	public synchronized void consume(ConsumidorHamburguesa consumidor, Scanner input) {

		while (cadenaMontaje.size() == 0 && EjMyBurguer.electricidad) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		

		// Recorre la cadena en busca del tipo correspondiente
		for (String hamburguesa : cadenaMontaje) {

			
			if (hamburguesa.equals(consumidor.getTipo())) {
				cadenaMontaje.remove(hamburguesa);
				System.out.println(consumidor.getNombre() + "ha consumido" + hamburguesa);
				break;
			}
		}
		System.out.println("\t\t\t Quiere continuar?.");
		EjMyBurguer.electricidad = (input.nextInt() == 1) ? true : false;
		notifyAll();

	}

	public synchronized void put(Fabricante fabricante, Scanner input) {
		Random aleatorio = new Random();
		int clase; // clase de hamurguesa
		
		if(cadenaMontaje.size() == 5 && !EjMyBurguer.electricidad) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		clase = aleatorio.nextInt(3); // el límite superior es exclusivo
		cadenaMontaje.add(fabricante.getTipos()[clase]);
		System.out.println("Add" + fabricante.getTipos()[clase]);
		System.out.println("\t\t\t Quiere continuar?.");
		EjMyBurguer.electricidad = (input.nextInt() == 1) ? true : false;
		notifyAll();

	}

}
