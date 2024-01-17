package ejemplosMonitor1;

public class Main {
	public static void main(String[] args) {
		System.out.println("Inicio del hilo principal");

		BufferMonitor monitor = new BufferMonitor();
		Productor prod1 = new Productor(monitor, "Productor1");
		Productor prod2 = new Productor(monitor, "Productor2");
		Consumidor cons1 = new Consumidor(monitor, "Consumidor1");
		Consumidor cons2 = new Consumidor(monitor, "Consumidor2");

		prod1.start();
		prod2.start();
		cons1.start();
		cons2.start();
		
		

		System.out.println("Fin del hilo principal");
	}
}
