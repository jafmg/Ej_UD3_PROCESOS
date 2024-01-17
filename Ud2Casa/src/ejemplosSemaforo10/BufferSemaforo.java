package ejemplosSemaforo10;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class BufferSemaforo {
	ArrayList<String> contenido;
	//Voy a suponer que el buffer no puede tener tama�o mayor que 10
	static Semaphore hayEspacio = new Semaphore(10, true);
	static Semaphore hayDatos = new Semaphore(0, true);
	static Semaphore semaforoMutex = new Semaphore(1);

	public BufferSemaforo() {
		contenido = new ArrayList<String>();
	}

	public void put(String name, int elemento) {
		try {
			hayEspacio.acquire(1);//Podemos poner el 1 o dejarlo vacio, hace lo mismo
			semaforoMutex.acquire();
		} catch (InterruptedException e) {
		}
		String elem = name + " E" + elemento;
		contenido.add(elem);

		System.out.println("El " + name + " ha producido: " + elem);
		semaforoMutex.release();
		hayDatos.release();
	}

	public void get(String name) {
		String resultado;
		try {
			hayDatos.acquire(1);
			semaforoMutex.acquire();

		} catch (InterruptedException e) {
		}
		resultado = contenido.remove(0);
		System.out.println("El " + name + " ha consumido el elemento: " + resultado);
		semaforoMutex.release();
		hayEspacio.release(1);
	}

}
