package ControleDeFluxoExcecoesEAssertivas;

public class TestandoAsserts {
	public static void main(String[] args) {
		int x = 1;
		boolean b = true;
		//Asserts Validas
		assert(x==1);	
		assert(b);
		assert(true);
		assert(x==1):x; //a segunda expressão DEVE retornar um valor
						//este valor será convertido em String
		
		//Asserts Inválidas
		//tudo que não resultar um valor booleano
		//assert(x==1):; sem retorno na segunda expressão
		//assert(x==1):Teste a;
		//assert(x==1):metodoSemRetorno();
		
		//IMPORTANTE
		//javac -source 1.6 TestandoAsserts.java //comando para referenciar o source desejado
		
		//abaixo da versão 1.4 a palavra chave "assert" pode ser usada como identificador
		//pois não é uma palavra chave...
		//da versão 1.4 para cima assert é palavra chave e não pode ser usada como identificador.
		
		//comandos de ativação de assertivas
		//java -ea ou -enableassertions(ativa assertivas em ambito geral, menos as do sistema JVM)
		//java -da ou -disableassertsions(desativa assertivas)
		//java -ea:com.foo... (Ativa assertivas no pacote com.foo e todos os subpacotes)
		//java -ea:com.foo.Bar (ativa assertivas na classe especificada)
		//java -ea -dsa (ativa assertivas em ambito geral e desativa as do sistema)
		//java -ea -da:com.foo.. (ativa em ambito geral e desativa as do pacote com.foo e seus subpacotes)
		
		
	} 
}
