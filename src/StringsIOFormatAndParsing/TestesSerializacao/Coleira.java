package StringsIOFormatAndParsing.TestesSerializacao;

public class Coleira {
	private String nome;
	private int numero;

	public Coleira(String nome,int numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String toString() {
		return "Coleira com a identifica��o:"+this.nome+" de numero:"+this.numero;
	}
}
