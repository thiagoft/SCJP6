package StringsIOFormatAndParsing;

public class TesteFormatacao {
	public static void main(String[] args) {
		//print() e printf s�o exatamente iguais
		//sintaxe print("string para formata��o", argumentos)
		//COMPOSI��O DA STRING DE FORMATA��O
		// % [arg_index$] [flags] [width] [.precision] char de convers�o
		
		//[arg_index&] - indica a ordem do argumento seguido por um $
		
		//[flags] - s�o caracteres com fun��es especiais:
		//- "-" justifica o argumento
		//- "+" Inclui um sinal no argumento (+ou-)
		//- "0" preeche vazios deste argumento com zero
		//- "," Usa separadores espec�ficos do locale (ouseja, a v�rtgula em 123,456)
		//- "(" Coloca n�meros negativos entre par�nteres
		
		//[width] - quantidade de caracteres m�nima de caracteres a serem exibidos
		
		//[precision] - qntidade de numeros fracionais
		
		//char de convers�o - s�o chars ke determinar o tipo do argumento a ser formatado:
		//-b boolean
		//-c char
		//-d integer
		//-f pontos flutuantes
		//-s string
		
		//EXEMPLOS
		
		int i1 = -123;
		int i2 = 123456;
		
		System.out.printf("%1$(7d + %2$0+9d \n",i1,i2); //[9] ir� imprimir +00123456 pois i2 = 123456 porem o numero minimo de decimais eh 9
														//[0] preenche com 0s
		System.out.printf("%0,7d \n",i2);
		System.out.printf("%+-7d \n",i2); //%[argumento 1 implicito] 
										  //[+] inclui sinal em i2 no caso 123456 fica +123456
										  //[-] justifica a esquerda
										  //[7] diz qntidade de caracteres
										  //[d] recebe um inteiro
		System.out.printf("%2$b + %1$5d \n",i1,false);
		
		//os unicos obrigat�rios s�o "%char de convers�o"
		
		System.out.printf("\"%-7.2f\"", 89.456);
		//justificado sempre � esquerda caso n�o haja numeros o suficiente para cumprir o tamanho do formato
		//justificativa somente funciona com width... e precision necessita de width 
	}
}
