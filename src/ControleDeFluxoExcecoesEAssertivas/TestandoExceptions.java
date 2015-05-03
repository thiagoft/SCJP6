package ControleDeFluxoExcecoesEAssertivas;

import java.io.IOException;

class TesteException1 {
	void teste() throws RuntimeException {
		throw new RuntimeException();
	}
	
	void teste2() throws IOException {
		throw new IOException();
	}
	
	void teste3()  throws Error {
		throw new Error();
	}
	
	void teste4() throws AssertionError{
		throw new AssertionError();
	}
	
	void teste5() throws IOException{
		throw null;
	}
}

public class TestandoExceptions extends TesteException1 {
	//As Exce��es s�o divididas em verificadas e n�o verificadas, porem
	//todas implementam Throwable logo podem ser lan�adas
	
	//Verificadas:
	//-precisam ser declaradas ou tratadas
	
	//N�o Verificadas
	//-n�o precisam ser tratadas, mas podem ser
	
	//CURIOSIDADE IMPORTANTE
	void teste4() throws Error,RuntimeException {
		//permitido mesmo que Error seja mais abrangente que AssertionError
		//porque Error e RuntimeExceptions n�o s�o verificadas
		//Throwable no lugar de Error ou RuntimeException daria erro
	}
	
	public static void main(String[] args) {
		TesteException1 testeException = new TesteException1();
		
		//testeException.teste(); //n�o precisa ser tratada
		try { //porem pode-se tratala
			testeException.teste();
		} catch (RuntimeException e) {
			System.out.println("RuntimeException");
		}
		
		//testeException.teste3(); //n�o precisa ser tratada
		try { //porem pode-se tratala
			testeException.teste3();
		} catch (Error e) {
			System.out.println("Error");
		}
		
		//testeException.teste2(); n�o compila pois precisa ser tratada
		try {
			testeException.teste2();
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		try {
			testeException.teste2();
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			//finally sempre ser� chamado com exce��o das situa��es abaixo
			//POREM IMPORTANTE: System.exit() pode ser chamado antes mesmo de ser excecutado
			//ou se a JVM parar
			
			//Alem disso finally pode lan�ar uma exce��o ou chamar System.exit()
			//ou seja ele pode n ser concluido
		}
		
		
		try {
			testeException.teste5(); // declara um IOException porem lan�a null causando um NullPointerException
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Entrei");
		}
		
	}
}
