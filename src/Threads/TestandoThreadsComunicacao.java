package Threads;

public class TestandoThreadsComunicacao {
	
	
	public static void main(String[] args) {
		ThreadDesenho desenho = new ThreadDesenho();
		ThreadCorta corte = new ThreadCorta();
		Thread maquinaDeDesenho = new Thread(desenho);
		Thread maquinaDeCorte = new Thread(corte);
		maquinaDeDesenho.start();
		maquinaDeCorte.start();
		
		synchronized(maquinaDeDesenho) {
			synchronized(maquinaDeCorte) {
				while (true) {
					//try {
						maquinaDeCorte.notifyAll();
						maquinaDeDesenho.notifyAll();
					//} catch(InterruptedException e) {
					//	e.printStackTrace();
					//}
					//System.out.println("Cortando...");
				}
			}
		}
			
	}
}

class ThreadDesenho implements Runnable {
	
	public void run() {
		synchronized(this) {
			while(true) {
				realizaDesenho();
				
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notifyAll();
			}
		}
	}
	
	public void realizaDesenho() {
		System.out.println("Desenhando...");
	}
}

class ThreadCorta implements Runnable {	
	public void run() {
		synchronized(this) {
			while(true) {
				realizaCorte();
				
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				notifyAll();
			}
		}
	}
	
	public void realizaCorte() {
		System.out.println("Cortando...");
	}
}