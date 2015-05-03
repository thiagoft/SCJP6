package Threads;

public class TestandoThreadsOutrosMetodos {
	//Alem de sleep mais 3 outros métodos
	public static void main(String[] args) {
		Thread thread3 = new Thread(new Thread3());
		Thread thread4 = new Thread(new Thread4());
		//setPriority() não statico - que seta prioridade para as threads, logo uma Thread com prioridade
		//Maior será sempre executada antes das menores
		thread3.setPriority(1);
		thread4.setPriority(1);
		thread3.start();
		thread4.start();
		try {
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			thread3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Thread3 implements Runnable {
	public void run() {
		Thread.yield();
		//O metodo statico yield() simplesmente passa a Thread em execução, para Executavel
		//no intuito de dar espaço a outras threads de mesma prioridade
		//porem, nem sempre yield() cumpre seu papel, ja que, pelo fato de somente coloca-la
		//em estado Executavel, não há garantias que ela mesmo volte para o estado Executando
		for (int x = 0; x < 100; x++) {
			System.out.println("Thread3 : "+x);
		}
	}
}

class Thread4 implements Runnable {
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println("Thread4 : "+x);
		}
	}
}