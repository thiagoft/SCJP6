package Atribuicoes;

public class Arrays {
	//Quando um array � instanciado todos seus objetos ou primitivos ser�o setados com 
	//valor padr�o. Null para referencias a objetos e valor default para primitivos
	//IMPORTANTE: arrays possuem uma variavel length, Strings possuem metodo length()
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("args da declara�o de main quando n�o enviado comando algum possui lenght == 0");
		}
		String[] a = new String[50];
		String[] b = new String[10];
		
		b = a;
	}
}
