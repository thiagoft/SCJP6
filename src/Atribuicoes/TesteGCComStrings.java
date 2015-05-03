package Atribuicoes;

public class TesteGCComStrings {
	
	public void compute(Object p) {
		Object a = new Object();
		int x = 100;
		String str = "abc";
	}
	
	public static void main(String[] args) {
		TesteGCComStrings obj = new TesteGCComStrings();
		obj.finalize(); //chamar finalize de uma instancia será como chamar o qualquer metodo
		obj.compute(null);
		
		// o objeto "a" de compute perdera a referencia quando o metodo terminar
		// porem str apesar de tambem perder a referencia seu objeto string "abc" fica no pool de strings
		// logo o metodo compute elegerá somente 1 objeto para GC
	}
	
	public void finalize() { // finalize throws Throwable
		try {
			super.finalize();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Tete");
	}
	//qualquer exception que for lançada dentro de finalize será ignorada quando GC estiver destruindo o objeto
}
