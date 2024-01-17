package ejemplosSemaforo10;

public class Productor extends Thread {
	private BufferSemaforo cola;

	public Productor(BufferSemaforo cola, String name) {
		super(name);
		this.cola = cola;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			cola.put(this.getName(), i);
            try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
