package ejemplosMonitor10;

public class Main
{
	public static void main(String[] args) 
	{
		System.out.println("Inicio del hilo principal");

		BufferMonitor monitor = new BufferMonitor();
		Productor prod1 = new Productor(monitor, "Productor1");
		Productor prod2 = new Productor(monitor, "Productor2");
		Productor prod3 = new Productor(monitor, "Productor3");
		Consumidor cons1 = new Consumidor(monitor, "Consumidor1");
		Consumidor cons2 = new Consumidor(monitor, "Consumidor2");
		Consumidor cons3 = new Consumidor(monitor, "Consumidor3");
		
		prod1.start();
		prod2.start();
		prod3.start();
		cons1.start();
		cons2.start();
		cons3.start();

		System.out.println("Fin del hilo principal");
		}
}
