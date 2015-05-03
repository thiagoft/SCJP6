package StringsIOFormatAndParsing;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("StringBuffers são threadsafe, logo se você utilizar StringBuilders para trabalhar com Thread, podera corromper os dados\n");
		anotacoes.append("java.io.StringBufferInputStream não tem nada haver com StringBuffer e é uma classe Depreciada\n");
		anotacoes.append("StringBuilder foi adicionda no JDK 1.6\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
	}
}
