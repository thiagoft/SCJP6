package GenericsAndCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class ColecoesEClassificacao {
	//Collection é a interface mãe das collections Set, List e Queue
	//Collections é a classe com metodos utilitários para auxiliar a manipulação
	//das Collections
	
	//Lembrando que Map é uma coleção mas n extende Collection
	
	//List: são Ordenadas por índice e permitem repetição
	//Set: Podem ou não ser ordenados e /ou classificados e não permitem repetição
	//Map: chave/valor podem ou não ser ordenados e/ou classificados e a repetição de chaves não
	//é permitida. (OBS: não confundir chave... com container hash)
	//Queue: ordenados por FIFO ou por prioridade
	
	//ORDENAÇÃO E CLASSIFICAÇÃO
	
	//Ordenado: obedecer a uma ordem específica não aleatória, vc pode iterar sobre
	//ela em uma ordem específica não aleatória
	//-Pode ser ordem de inserção, por indice, ou ordem natural
	//Classificado: obedecer a uma orderm classificada estabelecida
	//-Pode ser alfabética, numérica ou definida pelo programador que não seja
	//por inserção acesso ou indice
	
	public static void main(String[] args) {
		System.out.println("Lists-----------------");
		System.out.println("Testando ArrayList");
		//ArrayList ordenada por indice e não classificadas, possui iteração rapida porem menos eficiente
		//que LinkedList para mtas inserções/remoções
		List arrayList = new ArrayList();
		int a = 1;
		arrayList.add("Thiago");
		arrayList.add(a); //IMPORTANTE COLEÇÕES SOMENTE ACEITAM OBJETOS, POREM
						  //A PARTIR do JAVA 5
						  //UM PRIMITIVO PODE SER ADICIONADO A UMA COLEÇÃO ATRAVÉS
						  //DE AUTOBOXING
		arrayList.add("Thiago"+a);
		System.out.println("tamanho de arrayList: "+arrayList.size());
		System.out.println("o indice 1 de arrayList retorna: "+arrayList.get(1));
		System.out.println("arrayList possui um objeto String 'Thiago?': "+arrayList.contains("Thiago"));
		System.out.println("removendo Thiago da lista: "+arrayList.remove("Thiago"));
		System.out.println("arrayList possui um objeto String 'Thiago?': "+arrayList.contains("Thiago"));
		
		System.out.println("Testando ArrayList - Classificando");
		List<String> arrayList2 = new ArrayList<String>();
		arrayList2.add("Thiago");
		arrayList2.add("Thaisa");
		arrayList2.add("Lily");
		arrayList2.add("Barney");
		arrayList2.add("Marshall");
		
		System.out.println("lista desordenada:"+arrayList2);
		Collections.sort(arrayList2);
		// o metodo sorte de collections recebe a lista e os ordenada de acordo
		// com o comparable ou comparator do tipo do objeto, no caso String
		// implementa Comparable e log implementa o metodo compareTo(Object obj)
		System.out.println("lista ordenada:"+arrayList2);
		
		//portanto para que sort funcione, existe a necessidade de 
		//implementar Comparable caso contrário dará erro de compilação
		//ex:
		List<InformacoesDVDSemComparable> semComparable = new ArrayList<InformacoesDVDSemComparable>();
		
		//Collections.sort(semComparable); erro de compilação em sort pois 
		//InformacoesDVDSemComparable não implementa Comparable

		System.out.println("Testando ArrayList - Utilizando Comparable");
		
		List<InformacoesDVD> comComparable = new ArrayList<InformacoesDVD>();
		//ABRIR CLASS InformacoesDVD para ver sobre Comparable
		
		comComparable.add(new InformacoesDVD("Senhor dos Aneis",
														  "Ficção",
														  "Tolkien"));
		comComparable.add(new InformacoesDVD("A volta dos que não foram",
														  "Comedia",
														  "Thiago"));
		comComparable.add(new InformacoesDVD("Titanic",
														  "Drama",
														  "Thaisa"));
		
		Collections.sort(comComparable);
		System.out.println("Lista de filmes por titulo:"+comComparable);
		//A limitação de Comparable é que so podemos implementar 1 compareTo,
		//logo somente fazer 1 tipo de classificação, e para resolver isto
		//existem os Comparators
		
		System.out.println("Testando ArrayList - Utilizando Comparator");
		//A classe Collections possue sorte sobrecarregado com um metodo que utiliza
		//2 argumentos:
		//Collections.sort(Coleção(T) coleção,Comparator comparator);
		//Acessar as Classes GeneroComparator e AutorComparator

		System.out.println("---------------------------");
		System.out.println("Classificada por Autor");
		AutorComparator aC = new AutorComparator();
		Collections.sort(comComparable,aC);
		for (InformacoesDVD obj : comComparable) {
			System.out.println(obj.autor);
		}
		
		System.out.println("---------------------------");
		System.out.println("Classificada por Genero");
		GeneroComparator aG = new GeneroComparator();
		Collections.sort(comComparable,aG);
		for (InformacoesDVD obj : comComparable) {
			System.out.println(obj.genero);
		}
		System.out.println("---------------------------");
		
		System.out.println("Classificando Arrays");
		//A classe Arrays funciona da mesma forma que Collections
		InformacoesDVD[] arrayDeDVDComparable = new InformacoesDVD[3];
		arrayDeDVDComparable[0] = new InformacoesDVD("Senhor dos Aneis",
										   "Ficção",
										   "Tolkien");
		arrayDeDVDComparable[1] = new InformacoesDVD("A volta dos que nao foram",
										   "Comedia",
										   "Thiago");
		arrayDeDVDComparable[2] = new InformacoesDVD("Titanic",
										   "Drama",
										   "Thaisa");
		
		System.out.println("Array Classificada por Autor");
		Arrays.sort(arrayDeDVDComparable); //Utilizando Comparable
		for (InformacoesDVD obj : arrayDeDVDComparable) {
			System.out.println(obj.autor);
		}	
		//IMPORTANTE: Arrays de tipos primitivos SEMPRE irão ser ordenados
		//por ordem natural
		System.out.println("---------------------------");
		
		System.out.println("Buscas em Arrays e Coleções");
		//As Classes Collections e Arrays possuem o método binarySearch() para fazer
		//buscas, utiliza um comparator;
		//As coleções ou arrays que estão sendo utilizadas na busca devem ser classificadas
		//pelo mesmo Comparator que está sendo enviado a binarySearch
		//caso contrario a busca será por ordem natural, ou caso não haja ordem natural
		//o resultado n é previsivel
		String[] testeString = new String[3];
		testeString[0] = "Thiago";
		testeString[1] = "Alex";
		testeString[2] = "Roberto";
		System.out.println("Arry testeString sem classificação:");
		for (String obj : testeString) {
			System.out.println(obj);
		}
		ComparatorString comparatorString = new ComparatorString();
		Arrays.sort(testeString,comparatorString);
		System.out.println("Arry testeString classificado:");
		for (String obj : testeString) {
			System.out.println(obj);
		}
		System.out.println(Arrays.binarySearch(testeString,
						   "Roberto",
						   comparatorString));
		System.out.println("Testando binarySearch com Coleções:");
		//lembrando que o Comparator passado é o mesmo Comparator utilizado atualmente
		//para classificar a coleção
		for (InformacoesDVD obj : comComparable) {
			System.out.println(obj.genero);
		}
		System.out.println(Collections.binarySearch(comComparable,
													new InformacoesDVD("Titanic",
															  "Drama",
															  "Thaisa"),
													aG));
		System.out.println("Testando binarySearch com arrays primitivo");
		int[] arrayComPrimitivos = new int[3];
		arrayComPrimitivos[0] = 4;
		arrayComPrimitivos[1] = 1;
		arrayComPrimitivos[2] = 2;
		//IntegerComparator integerComparator = new IntegerComparator();
		//Arrays.sort(arrayComPrimitivos,integerComparator); Isto não é possivel pois
														   //pois int <> Integer
		Arrays.sort(arrayComPrimitivos);
		System.out.println(Arrays.binarySearch(arrayComPrimitivos, 4));
		//Ordenação por ordem natural, quando for um primitivo não se deve passar Comparator
		//Coleções somente aceitam Wrappers por somente aceitarem objects
		
		System.out.println("Testando Collections.toArray() e Arrays.asList");
		System.out.println("-Testes com Arrays.asList");
		String[] arrayDeStrings = new String[3];
		arrayDeStrings[0] = "Thiago";
		arrayDeStrings[1] = "Alex";
		arrayDeStrings[2] = "Bruno";
		
		List list = Arrays.asList(arrayDeStrings); // retorna um List do tipo de arrayDeStrings
		System.out.println("array to list:"+list);
		list.set(1, "Teste"); // modificando a list vinda do array
		//aparentemente somente set é suportado
		//list.set(3, "aa"); isto causara um ArrayIndexOutOfBoundsException pois 
		//devido ao vinculo arrayDeStrings não tem a 4 posição no caso a 3
		for (String obj:arrayDeStrings) {
			System.out.println(obj); //iterando sobre o array
			//observe que quando o list é modificado o array tbm é...
			//apos a conversão eles ficam vinculados
		}
		
		System.out.println("-Testes com Collections.toArray()");
		//IMPORTANTE: ao contrário de asList, toArray() não se vincula à lista anterior
		List<String> listDeStrings = new ArrayList<String>();
		listDeStrings.add("Thiago");
		listDeStrings.add("Thaisa");
		Object[] retornoSemParametro = listDeStrings.toArray(); //sem parametro retorna 
																//um array de Objects
		
		String[] retornoComParametro = new String[2];
		retornoComParametro[0] = "Maria";
		//retornoComParametro = listDeStrings.toArray(); não compila Sem parametro pois espera um array de Objects
		retornoComParametro = listDeStrings.toArray(retornoComParametro); 
		//com parametro retorna um array com o tipo especificado
					
		System.out.println("Utilizando Iterator com Lists");
		Iterator<String> iListaDeStringsAnterior = listDeStrings.iterator(); // retorna um Iterator<String>
		//um Iterator passa o tipo por generics e recebe um iterator do mesmo tipo;
		//Itarator iListaDeStringsAnterior seria válido porem um cast na hora da iteração seria necessário
		while (iListaDeStringsAnterior.hasNext()) { //hasNext() retorna true caso haja um proximo elemento na lista
													//porem ele não move o foco para tal elemento
			String obj = iListaDeStringsAnterior.next();// next() move o foco para o proximo elemento e o retorna
			//por Iterator estar tipado, não ha a necessidade de cast
		}
		
		List vector = new Vector();
		//basicamente igual ArrayList, porem seus métodos são thread-safe
		List linkedList = new LinkedList();
		//LinkedLists são ordenadas por indice e não classificadas,
		//porem são duplamente encadeadas,
		//logo sua interação é menos eficiente que ArrayList, possui metodos de
		//inserção e remoção do inicio ou final,o que a torna ideal para pilhas ou filas,
		//como LinkedList implementa tanto List quanto Queue ela possui metodos de filas:
		//-offer() insere um elemento
		//-peek() retorna o item da primeira posição
		//-poll() retorna o item da primeira posição e o remove
		
		System.out.println("Sets-----------------");
		//Os Sets não permitem duplicatas, e quem garante isso é o método equals()
		Set hashSet = new HashSet();
		//HashSets não são classificados e nem ordenados, utiliza hashing para sua inserção
		//logo quanto mais eficiente for seu hashCode() mais eficiente será o acesso
		//melhor situação de uso é para conjuntos sem duplicatas e a ordem na iteração não
		//for importante
		Set linkedHashSet = new LinkedHashSet();
		//LinkedHashSet são ordenados por ordem de inserção, porem não são classificados
		//são duplamente encadeados
		Set treeSet = new TreeSet();
		//Ordenados por classificação, e classificados por ordem natural ou implementação
		//personalizada atraves de Comparable ou Comparator
		//os elementos de TreeSet deve implementar comparable, e alem disso os elementos do TreeSet devem ser comparaveis
		//caso contrario haverá erro em tempo de execução
		System.out.println("Testando Set");
		boolean[] ba = new boolean[5];
		
		Set s = new HashSet();
		//Set s = new TreeSet(); IMPORTANTE, isso dara erro em tempo de execução
		//pois TreeSet tenta comparar os tipos de seus elementos para ordena-los
		//porem os tipos de s são diferentes, logo lançara um ClassCastException
		
		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a"); //retorna false pois ja existe "a" em s
		ba[4] = s.add(new Object());
		
		for (int x = 0;x<ba.length;x++) {
			System.out.println(ba[x]);
		}
		
		for (Object obj : s) { //ordem não garantida pois HashSet não é ordenado ou
							   //classificado
			System.out.println(obj);
		}
		
		System.out.println("Maps------------------");
		//os Maps são coleções que armazenam chave/valor;
		//tanto sua chave quanto seu valor são objetos;
		//não aceitam duplicatas na chave logo somente um valor null é aceitavel,
		//porem duplicatas nos valores são permitidas, logo multiplos nulls são aceitaveis
		//utilizam as implementações de equals() para determinar se a chave é igual ou diferente
		//e hashCode() para armazenar os elementos em containers
		Map hashMap = new HashMap();
		//não ordenado e não classificado;
		//a iteração sobre um map n é preciso por n ser ordenado;
		//a iteração dependera exclusivamente da implementação de hashCode()
		Map hashTable = new Hashtable();
		//não ordenado e não classificado
		//Semelhante ao HashMap, Hashtable tem seus métodos sincronizados ou seja, thread safe
		//outra semelhança é que Hashtable n aceita null em hipotese alguma
		Map linkedHashMap = new LinkedHashMap();
		//Ao contrario de HashMap, LinkedHashMap é ordenado por ordem se inserção
		//ou ultimo acesso e não classificadas
		//e sua iteração é mais mais rapida que HashMap
		Map treeMap = new TreeMap();
		//ordenado por classificação, e classificado por ordem
		//natura ou por regras de comparação 
		//implementadas atravez de Comparables ou Comparators
		
		System.out.println("Testes com Maps");
		
		Map<Object,Object> map = new HashMap();
		map.put("t1", "Valor String");
		map.put(new CatMap("Garfield"),"Cat");
		map.put(new DogMap("Rex"),"Dog");
		CatMap cat = new CatMap("Greg");
		map.put(cat, "Cat Instanciado");
		
		System.out.println(map.get("t1")); 
		//imprime Valor String pois String implementa equals() e hashCode()
		//logo seu container é encontrado e equals determina a igualdade da chave
		System.out.println(map.get(new CatMap("Garfield")));
		//CatMap não implementa equals() e hashCode() logo utiliza da superclasse Object
		//Object compara referências, logo as duas referencias a CatMap nesse caso são diferentes
		//e o resultado é null
		System.out.println(map.get(new DogMap("Rex")));
		//DogMap implementa equals() e hashCode() logo não importa a referencia e sim o conteudo
		//é impresso o valor "Dog"
		System.out.println(map.get(cat));
		//CatMap não implementa equals() e hashCode() logo utiliza da superclasse Object
		//Object compara referências, logo as duas referencias a CatMap nesse caso são iguais
		//e o resultado é "Cat Instanciado"
		
		//RESUMINDO:
		//1 - hashCode() para a posição correta
		//2 - equals para encontrar o objeto dentro da posição
		//lembrando que para Maps essa relevancia é em relação à chave
		
		System.out.println("NAVECAÇÃO E BUSCA - TreeMap e TreeSet");
		//Verificar a classe MetodosDeNavegacaoTreeSet
		
		System.out.println("Queues--------------------");
		//São utilizadas normalmente para coisas a fazer, ou seja, processamentos, por 
		//terem a caracteristica de pilha.
		Queue priorityQueue = new PriorityQueue();
		//como filas, porem ao inves de first in, first out, utiliza-se priority in,
		//priority-out
		//e em priority refere-set a por exemplo uma ordem ou classificação;
		//ex:
		Queue<Integer> testeQueue = new PriorityQueue<Integer>();
		//ordem natural quando não é passado um Comparator no contrutor
		testeQueue.add(2);
		testeQueue.add(1);
		testeQueue.add(3);
		System.out.println(testeQueue.peek()); //retorna a prioridade
		testeQueue.offer(5); //adiciona prioridades a lista
		System.out.println(testeQueue.poll());//retorna e remove a prioridade
		System.out.println(testeQueue.peek());
	}
}

class DogMap {
	public String name;
	
	DogMap(String name) {
		this.name = name;
	}
	
	public boolean equals(Object o) {
		if ((o instanceof DogMap) && (((DogMap)o).name.equals(this.name))) {
			return true;
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return this.name.length();
	}
}

class CatMap {
	public String name;
	
	CatMap(String name) {
		this.name = name;
	}
}
