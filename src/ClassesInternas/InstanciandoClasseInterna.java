package ClassesInternas;

public class InstanciandoClasseInterna {
	//muitas instancias de uma classe interna podem existir pra uma classe externa
	//uma classe interna statica n�o pode extender outraclasse interna statica dentro de uma mesma classe
	private String outerString;
	
	public void myOuterMethod() {
		TesteInner2 testeInner2 = new TesteInner2(); //forma de instancias TesteInner2 de dentro da classe externa
		testeInner2.innerString = "Thiago";
		//as classes externas tem acesso total �s internas
		//Atrav�s da instancia da clase interna
	}
	
	public class TestInner {
		static final int a = 0; //variaveis de instancia static somente podem ser declaradas dentro de uma Inner class
								//caso a variavel seja static e final
		//metodos staticos n�o podem ser declarados em classes internas n�o staticas
		//static void teste53() {}
	}
	
	public class TesteInnerHerdando extends InstanciandoClasseInterna {
		//classes internas podem herdar sua classe externa
	}
	
	//as classes internas podem ser public, private, protected e default... fora final ou abstract
	private class TesteInner2{
		private String innerString;
		
		void testeAcessoPrivado() {
			InstanciandoClasseInterna.this.outerString = "Teste";
			//as classes internas tem acesso total �s externas
			//atraves de <nome da classe externa>.this
		}
	}
	
	//CLASSE INTERNA LOCAL DE M�TODO
	public void TesteClasseLocalDeMetodo() {
		//classes local de M�todo somente podem acessar variaveis locais do m�todo
		//se estes forem final(que n�o se alteram), inclusive parametros
		//Uma classe interna local de metodo n�o pode ser static
		class InnerLocalClass {
			public String innerLocalVariable;
		}
		//devem ser instanciadas para serem usadas
		//podem ser abstract ou final
		InnerLocalClass innerLocalClass = new InnerLocalClass();
		innerLocalClass.innerLocalVariable = "Thiago";
	}
	
	public static void main(String[] args) {
		//Formas de instanciar classes internas fora de uma instancia
		InstanciandoClasseInterna to = new InstanciandoClasseInterna();
		InstanciandoClasseInterna.TestInner testeInner = to.new TestInner();
		
		InstanciandoClasseInterna.TesteInner2 testeInner2 = new InstanciandoClasseInterna().new TesteInner2();
		testeInner2.innerString = "Thiago";
		
		System.out.println("CLASSE ANINHADA EST�TICA");
		//as classes est�ticas internas, tem o mesmo comportamente de um membro
		//static, e portanto n�o compartilha nenhum membro da instancia da classe externa
		StaticInnerClass.teste2(); // de dentro da class externa
		//pode ser estanciada
		StaticInnerClass staticInnerClass = new StaticInnerClass(); // de dentro da class externa
		staticInnerClass.teste();
		//ver OutraClasseQualquer.testeAcessoDasStaticInnerClasses()
		//para os testes de fora da classe externa
		
		to.new TesteClasseAnonima().teste();
		
	}
	
	//TESTE CLASSE ANONIMA
	//o principal intuito de uma classe anonima � sobrescrever m�todos de uma superclasse 
	//ou implementar metodos de uma interface 
	//logo essa � a unica maneira de utilizar um new Interface
	//Importante uma classe anonima n�o pode ser statica
	//classes staticas podem ter par�metro de inicializa��o
	class TesteClasseAnonima {
		//Uma classe interna anonima tem o Tipo de Referencia da superclasse, logo somente
		//membros comuns ser�o visiveis, ou seja... somente membros sobrescritos na classe
		//anonima, ou membros da superclasse
		ClasseParaTesteAnonimo classeAnonima = new ClasseParaTesteAnonimo(0) { //classes staticas podem ter par�metro de inicializa��o
																			   // caso a classe possua construtores sobrecarregados
			//sobrescrevendo o metodo metodoDoTeste() da classe ClasseParaTesteAnonimo
			public void metodoDoTeste() {
				System.out.println("Eu Sou um Teste Anonimo");
			}
		}; //deve fechar a instru��o da classe anonima com ";" n�o esque�a
		//O importante a se lembrar� que a classe anonima acima � na verdade
		//uma subclasse de ClasseParaTesteAnonimo... e n�o uma instancia dela...
		
		//implementando a interface TesteInterfaceAnonima
		TesteInterfaceAnonima interfaceAnonima = new TesteInterfaceAnonima() {
			public void testeInterfaceAninoma() {
				System.out.println("Sou uma classe que implementa a interface TesteInterfaceAnonima");
			}
		};
		
		void teste() {
			this.classeAnonima.metodoDoTeste();
			this.interfaceAnonima.testeInterfaceAninoma();
		}
	}
	
	//CLASSE ANINHADA EST�TICA
	static class StaticInnerClass {
		public void teste() {
			System.out.println("Funciona");
		}
		
		public static void teste2() {
			testeExterna(); //acessa os membro staticosda externa normalmente 
		}
	}
	
	public static void testeExterna() {}
}

class OutraClasseQualquerAuxiliar {
	void testeAcesso() {
		/*InstanciandoClasseInterna.TesteInner2 a = new InstanciandoClasseInterna().new TesteInner2();
		a.a = "Thiago";*/ //erro de compila��o pois TestInner2 � private
		//as regras de Modificadores referentes a acesso s�o validas somente para classes internas,
		//ja que classes normais podem ter modificadores referentes a acesso somente public/default
	}
	
	void testeAcessoDasStaticInnerClasses() {
		//para acesso a membros estaticos
		InstanciandoClasseInterna.StaticInnerClass.teste2(); 
		
		//Deve referenciar a class Externa para instancia-la, porem n�o tem necessidade de instanciar a classe externa
		InstanciandoClasseInterna.StaticInnerClass staticInnerClass = new InstanciandoClasseInterna.StaticInnerClass();
		staticInnerClass.teste();
	}
}

class ClasseParaTesteAnonimo {
	ClasseParaTesteAnonimo(int a) {
		
	}
	String teste;
	public void metodoDoTeste() {
		System.out.println("Eu Sou um Teste");
	}
}

interface TesteInterfaceAnonima {
	void testeInterfaceAninoma();
}
