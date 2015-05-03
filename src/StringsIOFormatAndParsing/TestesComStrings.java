package StringsIOFormatAndParsing;

public class TestesComStrings {
	public static void main(String[] args) {
		//Objeto String sendo criado no heap
		String a = new String("Thiago");
		//objeto String literal sendo criado no pool de strings
		String b = "Thiago";
		
		// primeiro argumento começa em 0...
		// segundo argumento começa em 1...
		System.out.println(a.substring(0, 3)); // Thi
		//a não se modificará pois os metodos de String não criam novas Strings
		System.out.println(a);
		
		//IMPORTANTE: A classe String é final, não pode ser extendida... logo
		//seus metodos não podem ser sobrescritos
		
		//Strings literais são adicionadas ao pool de Strings ou seja... não são elegiveis ao GC
		
		//Os testes abaixo servem para StringBuffer também
		//append(),delete(),insert(),replace() e reverse() retornam um StringBuffer, logo aplicam a modificação ao objeto 
		StringBuilder c = new StringBuilder();
		c.append("Thiago");
		c.substring(0,3);
		c.reverse();
		System.out.println(c.toString()); //ogaihT as StringBuilders não precisam de atribuição
		c.reverse();
		
		StringBuilder d = new StringBuilder();
		d.append("Thiago");
		
		System.out.println(c == d); //false pois são objetos diferentes
		System.out.println(c.equals(d));// false pois não sobrescreve equals... logo
										// é comparada a referencia e não o valor
		
		String a1 = "java";
		String a2 = "java";
		System.out.println("a1 == a2 = "+(a1 == a2));
		
		System.out.println("METODOS de STRING");
		//METODOS de STRING
		String e = "Thiago";
		System.out.println(e.charAt(3)); //a
		System.out.println(e.concat(" Fonseca")); //Thiago Fonseca
		System.out.println(e.equalsIgnoreCase("THIAGO")); //true
		System.out.println(e.length()); //6
		System.out.println(e.replace("T","Y")); //Yhiago
		System.out.println(e.substring(0,3)); //Thi
		System.out.println(e.toLowerCase()); //thiago
		System.out.println(e.toUpperCase()); //THIAGO
		System.out.println("         THI    ".trim()); //THI
		System.out.println(e.toString()); //Thiago
		
		System.out.println("METODOS DE STRINGBUILDER E STRINGBUFFER");
		//METODOS DE STRINGBUILDER E STRINGBUFFER
		StringBuilder f = new StringBuilder();
		f.append("Thiago");
		System.out.println(f);
		System.out.println(f.delete(3, 6));
		System.out.println(f.insert(3, "ago"));
		System.out.println(f.reverse());
		System.out.println(f.reverse());
		System.out.println(f.toString());
		
		String ateste = " 2 3 2 5";
		ateste = ateste.replace(" ", "");
		System.out.println(ateste);
		
	}
}
