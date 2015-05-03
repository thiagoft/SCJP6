package StringsIOFormatAndParsing;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("StringBuffers s�o threadsafe, logo se voc� utilizar StringBuilders para trabalhar com Thread, podera corromper os dados\n");
		anotacoes.append("java.io.StringBufferInputStream n�o tem nada haver com StringBuffer e � uma classe Depreciada\n");
		anotacoes.append("StringBuilder foi adicionda no JDK 1.6\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
	}
}
