package Atribuicoes;

public class Inicializacao {
	//Variaveis de instancia sempre recebem seu valor padrão;
	//variaveis locais(ou automaticas) precisam ser inicializadas;
	
	//Ordem de inicializacao:
	//elementos ou blocos estaticos de toda a arvore de herança da classe da base até a classe atual
	//elementos e blocos de inicialização de instancia seguido pelo construtor de cada classe
	//vide TesteDeInicializacao.class
	
	static {
		System.out.println("primeiro statico");
	}
	
	{
		System.out.println("primeiro instancia");
	}
	
	Inicializacao(int a) {
		System.out.println("Construtor 2");
	}
	
	Inicializacao() {
		this(7);
		System.out.println("Construtor 1");
	}
	
	{
		System.out.println("segundo instancia");
	}
	
	static {
		System.out.println("segundo statico");
	}
	
	//nesse caso i e k serão inicializados com 0 quando a instancia for criada,
	//logo a inicialização 
	//getInt() ira retornar k que é 0 + 1, e k sera inicializaado com 20
	int i = getInt();
    int k = 20;
    public int getInt() {  return k+1;  }
	
	public static void main(String[] args) {
		Inicializacao t = new Inicializacao();
		System.out.println(t.i+"  "+t.k);
	}
}
