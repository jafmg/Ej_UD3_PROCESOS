package ejemplosMonitor1;

public class BufferMonitor {

	private boolean turnoConsumidor = false;// Partimos de que no hay contenido
	private String contenido ="";

	public BufferMonitor() {

	}

	public synchronized String get(String name) {
		String resultado;
		while (!turnoConsumidor)// No hay consumidor ejecutando
		{
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		
		resultado = contenido;
		contenido ="";
		System.out.println(name + " Consumiendo: " + resultado);
		turnoConsumidor = false;
		notifyAll();
		return resultado;
	}

	public synchronized void put(String cadena, String name) {
		while (turnoConsumidor) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println(name + " --->Produciendo: " + cadena);
		contenido =cadena;
		turnoConsumidor = true;
		notifyAll();
	}
}
