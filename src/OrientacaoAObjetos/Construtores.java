package OrientacaoAObjetos;

//Pode-se somente existir this ou super em um construtor nunca os dois.
//Podem usar qualquer modificador de acesso referentes a acesso
//o contrutor default de uma classe terá o mesmo modificador de acesso da classe

class A {
	A() {
		System.out.println("A");
	}
}

class B extends A {
	B() {
		System.out.println("B");
	}
}

public class Construtores extends B {
	Construtores() throws Exception {
		System.out.println("C");
	}
	
	Construtores(String a) throws Exception { //Construtores podem lançar exception
		this();
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		try {
			Construtores obj = new Construtores("Começo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
