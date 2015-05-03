package Atribuicoes;

public class Inicializacao {
	//Variaveis de instancia sempre recebem seu valor padr�o;
	//variaveis locais(ou automaticas) precisam ser inicializadas;
	
	//Ordem de inicializacao:
	//elementos ou blocos estaticos de toda a arvore de heran�a da classe da base at� a classe atual
	//elementos e blocos de inicializa��o de instancia seguido pelo construtor de cada classe
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
	
	//nesse caso i e k ser�o inicializados com 0 quando a instancia for criada,
	//logo a inicializa��o 
	//getInt() ira retornar k que � 0 + 1, e k sera inicializaado com 20
	int i = getInt();
    int k = 20;
    public int getInt() {  return k+1;  }
	
	public static void main(String[] args) {
		Inicializacao t = new Inicializacao();
		System.out.println(t.i+"  "+t.k);
	}
}
