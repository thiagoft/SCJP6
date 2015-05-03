package Atribuicoes;

public class SobrecargaAvancada {
	//Ampliar Wrappers não é possivel,ou seja...ex: um Integer não pode ser um Long
	//assim como é impossivel fazer o mesmo com boxing, um byte não pode ser passado
	//para um Long, POREM E IMPORTANTE o boxing é valido para um Object 
	static void teste(Object a) {
		Long b = (Long) a;		
		System.out.println("teste");
	}
	
	static void teste1() {
		byte a = 5;
		teste(5); // valido vide explicação acima pois o boxing atende Polimorfismo
				  // quando um Byte extends Object
	}
	
	//quando um tipo primitivo explicito não estiver sobrecarregado o compilador
	//usara o metodo com menor argumento que seja mais amplo que o parametro
	
	//REGRA GERAL POR ORDEM
	//primitivos
	//wrappers
	//var args
	
	static void go(int x) { 
		System.out.println("int");
	}
	
	static void go(long x) { 
		System.out.println("long");
	}
	
	static void go(double x) { 
		System.out.println("double");
	}
	
	public static void main(String[] args) {
		byte b = 5;
		short s = 5;
		long l = 5;
		float f = 5.0f;
		
		go(b);
		go(s);
		go(l);
		go(f);
		
		//produzira int int long double
	}
}
