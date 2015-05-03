package Atribuicoes;

public class ExemplosDeAtribuicao {
	public static void main(String[] args) {
		// o valor padrao quando um numero decimal � digitado � sempre int
		// o valor padrao quando um numero de ponto flutuante � digitado � sempre double.
		// de int para valores maiores a convers�o � feita automaticamente.
		long a = 320;
		char c = 320;
		float f = 320; //logo float a = 320.0 precisaria de um (320.0f) para compilar 
		double d = 320;
		//byte b = 320; ilegal pois 320 n�o cabe em um byte, somente de de -128 a 127 
		
		//IMPORTANTE: Opera��es com numeros inteiros, sempre geram um int
		//e elas geram convers�o automatica, porem a soma de duas variaveis tamb�m geram um,
		//int logo precisam ser convertidas;
		//exemplos abaixo
		
		byte e = 2;
		byte g = 3;
		//byte g = e+f; mesmo que o resultado caiba em byte o resultado da opera��o � int
		//e int n cabe em byte sem cast.
		byte h = (byte) (e+g); //pode provocar perda de precis�o porem � valido
		//obs:os parenteses na  ope��o para o cast do resultado � necess�rio
		//pois se n�o ele entendera que no caso a variavel "e" somente esta sendo convertida.
		
		byte i = 3+2; //opera��es com n�meros literais geram um byte literal que pode ser convertido
					  //implicitamente caso o valor caiba, nesse caso 5 cabe em um byte, logo valido
		byte j = (byte) (3+g); //opera��o entre literal e variaveis geral um int, logo convers�o � 
							   //� necess�ria
		
		//IMPORTANTE:Opera��es que usem os operadores +=,-=,*=,/= tem convers�o explicita;
		//exemplos abaixo
		
		byte l = 3;
		l += 4; //resultado 7 int que foi convertido para byte 
		//seria o mesmo que l = (byte) (l+4);
		
		
		//Diminuir um numero primitivo causa perda de precis�o
		
		int k = 07; //octal
		int n = 0x123ab; //hexadecimal
	}
}
