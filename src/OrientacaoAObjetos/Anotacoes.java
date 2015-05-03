package OrientacaoAObjetos;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("Uma subclasse de uma subclasse nunca poderá chamar a super classe de sua super classe diretamente\n");
		anotacoes.append("Qualquer metodo que retorne Object, por polimorfismo pode retornar qualquer objeto ja que Object é Superclasse de qualquer classe\n");
		anotacoes.append("Uma classe que extende outra herda também suas variaveis e métodos estaticos\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
	}
}
