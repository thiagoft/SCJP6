package GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class TestandoGenericos {
	//os genericos for�am o type-safe
	//IMPORTANTE: Cole��es n�o tipadas compilam com warning.
	//a informa��o de tipos genericos funciona somente em tempo de compila��o
	//em tempo de execu��o as cole��es n�o s�o tipadas, por isso misturar cole��es
	//gen�ricas com cole�oes n�o gen�ricas, � potencialmente perigoso
	public static void main(String[] args) {
		List<String> listaTipada = new ArrayList<String>();
		listaTipada.add("Thiago");
		listaTipada.add("Thaisa");
		String s = listaTipada.get(0); //pela lista ser tipada n�o h� necessidade de cast
		//lista.add(new Integer(2)); erro de compila��o pois � tipada e n�o permite Integer		
		for (String obj : listaTipada) {
			System.out.println(obj);
		}
		List listaNaoTipada = new ArrayList<String>();
		listaNaoTipada.add("Thiago");
		listaNaoTipada.add("Thaisa");
		listaNaoTipada.add(new Integer(3)); // n�o tipada portanto permite Integers
		s = (String) listaNaoTipada.get(0); //como a lista n�o � tipada h� a necessidade de cast
		/*for (String obj : listaNaoTipada) { // erro de compila��o pois a List n�o � tipada
			System.out.println(obj);		  // portanto n�o � uma String
		}*/ 
		List listaNaoTipada2 = new ArrayList();
		listaNaoTipada2.add("Thiago");
		listaNaoTipada2.add("Thaisa");
		listaNaoTipada2.add(new Integer(3)); // n�o tipada portanto permite Integers
		s = (String) listaNaoTipada2.get(0); //como a lista n�o � tipada h� a necessidade de cast
		/*for (String obj : listaNaoTipada2) { // erro de compila��o pois a List n�o � tipada
			System.out.println(obj);		 // portanto n�o � uma String
		}*/
		List<String> lista = new ArrayList();
		lista.add("Thiago");
		lista.add("Thaisa");
		//lista.add(new Integer(2)); erro de compila��o pois � tipada e n�o permite Integer
		s = lista.get(0); //pela lista ser tipada n�o h� necessidade de cast
		for (String obj : lista) {
			System.out.println(obj);
		}
		
		//Uma cole��o � covariante em rela��o aos elementos da lista, porem n�o em rela��o
		//ao tipo base generico
		//ex:
		List<Animal> animalList = new ArrayList<Animal>();
		animalList.add(new Dog());
		animalList.add(new Cat());
		
		//List<Animal> dogList = new ArrayList<Dog>(); erro de compila��o, os genericos
		//precisam que o tipo seja exatamente o mesmo
		//o mesmo vale para m�todos, o argumento generico de um m�todo n�o pode receber
		//um generico covariante, e o mesmo vale para o tipo de retorno
		
		TestandoGenericos testandoGenericos = new TestandoGenericos();
		testandoGenericos.metodoNaoTipado(listaTipada); //perigoso
		
		System.out.println("Genericos coringa");
		//ver classes Animal, Dog e Cat
		//IMPORTANTE o coringa ? n�o � valido para classes
		
		List<?> listaCoring = new ArrayList<Dog>();
		//com ? qualquer lista � aceita
		//lista.add(new Dog()); erro de compila��o, pois n�o permite altera��o na lista
		//listaCoring.get(0); porem aceita acesso
		
		//IMPORTANTE ao tratar Object deve-se notar a diferen�a entre os tipos
		List<Object> listaObject = new ArrayList<Object>(); // aceita somente listas
		//do tipo object, porem permite manipula��o completa
		
		List<? extends Object> listaObject1 = new ArrayList<Dog>();
		//aceitaqualquer lista generica, porem n�o permite manipula��o alem de acesso
		
		System.out.println("Testando tipos e elementos coringas");
		//verificar a classe Teste Abaixo
		Teste<Dog,Cat> objetos = new Teste<Dog,Cat>(new Dog(), new Cat());
		objetos.testeOne(new Dog());
		objetos.testeTwo(new Cat());
		
		System.out.println("Testando M�todos gen�ricos");
		Cat objCat = new Cat();
		objCat.TesteMetodoGenerico(new Cat());
		objCat.TesteMetodoGenerico(new Dog());
		
	}
	
	public void metodoNaoTipado(List qualquerCoisa) { //compila com warning pois n � tipada
		try {
			//aqui pode haver qualquer tratamento para um tipo espec�fico o que o torna
			//um m�todo perigoso pois n�o se sabe o que vira na lista de argumentos
			for (Object obj : qualquerCoisa) {
				((Integer) obj).intValue(); //espera um Integer porem vieram Strings na lista
			}
			qualquerCoisa.add(new Integer(4)); //compila com warning pois em tempo de
			//execu��o mesmo as listas genericas n�o s�o tipadas logo � aceito um integer
			//em uma lista de Strings no caso de uma cole��o n�o tipada
			//porem quando tal lista for usada podera ter problemas
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Animal {
	//void addA(List<Animal> listAnimal) {} 
	void addA(List<? extends Animal> listAnimal) {
		//ao utilizar este recurso a lista passada por argumento n�o pode ser modificada
		//por exemplo utilizar o m�todo add.
		//listAnimal.add(new Dog()); n�o compila 
		listAnimal.get(0); // porem pode ser acessado
	} //extends vale tanto para heran�a qndo para interfaces
	//os 2 metodos acima n�o sobrecarregam pelo fato do primeiro aceitar uma list de animal
	//e o segundo aceitar uma lista de animal ou qualquer coisa ke extenda animal
	//logo uma lista de dog ou de cat pode ser passado para o segundo m�todo,
	//ja o primeiro n�o
	
	/*void addA List<? super Animal> listAnimal) {
		//tem os mesmo comportamentos dos m�todos acima, porem aceita Animal ou 
		//superclasses de Animal
	}*/
}

class Dog extends Animal {
	void addD(List<Dog> listDog) {}
	
	public String toString() {
		return "Dog";
	}
}

class Cat extends Animal {
	void addC(List<Cat> listCat) {}
	
	public String toString() {
		return "Cat";
	}
	
	public <T> void TesteMetodoGenerico(T t) { 
		//um m�todo gen�rico deve ter o <T> antes da declara��o do tipo de retorno
		//T assumir� o valor do argumento T , se for um Dog, T ser� um Dog.
		//caso contr�rio assumira o Tipo da instancia... nesse caso Cat.
		List<T> a = new ArrayList<T>();
		a.add(t);
		System.out.println(a.get(0));
	}
}

class Teste<T,X> {
	T one;
	X two;
	public Teste(T one, X two) {
		this.one = one;
		this.two = two;
		
	}
	
	public void testeOne(T one) {
		System.out.println(one);
	}
	
	public void testeTwo(X two) {
		System.out.println(two);
	}
}

class Teste2<T extends Animal, X extends Animal> { // isto tamb�m � possivel
	T one;
	X two;
	public Teste2(T one, X two) {
		this.one = one;
		this.two = two;
		
	}
	
	public void testeOne(T one) {
		System.out.println(one);
	}
	
	public void testeTwo(X two) {
		System.out.println(two);
	}
}