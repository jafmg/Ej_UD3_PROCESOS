package ejercicios;

public class Ej9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Implementando runnable
try {
	
		
		ContadorEj9 c1 = new ContadorEj9(1, "hilo1", 3);
		ContadorEj9 c2 = new ContadorEj9(4, "hilo2", 6);
		ContadorEj9 c3 = new ContadorEj9(7, "hilo3", 9);
		ContadorEj9 c4 = new ContadorEj9(10, "hilo4", 12);
		
		
		
		
		//Extendiendo Thread
		
//		ContadorThreadEj9 c5 = new ContadorThreadEj9(1, "hilo1", 3);
//		ContadorThreadEj9 c6 = new ContadorThreadEj9(4, "hilo2", 6);
//		ContadorThreadEj9 c7 = new ContadorThreadEj9(7, "hilo3", 9);
//		ContadorThreadEj9 c8 = new ContadorThreadEj9(10, "hilo4", 12);
		
	
		
		//Sin iniciar en el costructor implementando runnable
		
//		Thread t1 = new Thread(c1);
//		Thread t2 = new Thread(c2);
//		Thread t3 = new Thread(c3);
//		Thread t4 = new Thread(c4);
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
		
		System.out.println("Prueba fin");
		

} catch (InterruptedException e) {
	e.printStackTrace();
}	

	}

}

class ContadorEj9 implements Runnable{
	
	private int cont;
	private String nombre;
	private int fin;
	private Thread t;
	
	
	public ContadorEj9(int cont, String nombre, int fin) throws InterruptedException {
		this.cont = cont;
		this.nombre = nombre;
		this.fin = fin;
		t= new Thread(this, this.nombre);
		t.start();
		t.join();
	}


	@Override
	public void run() {
		
		for(int i = cont; i <= fin; i++) {
			System.out.println(cont + " " + nombre);
			cont++;
		}
		
	}
	
	
}


class ContadorThreadEj9 extends Thread {
	
	
	private int cont;
	private String nombre;
	private int fin;
	private Thread t;
	
	
	public ContadorThreadEj9(int cont, String nombre, int fin) throws InterruptedException {
		this.cont = cont;
		this.nombre = nombre;
		this.fin = fin;
		this.start();
		this.join();
	}
	
	
	@Override
	public void run() {
		
		for(int i = cont; i <= fin; i++) {
			System.out.println(cont + " " + nombre);
			cont++;
		}
	}
	
}
