package ejemplosMonitor10;


public class Consumidor extends Thread
{
	private BufferMonitor monitor;
    
    Consumidor(BufferMonitor monitor, String name) 
    { 
    	super(name);
        this.monitor = monitor;
    } 
  
    public void run() 
    { 

    	for (int i = 0; i < 15; i++)
        {
    		 monitor.get(this.getName()); 
//    		System.out.println("El "+this.getName()+" ha consumido el: " + r);
//            try
//            {
//				Thread.sleep(100);
//			} catch (InterruptedException e) 
//            {
//				e.printStackTrace();
//			}
        }
    } 
}
