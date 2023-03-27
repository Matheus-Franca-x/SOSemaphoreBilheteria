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
				
				if(login())
				{
					if(buy())
					{
						
					}
				}
				
				
			}
		}.start();
	}
	
	public boolean buy() 
	{
		int tempo = (int) (Math.random() * 2001) + 1000;
		try {
			sleep(tempo);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		if(tempo < 2500)
		{
			return true;
		}
		System.out.println("Usuario " + this.id + " nao foi possivel efetuar a compra.");
		return false;
		
	}
	
	public boolean login()
	{
		int tempo = (int)(Math.random() * 1951 ) + 50;
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (tempo < 1000)
		{
			System.out.println("Usuario " + this.id + " Entrou no sistema.");
			return true;
		}
		System.out.println("Usuario " + this.id + " deu Time Out.");
		return false;

	}
	
}
