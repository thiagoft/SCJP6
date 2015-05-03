package DeclaracoesEControleDeAcesso;

public class VariaveisEMetodosStaticos {
	//métodos staticos não podem usar this, pois não acessam membros non-static
	
	//não estão ligados a qualquer instancia da classe;
	//Não é preciso ter instancias da classe para serem usados
	//ex:
	
	public static int a;
	
	public int b;
	
	static void teste(){
		VariaveisEMetodosStaticos obj = new VariaveisEMetodosStaticos();
		obj = null;
		obj.teste2();
		obj.a = 2;
		VariaveisEMetodosStaticos.a = 1;
		
		//VariaveisEMetodosStaticos.b = 3; não é possivel acessar membros não static
		//o mesmo vale para metodos
	}
	
	static void teste2(){}
}
