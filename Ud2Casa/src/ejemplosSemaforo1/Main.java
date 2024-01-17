package ejemplosSemaforo1;



public class Main
{
	public static void main(String[] args) 
	{
		System.out.println("Inicio del hilo principal");
		BufferSemaforo cola = new BufferSemaforo();
		Productor prod1 = new Productor(cola, "Productor1");
		Productor prod2 = new Productor(cola, "Productor2");
		Consumidor cons1 = new Consumidor(cola, "Consumidor1");
		Consumidor cons2 = new Consumidor(cola, "Consumidor2");

		prod1.start();
		prod2.start();
		cons1.start();
		cons2.start();
        
        System.out.println("Fin del hilo principal");
	}
}
