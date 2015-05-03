package OrientacaoAObjetos;

import java.io.IOException;

class Teste {
	
	//methodos de instancia s�o sobrescritos, variaveis de instancia, estatica e 
	//metodos staticos s�o sombreados isso significa que o metodo que sera invocado 
	//depende da classe do objeto, enquanto os demais s�o acessados dependendo da referencia
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
	
	//um metodo sobrescrito n�o pode lan�ar nenhuma nova exception checada, porem n�o ha problemas
	//em lan�ar n�o checadas
	public void teste5() {}
}

public class Sobrescrita extends Teste {
	public int a;
	
	public void teste3(IOException teste){
		System.out.println("teste1");
	}
	
	//Para sobrescrita os metodos podem ter retorno covariantes
	
	//private void teste() {}
	//modificadores de acesso mais restritivo n�o s�o permitidos
	
	//public void teste1() throws Exception {}
	//n�o podem lan�ar uma exce��o mais abrangente
	
	public void teste1() throws RuntimeException{
	}
	//podem lan�ar exce��es n�o verificadas ou menos abrangentes

	private void teste2() {// n�o esta sobrescrevendo o metodo de Teste, pois teste2 de Teste � privado e inalcansavel para Sobrescrita
		System.out.println("Teste1");
	}
	
	//o m�todo sobrescrito pode ser abstract, porem a classe precisara virar abstract tbm
	//public abstract void teste3();
	
	//Exemplo importante de sobrescrita -refTeste1
	public void teste4(){ System.out.println("2"); } //n�o � obrigado a declarar a exception
	void refTeste1() {
		Teste a = new Sobrescrita(); //porem nesse caso o tipo da referencia � a de Teste
		try {
			a.teste4(); //nesse caso mesmo que o metodo sobrescrito seja usado a exce��o deve ser tratada
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Sobrescrita b = new Sobrescrita(); //Logo quando declarado o tipo de variavel sem polimorfismo
		b.teste4();						   //n�o ser� necess�rio 
	}
	
	public static void main(String[] args) {
		Sobrescrita a = new Sobrescrita();
		a.refTeste1();
	}
	
	//public void teste5() throws Exception {} n�o pode lan�ar nenhuma nova exception checada
	public void teste5() throws RuntimeException {} //porem pode lan�ar n�o checadas
}

class Teste123 {
	void aaa() {
	}
}
