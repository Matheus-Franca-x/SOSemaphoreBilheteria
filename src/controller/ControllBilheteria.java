package controller;

import java.util.concurrent.Semaphore;

public class ControllBilheteria extends Thread
{
	private static int bilhete = 100;
	private int id;
	Semaphore tempo;
	
	public ControllBilheteria(int id, Semaphore tempo) 
	{
		this.id = id; 
		this.tempo = tempo;
		}
	
	public void areaUsuario()
	{
		new Thread()
		{
			public void run()
			{
				
				if(login())
				{
					if(buy())
					{
						if(validarBilhete())
						{
							try {
								tempo.acquire();
								compraBilhete();
								sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							} finally {
								tempo.release();
							}
						}
					}
				}
			}
		}.start();
	}
	
	private void compraBilhete()
	{
		int compraB = (int) (Math.random() * 4) + 1;
		
		if(compraB > bilhete)
		{
			System.out.println("Usuario " + this.id + " nao foi possivel fazer a compra por falta de bilhete.");
		}
		else
		{
			bilhete -= compraB;
			System.out.println("Usuario " + this.id + " comprou " + compraB + " bilhetes.");
		}
		
	}
	
	private boolean validarBilhete()
	{
		if (bilhete > 0)
		{
			return true;
		}
		return false;
	}
	
	private boolean buy() 
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
			System.out.println("Usuario " + this.id + " pode efetuar a compra.");
			return true;
		}
		System.out.println("Usuario " + this.id + " nao foi possivel efetuar a compra.");
		return false;
		
	}
	
	private boolean login()
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
