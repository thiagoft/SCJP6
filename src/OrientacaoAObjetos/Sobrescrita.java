package OrientacaoAObjetos;

import java.io.IOException;

class Teste {
	
	//methodos de instancia são sobrescritos, variaveis de instancia, estatica e 
	//metodos staticos são sombreados isso significa que o metodo que sera invocado 
	//depende da classe do objeto, enquanto os demais são acessados dependendo da referencia
	private void teste2() {
		System.out.println("Teste");
	}
	
	private static final transient int x = 0;
	
	public int a;
	
	public void teste() {System.out.println(x);}
	
	public void teste1() throws IllegalArgumentException {}
	
	public void teste3(Exception teste) {
		System.out.println("teste");
	}
	
	//-refTeste1
	public void teste4() throws Exception { System.out.println("1"); }
	
	//um metodo sobrescrito não pode lançar nenhuma nova exception checada, porem não ha problemas
	//em lançar não checadas
	public void teste5() {}
}

public class Sobrescrita extends Teste {
	public int a;
	
	public void teste3(IOException teste){
		System.out.println("teste1");
	}
	
	//Para sobrescrita os metodos podem ter retorno covariantes
	
	//private void teste() {}
	//modificadores de acesso mais restritivo não são permitidos
	
	//public void teste1() throws Exception {}
	//não podem lançar uma exceção mais abrangente
	
	public void teste1() throws RuntimeException{
	}
	//podem lançar exceções não verificadas ou menos abrangentes

	private void teste2() {// não esta sobrescrevendo o metodo de Teste, pois teste2 de Teste é privado e inalcansavel para Sobrescrita
		System.out.println("Teste1");
	}
	
	//o método sobrescrito pode ser abstract, porem a classe precisara virar abstract tbm
	//public abstract void teste3();
	
	//Exemplo importante de sobrescrita -refTeste1
	public void teste4(){ System.out.println("2"); } //não é obrigado a declarar a exception
	void refTeste1() {
		Teste a = new Sobrescrita(); //porem nesse caso o tipo da referencia é a de Teste
		try {
			a.teste4(); //nesse caso mesmo que o metodo sobrescrito seja usado a exceção deve ser tratada
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Sobrescrita b = new Sobrescrita(); //Logo quando declarado o tipo de variavel sem polimorfismo
		b.teste4();						   //não será necessário 
	}
	
	public static void main(String[] args) {
		Sobrescrita a = new Sobrescrita();
		a.refTeste1();
	}
	
	//public void teste5() throws Exception {} não pode lançar nenhuma nova exception checada
	public void teste5() throws RuntimeException {} //porem pode lançar não checadas
}

class Teste123 {
	void aaa() {
	}
}
