package Atribuicoes;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("Um numero que come�a com 0, o compilador assumira que voc� esta falando de um numero octal\n");
		anotacoes.append("Um numero que come�a com 0x, o compilador assumira que voc� esta falando de um numero hexadecimal\n");
		anotacoes.append("Um numero nunca come�ara com letras\n");
		anotacoes.append("Um objeto pode voltar a ser acessivel atraves do metodo finalize mesmo dps de ser elegivel\n");
		anotacoes.append("Primitivos n�o recebem null\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
		
		System.out.println("Precedencias");
		
		//compara��es booleanas tem precedencia a atribui��o
		boolean b1 = false;
		boolean b2 = false;
		//System.out.println(b2 != b1 = !b2); logo isso n�o compilar�...
		//b2 != b1 tem precedencia a b1 = !b2.
		//logo false = !b2 n�o � permitido
		
		 System.out.println(5 + 6 +""); // isso retornar� 11 pois quando a atribui��o string est�
		 								//a esquerda ent�o a opera��o ser� realizada primeiro
		 								//ou seja avalia-se da esquerda para a direita
	}
}
