package controller;

import java.util.concurrent.Semaphore;

public class ControllBilheteria extends Thread
{
	static int bilhete = 100;
	int id;
	Semaphore tempo;
	
	public ControllBilheteria(int id, Semaphore tempo) 
	{
		this.id = id; 
		this.tempo = tempo;
		}
	
	public void compraBilhete()
	{
		new Thread()
		{
			public void run()
			{
				int tempo = (int)(Math.random() * 1501 ) + 500;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tempo <= 1000)
				{
					login();
					buy();
				}
				else
				{
					System.out.println("Time Out");
				}
			}
		}.start();
	}
	
	public void buy() 
	{
		
	}
	
	public void login()
	{
		System.out.println(this.id + " Entrou");
		
	}
	
}
