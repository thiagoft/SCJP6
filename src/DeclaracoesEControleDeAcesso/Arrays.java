package DeclaracoesEControleDeAcesso;

import java.util.Vector;

public class Arrays {
	public static void main(String[] args) throws Exception {
		String[] a = new String[4];
		String b [] = new String[4];
		String[] c = {"Thiago","Thaisa"};
		String[] d = new String[] {"Thiago","Thaisa"};
		String[][] e = new String[4][]; // o primeiro conjunto deve ter um tamanho, logo se n�o tiver tera erro de compila��o
		
		//Object[] e = new Object[]{ "aaa", new Object(), new Vector(), {} }; n�o compila, pois {} n�o � um Object
		
		//String[4] e = new String[]; invalido pois n�o � valido declarar o tamanho na declara��o
		
		//as arrays permitem todas as regras de polimorfismo, tanto para declara��o
		//quanto para seus membros
		
		//todos os itens de um array s�o inicializados com seu valor padr�o,
		//sendo que os objetos s�o inicializados com null
		
		 int[] h = null;
	     //int i = h [0]; //NullPointerException
	     int j = h [teste()];
	}
	static int teste()throws Exception{
		System.out.println("Entra primeiro no metodo");
		throw new Exception();
	}
}
