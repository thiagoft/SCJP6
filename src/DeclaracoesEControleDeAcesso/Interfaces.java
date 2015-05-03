package DeclaracoesEControleDeAcesso;

public interface Interfaces {
	//s�o implicitamente public abstract
	//pode extender uma ou mais interfaces ex: extends Interface1,Interface2... mas n�o implementa.
	//interfaces somente utilizam a assinatura do metodo como declara��o;
	//ex: 
	void teste();
	//implicitamente o compilador adiciona "public abstract"
	void teste(int a);
	
	//METODOS:
	//-metodos de interfaces n�o podem ser static, final(pois devem ser sobrescritos),
	//strictfp ou native.
	
	//VARIAVEIS:
	//-todas as variaveis devem ser public static e final... ou seja, constantes.
	//ex:
	int TESTE = 42;
	//implicitamente "public static final"
	
	//uma classe abstrata pode implementar uma interface e n�o implementar seus metodos,
	//porem sua proxima classe concreta devera implementar todos.
	
	//int TESTE2;
	//static {TESTE2 = 32;} // interfaces n�o podem declarar blocos de inicializa��o
}

interface teste12 {
	void teste();
	int TESTE = 3;
}

class teste23 implements teste12,Interfaces  {
	public void teste(){};
	public void teste(int a){};
	
	void aa() {
		//System.out.println(TESTE); //n�o ha problemas com metodos ou fields ambiguos
									 //porem os fields se usados dar�o erro de Compila��o
		this.teste();
	}
}
