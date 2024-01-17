package ejemplosMonitor10;

import java.util.ArrayList;

public class BufferMonitor {

	ArrayList <String> contenido;

	public BufferMonitor() {
		contenido=new ArrayList<String>();
	}

	public synchronized String get(String name) {
		String resultado;
		while (contenido.isEmpty())// No hay consumidor ejecutando
		{
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		resultado = contenido.remove(0);
		System.out.println(name + " Consumiendo: " + resultado);
		notifyAll();
		return resultado;
	}

	public synchronized void put(String cadena, String name) {
		while (contenido.size()==10) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(name + " --->Produciendo: " + cadena);
		contenido.add(cadena);
		notifyAll();
	}
}
