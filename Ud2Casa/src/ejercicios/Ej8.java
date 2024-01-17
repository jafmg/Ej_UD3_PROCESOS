package ejercicios;

public class Ej8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Implementando runnable
		
		Contador c1 = new Contador(1, "hilo1", 3);
		Contador c2 = new Contador(4, "hilo2", 6);
		Contador c3 = new Contador(7, "hilo3", 9);
		Contador c4 = new Contador(10, "hilo4", 12);
		
		
		//Extendiendo Thread
		
//		ContadorThread c5 = new ContadorThread(1, "hilo1", 3);
//		ContadorThread c6 = new ContadorThread(4, "hilo2", 6);
//		ContadorThread c7 = new ContadorThread(7, "hilo3", 9);
//		ContadorThread c8 = new ContadorThread(10, "hilo4", 12);
		
	
		
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
		

		

	}

}

class Contador implements Runnable{
	
	private int cont;
	private String nombre;
	private int fin;
	private Thread t;
	
	
	public Contador(int cont, String nombre, int fin) {
		this.cont = cont;
		this.nombre = nombre;
		this.fin = fin;
		t= new Thread(this, this.nombre);
		t.start();
	}


	@Override
	public void run() {
		
		for(int i = cont; i <= fin; i++) {
			System.out.println(cont + " " + nombre);
			cont++;
		}
		
	}
	
	
}


class ContadorThread extends Thread {
	
	
	private int cont;
	private String nombre;
	private int fin;
	private Thread t;
	
	
	public ContadorThread(int cont, String nombre, int fin) {
		this.cont = cont;
		this.nombre = nombre;
		this.fin = fin;
		this.start();
	}
	
	
	@Override
	public void run() {
		
		for(int i = cont; i <= fin; i++) {
			System.out.println(cont + " " + nombre);
			cont++;
		}
	}
	
}
