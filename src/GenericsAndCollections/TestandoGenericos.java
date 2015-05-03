package GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;

public class TestandoGenericos {
	//os genericos forçam o type-safe
	//IMPORTANTE: Coleções não tipadas compilam com warning.
	//a informação de tipos genericos funciona somente em tempo de compilação
	//em tempo de execução as coleções não são tipadas, por isso misturar coleções
	//genéricas com coleçoes não genéricas, é potencialmente perigoso
	public static void main(String[] args) {
		List<String> listaTipada = new ArrayList<String>();
		listaTipada.add("Thiago");
		listaTipada.add("Thaisa");
		String s = listaTipada.get(0); //pela lista ser tipada não há necessidade de cast
		//lista.add(new Integer(2)); erro de compilação pois é tipada e não permite Integer		
		for (String obj : listaTipada) {
			System.out.println(obj);
		}
		List listaNaoTipada = new ArrayList<String>();
		listaNaoTipada.add("Thiago");
		listaNaoTipada.add("Thaisa");
		listaNaoTipada.add(new Integer(3)); // não tipada portanto permite Integers
		s = (String) listaNaoTipada.get(0); //como a lista não é tipada há a necessidade de cast
		/*for (String obj : listaNaoTipada) { // erro de compilação pois a List não é tipada
			System.out.println(obj);		  // portanto não é uma String
		}*/ 
		List listaNaoTipada2 = new ArrayList();
		listaNaoTipada2.add("Thiago");
		listaNaoTipada2.add("Thaisa");
		listaNaoTipada2.add(new Integer(3)); // não tipada portanto permite Integers
		s = (String) listaNaoTipada2.get(0); //como a lista não é tipada há a necessidade de cast
		/*for (String obj : listaNaoTipada2) { // erro de compilação pois a List não é tipada
			System.out.println(obj);		 // portanto não é uma String
		}*/
		List<String> lista = new ArrayList();
		lista.add("Thiago");
		lista.add("Thaisa");
		//lista.add(new Integer(2)); erro de compilação pois é tipada e não permite Integer
		s = lista.get(0); //pela lista ser tipada não há necessidade de cast
		for (String obj : lista) {
			System.out.println(obj);
		}
		
		//Uma coleção é covariante em relação aos elementos da lista, porem não em relação
		//ao tipo base generico
		//ex:
		List<Animal> animalList = new ArrayList<Animal>();
		animalList.add(new Dog());
		animalList.add(new Cat());
		
		//List<Animal> dogList = new ArrayList<Dog>(); erro de compilação, os genericos
		//precisam que o tipo seja exatamente o mesmo
		//o mesmo vale para métodos, o argumento generico de um método não pode receber
		//um generico covariante, e o mesmo vale para o tipo de retorno
		
		TestandoGenericos testandoGenericos = new TestandoGenericos();
		testandoGenericos.metodoNaoTipado(listaTipada); //perigoso
		
		System.out.println("Genericos coringa");
		//ver classes Animal, Dog e Cat
		//IMPORTANTE o coringa ? não é valido para classes
		
		List<?> listaCoring = new ArrayList<Dog>();
		//com ? qualquer lista é aceita
		//lista.add(new Dog()); erro de compilação, pois não permite alteração na lista
		//listaCoring.get(0); porem aceita acesso
		
		//IMPORTANTE ao tratar Object deve-se notar a diferença entre os tipos
		List<Object> listaObject = new ArrayList<Object>(); // aceita somente listas
		//do tipo object, porem permite manipulação completa
		
		List<? extends Object> listaObject1 = new ArrayList<Dog>();
		//aceitaqualquer lista generica, porem não permite manipulação alem de acesso
		
		System.out.println("Testando tipos e elementos coringas");
		//verificar a classe Teste Abaixo
		Teste<Dog,Cat> objetos = new Teste<Dog,Cat>(new Dog(), new Cat());
		objetos.testeOne(new Dog());
		objetos.testeTwo(new Cat());
		
		System.out.println("Testando Métodos genéricos");
		Cat objCat = new Cat();
		objCat.TesteMetodoGenerico(new Cat());
		objCat.TesteMetodoGenerico(new Dog());
		
	}
	
	public void metodoNaoTipado(List qualquerCoisa) { //compila com warning pois n é tipada
		try {
			//aqui pode haver qualquer tratamento para um tipo específico o que o torna
			//um método perigoso pois não se sabe o que vira na lista de argumentos
			for (Object obj : qualquerCoisa) {
				((Integer) obj).intValue(); //espera um Integer porem vieram Strings na lista
			}
			qualquerCoisa.add(new Integer(4)); //compila com warning pois em tempo de
			//execução mesmo as listas genericas não são tipadas logo é aceito um integer
			//em uma lista de Strings no caso de uma coleção não tipada
			//porem quando tal lista for usada podera ter problemas
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Animal {
	//void addA(List<Animal> listAnimal) {} 
	void addA(List<? extends Animal> listAnimal) {
		//ao utilizar este recurso a lista passada por argumento não pode ser modificada
		//por exemplo utilizar o método add.
		//listAnimal.add(new Dog()); não compila 
		listAnimal.get(0); // porem pode ser acessado
	} //extends vale tanto para herança qndo para interfaces
	//os 2 metodos acima não sobrecarregam pelo fato do primeiro aceitar uma list de animal
	//e o segundo aceitar uma lista de animal ou qualquer coisa ke extenda animal
	//logo uma lista de dog ou de cat pode ser passado para o segundo método,
	//ja o primeiro não
	
	/*void addA List<? super Animal> listAnimal) {
		//tem os mesmo comportamentos dos métodos acima, porem aceita Animal ou 
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
		//um método genérico deve ter o <T> antes da declaração do tipo de retorno
		//T assumirá o valor do argumento T , se for um Dog, T será um Dog.
		//caso contrário assumira o Tipo da instancia... nesse caso Cat.
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

class Teste2<T extends Animal, X extends Animal> { // isto também é possivel
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