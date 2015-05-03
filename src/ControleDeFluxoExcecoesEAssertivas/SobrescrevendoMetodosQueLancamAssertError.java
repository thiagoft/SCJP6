package ControleDeFluxoExcecoesEAssertivas;

public class SobrescrevendoMetodosQueLancamAssertError {
	public void robustMethod(int[] intArray) throws AssertionError {
		int[] newIA = null;
		assert newIA != intArray;
	}
}

class TestandoSobrescrita extends SobrescrevendoMetodosQueLancamAssertError {
	/*public void robustMethod(int[] intArray) {
		//v�lido
	}*/
	
	/*public void robustMethod(int[] intArray) throws Exception {
		//inv�lido pois AssertError extends Error que esta fora da arvore de Exception
	}*/
	
	/*public void robustMethod(int[] intArray) throws Throwable {
		//inv�lido pois AssertError extends Error que extends throwable, porem Throwable � mais abrangente ke AssertError
	}*/
	
	/*public void robustMethod(int[] intArray) throws Error {
		//v�lido pois Error � uma Exce��o n�o checada
	}*/
	
	/*public void robustMethod(int[] intArray) throws RuntimeException {
		v�lido pois RuntimeException � uma Exce��o n�o checada
	}*/	
}
