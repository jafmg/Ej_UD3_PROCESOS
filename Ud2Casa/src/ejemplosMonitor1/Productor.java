package ejemplosMonitor1;


public class Productor extends Thread
{
	private BufferMonitor monitor;
	public Productor(BufferMonitor monitor, String name) 
	{
		super(name);
		this.monitor = monitor;
	}
	public void run() 
	{
		for (int i = 0; i < 15; i++)
		{
			monitor.put("Elem: " + i, this.getName());
//			System.out.println("El "+name+" ha producido el elemento: " + i);
			try 
			{
				sleep(10);
			}
			catch (InterruptedException e) { }
		}
	}
}
