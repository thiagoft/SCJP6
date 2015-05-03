package Atribuicoes;

class A1 {
	int a = this.teste();
	static int b = testeStatic();
	static {System.out.println("statico 1");}
	{System.out.println("Instancia 1");}
	static {System.out.println("statico 2");}
	{System.out.println("Instancia 2");}
	static int c = testeStatic();
	int d = this.teste();
	
	A1() {
		System.out.println("Construtor 1");
	}
	
	int teste() {
		System.out.println("inicializacao a");
		return 0;
	}
	static int testeStatic() {
		System.out.println("inicializacao b");
		return 0;
	}
}

class B1 extends A1 {
	int e = this.teste2();
	static int f = testeStatic();
	static {System.out.println("statico 3");}
	{System.out.println("Instancia 3");}
	static {System.out.println("statico 4");}
	{System.out.println("Instancia 4");}
	static int g = testeStatic();
	int h = this.teste2();
	
	B1() {
		System.out.println("Construtor 2");
	}
	
	int teste2() {
		System.out.println("inicializacao e");
		return 0;
	}
	static int testeStatic() {
		System.out.println("inicializacao f");
		return 0;
	}
}

public class TesteDeInicializacao extends B1 {
	public static void main(String[] args) {
		new TesteDeInicializacao();
	}
}
