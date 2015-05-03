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
		//o operador "||" (OU) Short-Circuit avalia se uma das express�es � verdadeira
		//porem se a primeira for verdadeira ele n�o precisar� olhar a segunda
		if (a.teste1() || a.teste2()) {
			System.out.println("Afirma��o1 verdadeira");
		}
		if (a.teste2() || a.teste1()) {
			System.out.println("Afirma��o2 verdadeira");
		}
		
		//o operador "&&" (AND) Short-Circuit avalia se as duas express�es s�o verdadeiras
		//porem se a primeira for false ele n�o precisar� olhar a segunda
		if (a.teste1() && a.teste2()) {
			System.out.println("Afirma��o3 verdadeira");
		} else {
			System.out.println("Afirma��o3 falsa");
		}
		if (a.teste1() && a.teste1()) {
			System.out.println("Afirma��o4 verdadeira");
		}
		
		//o operador "|" (OU) avalia se uma das express�es � verdadeira
		//este operador ao contrario do anterior verifica SEMPRE todas afirma��es
		if (a.teste1() | a.teste2()) {
			System.out.println("Afirma��o5 verdadeira");
		}
		if (a.teste2() | a.teste1()) {
			System.out.println("Afirma��o6 verdadeira");
		}
		
		//o operador "&" (AND) avalia se as duas express�es s�o verdadeiras
		//este operador ao contrario do anterior verifica SEMPRE todas afirma��es
		if (a.teste1() & a.teste2()) {
			System.out.println("Afirma��o7 verdadeira");
		} else {
			System.out.println("Afirma��o7 falsa");
		}
		if (a.teste1() & a.teste1()) {
			System.out.println("Afirma��o8 verdadeira");
		}
		
		//OPERADOR "^" (XOR) retorna true se somente uma afirma��o for verdadeira
		if (a.teste1() ^ a.teste2()) {
			System.out.println("Afirma��o9 verdadeira");
		}
		if (a.teste1() ^ a.teste1()) {
			System.out.println("Afirma��o10 verdadeira");
		}
		if (a.teste2() ^ a.teste2()) {
			System.out.println("Afirma��o11 verdadeira");
		}
	}
}
