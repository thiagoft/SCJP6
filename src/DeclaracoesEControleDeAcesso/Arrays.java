package DeclaracoesEControleDeAcesso;

import java.util.Vector;

public class Arrays {
	public static void main(String[] args) throws Exception {
		String[] a = new String[4];
		String b [] = new String[4];
		String[] c = {"Thiago","Thaisa"};
		String[] d = new String[] {"Thiago","Thaisa"};
		String[][] e = new String[4][]; // o primeiro conjunto deve ter um tamanho, logo se não tiver tera erro de compilação
		
		//Object[] e = new Object[]{ "aaa", new Object(), new Vector(), {} }; não compila, pois {} não é um Object
		
		//String[4] e = new String[]; invalido pois não é valido declarar o tamanho na declaração
		
		//as arrays permitem todas as regras de polimorfismo, tanto para declaração
		//quanto para seus membros
		
		//todos os itens de um array são inicializados com seu valor padrão,
		//sendo que os objetos são inicializados com null
		
		 int[] h = null;
	     //int i = h [0]; //NullPointerException
	     int j = h [teste()];
	}
	static int teste()throws Exception{
		System.out.println("Entra primeiro no metodo");
		throw new Exception();
	}
}
