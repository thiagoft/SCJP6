package ControleDeFluxoExcecoesEAssertivas;

public class Switch {
	//Switch somente pode avaliar byte,short,int e char
	
	enum Teste{PEQUENO,GRANDE,MEDIO}
	
	public static final int a = 3;
	
	public static void main(String[] args) {
		int b = 2;
		
		switch (b) {
			default:
				System.out.println("default");
				break; //mesmo o default, se não tiver break ele continua a executar os posteriores
			case 2: {
				System.out.println("Teste");
				break;
			}
			case 1: 
				System.out.println("Teste1");
				System.out.println("Teste1");
				break;
			
		}
		
		Teste n = Teste.PEQUENO;
		switch (n) {//quando usa-se enums em switch ele identifica que a variavel
					//de comparação tem um tipo enum logo a sintaxe abaixa é valida
			case PEQUENO :
			//case Teste.PEQUENO : não compila
				System.out.println("Pequeno");
			case MEDIO :
				System.out.println("Medio");
			case GRANDE :
				System.out.println("Grande");
		}
		
		switch(n) {
			//PERMITIDO
		}
		
		//switch(n); errode compilação
		
	}
}
