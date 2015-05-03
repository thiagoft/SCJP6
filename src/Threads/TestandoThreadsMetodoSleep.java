package Threads;

public class TestandoThreadsMetodoSleep {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Thread1());
		Thread thread2 = new Thread(new Thread2());
		thread1.start();
		thread2.start();
	}
}

class Thread1 implements Runnable {
	public void run() {
		try {
			Thread.sleep(1000); //O m�todo sleep() suspende a Thread pelo tempo passado
								//por par�metro.
								//Porem, ao acordar a Thread volta ao estado Executavel
								//e n�o Executando, logo, n�o necess�riamente ela v�
								//Executar imediatamente apos acordar
			//OBS: o metodo statico sleep(long tempo) atua sobre a thread em execu��o no momento 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int x = 0; x < 10; x++) {
			System.out.println("Thread1 : "+x);
		}
	}
}

class Thread2 implements Runnable {
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int x = 0; x < 10; x++) {
			System.out.println("Thread2 : "+x);
		}
	}
}