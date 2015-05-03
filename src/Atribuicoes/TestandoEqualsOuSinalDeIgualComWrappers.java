package Atribuicoes;

public class TestandoEqualsOuSinalDeIgualComWrappers {
	public static void main(String[] args) {
		//entradas possiveis que retornam true
		//0
		//-1
		//127 - Shorts e Integers de -128 a 127 podem ser comparados com ==
		//acima disso é necessario usar equals no exemplo abaixo 128 retornaria false
		//logo -256 ou 256 retornam falso
		//é importante lembrar que somente para literais ou mesma referencia
		Integer i = Integer.parseInt("127");
		Integer j = i;
		i--;
		i++;
		System.out.println((i==j));
		
		Integer b = new Integer(42);
		Long ln = new Long(42);
		Double d = new Double(42.0);
		
		//b == ln; 
		//ln == d; erro de compilação pois são objetos diferentes de tipos diferentes
		System.out.println(b.equals(d));  //Comparar wrappers diferentes será sempre false
		System.out.println(d.equals(ln)); //pois os wrappers implementam equals que avalia 
		System.out.println(ln.equals(42)); //a instancia, logo não passara no teste instanceof
	}
}
