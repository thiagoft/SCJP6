package OrientacaoAObjetos;

public class TesteObjects {
	public static void main(String[] args) {
		AA aa = new AA();
		
		BB bb = new BB();
		
		CC cc = new CC();
		
		BB bc = new CC();
		
		DD dd = new DD();
		
		//aa = bb; //bb pode ser aa porque bb � um AA
		
		//bb = (BB) aa; //ClassCastException porque aa n�o � BB, porem compila com Cast 
		
		//AA teste = new BB(); funciona pois teste � do tipo AA porem um objeto de BB pois BB � um AA
		//bb = (BB) teste; bb=teste daria erro de compila��o pois teste � AA e AA n�o � um BB, porem teste referencia um
		// objeto BB pois BB � um AA, logo o Cast de teste para BB � valido
		
		//bc = (BB) dd; impossivel pois DD n esta na arvore de heran�a de BB, logo erro de compila��o
		
		//if (aa instanceof DD) { erro de compila��o pois DD n�o � da arvore de Heran�a de AA
		//	System.out.println("Sim");
		//}
		
		AA a = new BB();
		a.test();
		System.out.println(a.a);
	}
}

class AA {
	public int a = 20;
	void test() {
		System.out.println("Instancia de A");
		System.out.println(a);
	}
}

class BB extends AA {
	public int a = 10;
	void test() {
		System.out.println("Instancia de B");
		System.out.println(a);
	}
	
}

class CC extends BB {
	void test() {
		System.out.println("Instancia de C");
		System.out.println(this.a);
	}
}
class DD {
	
}

