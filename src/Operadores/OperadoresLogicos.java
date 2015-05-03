package Operadores;

public class OperadoresLogicos {
	
	boolean teste1() {
		System.out.println("True");
		return true;
	}
	
	boolean teste2() {
		System.out.println("False");
		return false;
	}
	
	public static void main(String[] args) {
		OperadoresLogicos a = new OperadoresLogicos();
		//o operador "||" (OU) Short-Circuit avalia se uma das expressões é verdadeira
		//porem se a primeira for verdadeira ele não precisará olhar a segunda
		if (a.teste1() || a.teste2()) {
			System.out.println("Afirmação1 verdadeira");
		}
		if (a.teste2() || a.teste1()) {
			System.out.println("Afirmação2 verdadeira");
		}
		
		//o operador "&&" (AND) Short-Circuit avalia se as duas expressões são verdadeiras
		//porem se a primeira for false ele não precisará olhar a segunda
		if (a.teste1() && a.teste2()) {
			System.out.println("Afirmação3 verdadeira");
		} else {
			System.out.println("Afirmação3 falsa");
		}
		if (a.teste1() && a.teste1()) {
			System.out.println("Afirmação4 verdadeira");
		}
		
		//o operador "|" (OU) avalia se uma das expressões é verdadeira
		//este operador ao contrario do anterior verifica SEMPRE todas afirmações
		if (a.teste1() | a.teste2()) {
			System.out.println("Afirmação5 verdadeira");
		}
		if (a.teste2() | a.teste1()) {
			System.out.println("Afirmação6 verdadeira");
		}
		
		//o operador "&" (AND) avalia se as duas expressões são verdadeiras
		//este operador ao contrario do anterior verifica SEMPRE todas afirmações
		if (a.teste1() & a.teste2()) {
			System.out.println("Afirmação7 verdadeira");
		} else {
			System.out.println("Afirmação7 falsa");
		}
		if (a.teste1() & a.teste1()) {
			System.out.println("Afirmação8 verdadeira");
		}
		
		//OPERADOR "^" (XOR) retorna true se somente uma afirmação for verdadeira
		if (a.teste1() ^ a.teste2()) {
			System.out.println("Afirmação9 verdadeira");
		}
		if (a.teste1() ^ a.teste1()) {
			System.out.println("Afirmação10 verdadeira");
		}
		if (a.teste2() ^ a.teste2()) {
			System.out.println("Afirmação11 verdadeira");
		}
	}
}
