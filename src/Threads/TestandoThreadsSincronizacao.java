package Threads;

public class TestandoThreadsSincronizacao {
	//Formas de declaração de sincronized para metodos de instancia
	public synchronized void teste() {
		
	}
	//ou
	public void teste1() {
		synchronized(this) {
			
		}
	}

	//Formas de declaração de sincronized para metodos estaticos	
	public static synchronized void teste2() {
		
	}
	//ou
	public static void teste3() {
		synchronized(TestandoThreadsSincronizacao.class) {
			
		}
	}
	//ou
	public static void teste4() {
		/*Class classe = Class.forName("TestandoThreadsSincronizacao");
		synchronized(classe) {
			
		}*/
	}
	
	public static void main(String[] args) {
		//Teste caixa eletronico
		/*ThreadAcesso caixaEletronico = new ThreadAcesso();
		Thread thiago = new Thread(caixaEletronico);
		Thread thaisa = new Thread(caixaEletronico);
		thiago.setName("Thiago");
		thaisa.setName("Thaisa");
		thiago.start();
		thaisa.start();*/
		
		//Teste Letras
		ThreadLetras threadLetras = new ThreadLetras();
		Thread a1 = new Thread(threadLetras,"Thead1");
		Thread a2 = new Thread(threadLetras,"Thead2");
		Thread a3 = new Thread(threadLetras,"Thead3");
		a1.start();
		a2.start();
		a3.start();
		
	}
}

//Teste Letras
class ThreadLetras implements Runnable {
	public static StringBuffer a = new StringBuffer();
		
	public void run() {
		synchronized(a) {
			System.out.println(Thread.currentThread().getName()+ " Atual");
			for(int x = 0; x < 10; x++) {
				a.append("A");
			}
			a.append("\n");
			System.out.println(a.toString());
		}
		synchronized(a) {
			for(int x = 0; x < 10; x++) {
				a.append("B");
			}
			a.append("\n");
			System.out.println(a.toString());
		}
		synchronized(a) {
			for(int x = 0; x < 10; x++) {
				a.append("C");
			}
			a.append("\n");
			System.out.println(a.toString());
		}
	}
}

//Teste saque banco
class ThreadAcesso implements Runnable {
	public static Conta conta = new Conta();
	public void run() {
		for (int x = 0; x < 10; x++) {
			this.realizaSaque(10);
		}
	}
	
	private synchronized void realizaSaque(int valor) { //sem synchronized o metodo é acessado pelas 2 threads ao mesmo tempo
														//logo as 2 podem sacar de modo que se não houver mais saldo apos a espera
														//devido a outra conta ter sacado primeiro, poderá haver erros no saque
		if (conta.getSaldo() > 0) {
			System.out.println(Thread.currentThread().getName()+" sacando e o Saldo atual:"+this.conta.getSaldo());
			conta.saque(valor);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " sacou e o saldo agora é de: "+this.conta.getSaldo());
		} else {
			System.out.println("Saldo insuficiente de:"+this.conta.getSaldo());
		}
	}
}

class Conta {
	private int saldo;
	
	{this.saldo = 50;}
	
	public int getSaldo() {
		return saldo;
	}

	public void saque(int valor) {
		this.saldo -= valor;
	}
}
