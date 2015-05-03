package Threads;

public class TestandoThreads {
	public static void main(String[] args) {
		//Um programa termina quando todas as non-daemon threads terminam
		//A classe pode extender Thread e implementar run()
		//a prioridade de um thread é = a de sua criadora
		//Main thread created by the JVM is not a daemon thread
		TesteThreadExtends testeThreadExtends = new TesteThreadExtends();
		testeThreadExtends.start();
		
		//A classe pode implementar Runnable e implementar o método run
		TesteThreadRunnable testeRunnable = new TesteThreadRunnable();
		//porem deve-se instanciar a Thread e passar como argumento do construtor nesse caso
		Thread teste1 = new Thread(testeRunnable);
		Thread teste2 = new Thread(testeRunnable);
		Thread teste3 = new Thread(testeRunnable);
		teste1.start();
		teste2.start();
		teste3.start();
		
		//teste3.start(); erro em tempo de execução, pois uma thread n pode ser startada 2x
		
		//Atravez de classe anonima
		TesteThreadRunnable threadAnonima = new TesteThreadRunnable() {
			public void run() {
				System.out.println("Thread da classe anonima");
			}
		}; //lembrar do ponto e virgula
		Thread teste4 = new Thread(threadAnonima);
		teste4.start();
		
		//ou método anonimo
		
		Thread teste5 = new Thread(new TesteThreadRunnable() {
			public void run() {
				System.out.println("Thread da classe anonima de argumento");
			}
		});
		teste5.start();
		
		//Outra maneira de instanciar uma Thread 
		//a pripria classe Thread implementa Runnable, logo uma Thread passa no teste
		//É-UM para Runnable e pode ser passado como Parâmetro
		Thread teste6 = new Thread(new TesteThreadExtends());
		teste6.start();
		
		//IMPORTANTE: o método run é um método como qualquer outro, logo pode ser chamado
		//de uma instancia normalmente, porem não quer dizer que uma Thread o tenha chamado
		
		System.out.println("Alguns Métodos de Threads");
		//Thread tem alguns métodos utilitários, alem de seu construtor sobrecarregado
		//Thread()
		//Thread(Runnable target)
		//Thread(Runnable target,String name)
		//Thread(String name)
		//o método setName(String name) também nomeia uma Thread
		//Thread.currentThread() //retorna a Thread rodando atualmente no estado "Executando"
		//Thread.currentThread().getName() //retorna o nome rodando atualmente no estado "Executando"
		//Thread.getId() retorna um long identificador da Thread no estado "Executando"
		
		System.out.println("O Agendador");
		//O agendador(Scheduler) é responsavel por gerenciar as Threads e este gerenciamento envolve estados
		
		//-Quando uma Thread é startada, ou seja, seu méotod start() foi chamado ela ficara em estado
		//Executavel, ou seja, quando uma Thread é startada não quer dizer que seu método run() rodará automaticamente
		
		//-A ordem e quando as Threads passarão do estado Executavel para Executando depende do agendador
		
		//-Para uma máquina com apenas 1 nucleo de processamento, somente uma thread pode rodar ao mesmo tempo
		//porem muitas podem estar em estado Executavel
		
		
	}
}

class TesteThreadExtends extends Thread {
	public void run() {
		System.out.println("Teste Thread Extends");
	}
}

class TesteThreadRunnable implements Runnable {
	public void run() {
		System.out.println("Teste Thread Runnable");
	}
}
