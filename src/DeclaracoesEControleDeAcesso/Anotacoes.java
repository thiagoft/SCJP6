package DeclaracoesEControleDeAcesso;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
	}
}
