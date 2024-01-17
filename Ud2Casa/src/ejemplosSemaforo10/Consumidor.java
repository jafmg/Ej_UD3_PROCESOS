package ejemplosSemaforo10;

public class Consumidor extends Thread {
	private BufferSemaforo cola;

	public Consumidor(BufferSemaforo cola, String name) {
		super(name);
		this.cola = cola;
	}

	public void run() {

		for (int i = 0; i < 10; i++) {
			cola.get(getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
