package OrientacaoAObjetos;

public class TesteObjects {
	public static void main(String[] args) {
		AA aa = new AA();
		
		BB bb = new BB();
		
		CC cc = new CC();
		
		BB bc = new CC();
		
		DD dd = new DD();
		
		//aa = bb; //bb pode ser aa porque bb é um AA
		
		//bb = (BB) aa; //ClassCastException porque aa não é BB, porem compila com Cast 
		
		//AA teste = new BB(); funciona pois teste é do tipo AA porem um objeto de BB pois BB é um AA
		//bb = (BB) teste; bb=teste daria erro de compilação pois teste é AA e AA não é um BB, porem teste referencia um
		// objeto BB pois BB é um AA, logo o Cast de teste para BB é valido
		
		//bc = (BB) dd; impossivel pois DD n esta na arvore de herança de BB, logo erro de compilação
		
		//if (aa instanceof DD) { erro de compilação pois DD não é da arvore de Herança de AA
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

