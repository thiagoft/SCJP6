package DeclaracoesEControleDeAcesso;

public class VariaveisEMetodosStaticos {
	//m�todos staticos n�o podem usar this, pois n�o acessam membros non-static
	
	//n�o est�o ligados a qualquer instancia da classe;
	//N�o � preciso ter instancias da classe para serem usados
	//ex:
	
	public static int a;
	
	public int b;
	
	static void teste(){
		VariaveisEMetodosStaticos obj = new VariaveisEMetodosStaticos();
		obj = null;
		obj.teste2();
		obj.a = 2;
		VariaveisEMetodosStaticos.a = 1;
		
		//VariaveisEMetodosStaticos.b = 3; n�o � possivel acessar membros n�o static
		//o mesmo vale para metodos
	}
	
	static void teste2(){}
}
