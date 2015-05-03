package OrientacaoAObjetos;

class Teste2 {
	
}

class Teste1 extends Teste2 {
	public Teste2 teste() {
		System.out.println("Teste2");
		return new Teste2();
	}
}

public class TesteDeSobrescrita extends Teste1 {
	public Teste1 teste() {
		System.out.println("Teste1");
		return new Teste1();
	}
	
	public static void main(String[] args) {
		Teste1 obj = new TesteDeSobrescrita();
		obj.teste();
	}
}
