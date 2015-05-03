package Atribuicoes;

public class Arrays {
	//Quando um array é instanciado todos seus objetos ou primitivos serão setados com 
	//valor padrão. Null para referencias a objetos e valor default para primitivos
	//IMPORTANTE: arrays possuem uma variavel length, Strings possuem metodo length()
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("args da declaraão de main quando não enviado comando algum possui lenght == 0");
		}
		String[] a = new String[50];
		String[] b = new String[10];
		
		b = a;
	}
}
