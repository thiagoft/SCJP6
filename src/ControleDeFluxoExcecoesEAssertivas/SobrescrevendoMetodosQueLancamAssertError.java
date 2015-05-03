package ControleDeFluxoExcecoesEAssertivas;

public class SobrescrevendoMetodosQueLancamAssertError {
	public void robustMethod(int[] intArray) throws AssertionError {
		int[] newIA = null;
		assert newIA != intArray;
	}
}

class TestandoSobrescrita extends SobrescrevendoMetodosQueLancamAssertError {
	/*public void robustMethod(int[] intArray) {
		//válido
	}*/
	
	/*public void robustMethod(int[] intArray) throws Exception {
		//inválido pois AssertError extends Error que esta fora da arvore de Exception
	}*/
	
	/*public void robustMethod(int[] intArray) throws Throwable {
		//inválido pois AssertError extends Error que extends throwable, porem Throwable é mais abrangente ke AssertError
	}*/
	
	/*public void robustMethod(int[] intArray) throws Error {
		//válido pois Error é uma Exceção não checada
	}*/
	
	/*public void robustMethod(int[] intArray) throws RuntimeException {
		válido pois RuntimeException é uma Exceção não checada
	}*/	
}
