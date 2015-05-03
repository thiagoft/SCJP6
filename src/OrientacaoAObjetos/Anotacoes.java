package OrientacaoAObjetos;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("Uma subclasse de uma subclasse nunca poder� chamar a super classe de sua super classe diretamente\n");
		anotacoes.append("Qualquer metodo que retorne Object, por polimorfismo pode retornar qualquer objeto ja que Object � Superclasse de qualquer classe\n");
		anotacoes.append("Uma classe que extende outra herda tamb�m suas variaveis e m�todos estaticos\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
	}
}
