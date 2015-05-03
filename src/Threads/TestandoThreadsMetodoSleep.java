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
			Thread.sleep(1000); //O método sleep() suspende a Thread pelo tempo passado
								//por parâmetro.
								//Porem, ao acordar a Thread volta ao estado Executavel
								//e não Executando, logo, não necessáriamente ela vá
								//Executar imediatamente apos acordar
			//OBS: o metodo statico sleep(long tempo) atua sobre a thread em execução no momento 
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