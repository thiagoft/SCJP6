package Atribuicoes;

public class PassandoVariaveisParaMetodos {
	//Quando um primitivo � passado como parametro � feito uma copia do mesmo desvincu
	//ladado original;
	//Quando um objeto � passado como parametro �feito uma copia da referencia ao objeto
	//logo se este objeto for modificado surtira efeito nas duas referencias
	//exemplos
	
	class TesteParametro {
		int tamanho;
	}
	
	void teste(TesteParametro a) {
		a.tamanho = 2;
	}
	
	public static void main(String[] args) {
		PassandoVariaveisParaMetodos outerClass = new PassandoVariaveisParaMetodos();
		TesteParametro obj = outerClass.new TesteParametro();
		obj.tamanho = 3;
		
		System.out.println(obj.tamanho); //3
		outerClass.teste(obj);
		System.out.println(obj.tamanho); //2	
		
	}
}
