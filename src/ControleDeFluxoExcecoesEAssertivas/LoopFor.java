package ControleDeFluxoExcecoesEAssertivas;

class Car {
	
}

class Ferrari extends Car {
	
}

public class LoopFor {
	public static void main(String[] args) {
		int size = 10;
		int[] arr = new int[size];
		
		for (int i = 0/*1*/; i<size /*2*/; ++i/*3*/) {
			System.out.println(arr[i]); //4
		}
		
		/*
		 Fluxo do Loop for nº1 sera executado antes de tudo,
		 logo apos 1... 2 é executado... se a expressao boleana for atendida
		 então 4 é executado e logo apos 3 é executado, então o fluxo recomeça.
		 */
		
		Ferrari[] ferraris = new Ferrari[] {new Ferrari(),new Ferrari()};
		for (Car car : ferraris) { //Polimorfismo aceito aqui
			System.out.println("Ferrari");
		}
		
		Car carDefinidoAntes = null;
		//for (carDefinidoAntes : ferraris) { erro de compilação, não é permitido usar uma variavel predefinida
		//	System.out.println("Ferrari");
		//}
		
		for (;;) { // permitido e entra em loop infinito
			System.out.println("tete");
			break;
		}
		TESTE2: {
			int mn = 0;
			JACK: while (mn < 8)
			{
				TESTE: // dentro de um loop ou em qualquer bloco pode-se utilizar labels que não foram declaradas
					   // porem elas não terão nenhum significado
				JILL: System.out.println(mn);
				if (mn > 3) break JACK; else mn++;
			}
		}
		
		TESTE3:{
			int allala=0;
		}
		//TESTE3:
			//int allala=0; //invalido por causa da label não envolver um loop ou um bloco
		
		System.out.println("Entrou");
		TESTE4: {
			if (1>0){ break TESTE4;} //break pode ser usado aqui, continue comente em loop
			System.out.println("TESTE"); //não imprimira teste
		}
		System.out.println("Saiu");
		
		for (;;); //valido e entra em loop infinito

		
		
	}
}


