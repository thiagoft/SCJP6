package Atribuicoes;

public class Anotacoes {
	public static final StringBuilder anotacoes;
	
	static {
		anotacoes = new StringBuilder();
		anotacoes.append("Um numero que começa com 0, o compilador assumira que você esta falando de um numero octal\n");
		anotacoes.append("Um numero que começa com 0x, o compilador assumira que você esta falando de um numero hexadecimal\n");
		anotacoes.append("Um numero nunca começara com letras\n");
		anotacoes.append("Um objeto pode voltar a ser acessivel atraves do metodo finalize mesmo dps de ser elegivel\n");
		anotacoes.append("Primitivos não recebem null\n");
	}
	
	public String toString() {
		return anotacoes.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Anotacoes());
		
		System.out.println("Precedencias");
		
		//comparações booleanas tem precedencia a atribuição
		boolean b1 = false;
		boolean b2 = false;
		//System.out.println(b2 != b1 = !b2); logo isso não compilará...
		//b2 != b1 tem precedencia a b1 = !b2.
		//logo false = !b2 não é permitido
		
		 System.out.println(5 + 6 +""); // isso retornará 11 pois quando a atribuição string está
		 								//a esquerda então a operação será realizada primeiro
		 								//ou seja avalia-se da esquerda para a direita
	}
}
