package ejemplosSemaforo1;

public class Productor extends Thread 
{ 
   private BufferSemaforo cola;
    private int nVeces;
    Productor(BufferSemaforo cola,String name){
    	super(name);
        this.cola = cola;
    } 
  
    public void run() 
    { 
        for (int i = 0; i < 10; i++) 
        {
            cola.put(this.getName(),i);  
//            try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
        }
    } 
} 

