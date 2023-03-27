package view;

import java.util.concurrent.Semaphore;

import controller.ControllBilheteria;

public class Main {

	public static void main(String[] args)
	{
		Semaphore perm = new Semaphore(1);
		
		for(int i = 1; i <= 300; i++)
		{
			ControllBilheteria control = new ControllBilheteria(i, perm);
			control.areaUsuario();
		}
	}
}
