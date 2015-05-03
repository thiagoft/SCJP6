package StringsIOFormatAndParsing;

public class TesteFormatacao {
	public static void main(String[] args) {
		//print() e printf são exatamente iguais
		//sintaxe print("string para formatação", argumentos)
		//COMPOSIÇÃO DA STRING DE FORMATAÇÃO
		// % [arg_index$] [flags] [width] [.precision] char de conversão
		
		//[arg_index&] - indica a ordem do argumento seguido por um $
		
		//[flags] - são caracteres com funções especiais:
		//- "-" justifica o argumento
		//- "+" Inclui um sinal no argumento (+ou-)
		//- "0" preeche vazios deste argumento com zero
		//- "," Usa separadores específicos do locale (ouseja, a vírtgula em 123,456)
		//- "(" Coloca números negativos entre parênteres
		
		//[width] - quantidade de caracteres mínima de caracteres a serem exibidos
		
		//[precision] - qntidade de numeros fracionais
		
		//char de conversão - são chars ke determinar o tipo do argumento a ser formatado:
		//-b boolean
		//-c char
		//-d integer
		//-f pontos flutuantes
		//-s string
		
		//EXEMPLOS
		
		int i1 = -123;
		int i2 = 123456;
		
		System.out.printf("%1$(7d + %2$0+9d \n",i1,i2); //[9] irá imprimir +00123456 pois i2 = 123456 porem o numero minimo de decimais eh 9
														//[0] preenche com 0s
		System.out.printf("%0,7d \n",i2);
		System.out.printf("%+-7d \n",i2); //%[argumento 1 implicito] 
										  //[+] inclui sinal em i2 no caso 123456 fica +123456
										  //[-] justifica a esquerda
										  //[7] diz qntidade de caracteres
										  //[d] recebe um inteiro
		System.out.printf("%2$b + %1$5d \n",i1,false);
		
		//os unicos obrigatórios são "%char de conversão"
		
		System.out.printf("\"%-7.2f\"", 89.456);
		//justificado sempre à esquerda caso não haja numeros o suficiente para cumprir o tamanho do formato
		//justificativa somente funciona com width... e precision necessita de width 
	}
}
