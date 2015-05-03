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
	//Collection � a interface m�e das collections Set, List e Queue
	//Collections � a classe com metodos utilit�rios para auxiliar a manipula��o
	//das Collections
	
	//Lembrando que Map � uma cole��o mas n extende Collection
	
	//List: s�o Ordenadas por �ndice e permitem repeti��o
	//Set: Podem ou n�o ser ordenados e /ou classificados e n�o permitem repeti��o
	//Map: chave/valor podem ou n�o ser ordenados e/ou classificados e a repeti��o de chaves n�o
	//� permitida. (OBS: n�o confundir chave... com container hash)
	//Queue: ordenados por FIFO ou por prioridade
	
	//ORDENA��O E CLASSIFICA��O
	
	//Ordenado: obedecer a uma ordem espec�fica n�o aleat�ria, vc pode iterar sobre
	//ela em uma ordem espec�fica n�o aleat�ria
	//-Pode ser ordem de inser��o, por indice, ou ordem natural
	//Classificado: obedecer a uma orderm classificada estabelecida
	//-Pode ser alfab�tica, num�rica ou definida pelo programador que n�o seja
	//por inser��o acesso ou indice
	
	public static void main(String[] args) {
		System.out.println("Lists-----------------");
		System.out.println("Testando ArrayList");
		//ArrayList ordenada por indice e n�o classificadas, possui itera��o rapida porem menos eficiente
		//que LinkedList para mtas inser��es/remo��es
		List arrayList = new ArrayList();
		int a = 1;
		arrayList.add("Thiago");
		arrayList.add(a); //IMPORTANTE COLE��ES SOMENTE ACEITAM OBJETOS, POREM
						  //A PARTIR do JAVA 5
						  //UM PRIMITIVO PODE SER ADICIONADO A UMA COLE��O ATRAV�S
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
		//implementar Comparable caso contr�rio dar� erro de compila��o
		//ex:
		List<InformacoesDVDSemComparable> semComparable = new ArrayList<InformacoesDVDSemComparable>();
		
		//Collections.sort(semComparable); erro de compila��o em sort pois 
		//InformacoesDVDSemComparable n�o implementa Comparable

		System.out.println("Testando ArrayList - Utilizando Comparable");
		
		List<InformacoesDVD> comComparable = new ArrayList<InformacoesDVD>();
		//ABRIR CLASS InformacoesDVD para ver sobre Comparable
		
		comComparable.add(new InformacoesDVD("Senhor dos Aneis",
														  "Fic��o",
														  "Tolkien"));
		comComparable.add(new InformacoesDVD("A volta dos que n�o foram",
														  "Comedia",
														  "Thiago"));
		comComparable.add(new InformacoesDVD("Titanic",
														  "Drama",
														  "Thaisa"));
		
		Collections.sort(comComparable);
		System.out.println("Lista de filmes por titulo:"+comComparable);
		//A limita��o de Comparable � que so podemos implementar 1 compareTo,
		//logo somente fazer 1 tipo de classifica��o, e para resolver isto
		//existem os Comparators
		
		System.out.println("Testando ArrayList - Utilizando Comparator");
		//A classe Collections possue sorte sobrecarregado com um metodo que utiliza
		//2 argumentos:
		//Collections.sort(Cole��o(T) cole��o,Comparator comparator);
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
										   "Fic��o",
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
		//IMPORTANTE: Arrays de tipos primitivos SEMPRE ir�o ser ordenados
		//por ordem natural
		System.out.println("---------------------------");
		
		System.out.println("Buscas em Arrays e Cole��es");
		//As Classes Collections e Arrays possuem o m�todo binarySearch() para fazer
		//buscas, utiliza um comparator;
		//As cole��es ou arrays que est�o sendo utilizadas na busca devem ser classificadas
		//pelo mesmo Comparator que est� sendo enviado a binarySearch
		//caso contrario a busca ser� por ordem natural, ou caso n�o haja ordem natural
		//o resultado n � previsivel
		String[] testeString = new String[3];
		testeString[0] = "Thiago";
		testeString[1] = "Alex";
		testeString[2] = "Roberto";
		System.out.println("Arry testeString sem classifica��o:");
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
		System.out.println("Testando binarySearch com Cole��es:");
		//lembrando que o Comparator passado � o mesmo Comparator utilizado atualmente
		//para classificar a cole��o
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
		//Arrays.sort(arrayComPrimitivos,integerComparator); Isto n�o � possivel pois
														   //pois int <> Integer
		Arrays.sort(arrayComPrimitivos);
		System.out.println(Arrays.binarySearch(arrayComPrimitivos, 4));
		//Ordena��o por ordem natural, quando for um primitivo n�o se deve passar Comparator
		//Cole��es somente aceitam Wrappers por somente aceitarem objects
		
		System.out.println("Testando Collections.toArray() e Arrays.asList");
		System.out.println("-Testes com Arrays.asList");
		String[] arrayDeStrings = new String[3];
		arrayDeStrings[0] = "Thiago";
		arrayDeStrings[1] = "Alex";
		arrayDeStrings[2] = "Bruno";
		
		List list = Arrays.asList(arrayDeStrings); // retorna um List do tipo de arrayDeStrings
		System.out.println("array to list:"+list);
		list.set(1, "Teste"); // modificando a list vinda do array
		//aparentemente somente set � suportado
		//list.set(3, "aa"); isto causara um ArrayIndexOutOfBoundsException pois 
		//devido ao vinculo arrayDeStrings n�o tem a 4 posi��o no caso a 3
		for (String obj:arrayDeStrings) {
			System.out.println(obj); //iterando sobre o array
			//observe que quando o list � modificado o array tbm �...
			//apos a convers�o eles ficam vinculados
		}
		
		System.out.println("-Testes com Collections.toArray()");
		//IMPORTANTE: ao contr�rio de asList, toArray() n�o se vincula � lista anterior
		List<String> listDeStrings = new ArrayList<String>();
		listDeStrings.add("Thiago");
		listDeStrings.add("Thaisa");
		Object[] retornoSemParametro = listDeStrings.toArray(); //sem parametro retorna 
																//um array de Objects
		
		String[] retornoComParametro = new String[2];
		retornoComParametro[0] = "Maria";
		//retornoComParametro = listDeStrings.toArray(); n�o compila Sem parametro pois espera um array de Objects
		retornoComParametro = listDeStrings.toArray(retornoComParametro); 
		//com parametro retorna um array com o tipo especificado
					
		System.out.println("Utilizando Iterator com Lists");
		Iterator<String> iListaDeStringsAnterior = listDeStrings.iterator(); // retorna um Iterator<String>
		//um Iterator passa o tipo por generics e recebe um iterator do mesmo tipo;
		//Itarator iListaDeStringsAnterior seria v�lido porem um cast na hora da itera��o seria necess�rio
		while (iListaDeStringsAnterior.hasNext()) { //hasNext() retorna true caso haja um proximo elemento na lista
													//porem ele n�o move o foco para tal elemento
			String obj = iListaDeStringsAnterior.next();// next() move o foco para o proximo elemento e o retorna
			//por Iterator estar tipado, n�o ha a necessidade de cast
		}
		
		List vector = new Vector();
		//basicamente igual ArrayList, porem seus m�todos s�o thread-safe
		List linkedList = new LinkedList();
		//LinkedLists s�o ordenadas por indice e n�o classificadas,
		//porem s�o duplamente encadeadas,
		//logo sua intera��o � menos eficiente que ArrayList, possui metodos de
		//inser��o e remo��o do inicio ou final,o que a torna ideal para pilhas ou filas,
		//como LinkedList implementa tanto List quanto Queue ela possui metodos de filas:
		//-offer() insere um elemento
		//-peek() retorna o item da primeira posi��o
		//-poll() retorna o item da primeira posi��o e o remove
		
		System.out.println("Sets-----------------");
		//Os Sets n�o permitem duplicatas, e quem garante isso � o m�todo equals()
		Set hashSet = new HashSet();
		//HashSets n�o s�o classificados e nem ordenados, utiliza hashing para sua inser��o
		//logo quanto mais eficiente for seu hashCode() mais eficiente ser� o acesso
		//melhor situa��o de uso � para conjuntos sem duplicatas e a ordem na itera��o n�o
		//for importante
		Set linkedHashSet = new LinkedHashSet();
		//LinkedHashSet s�o ordenados por ordem de inser��o, porem n�o s�o classificados
		//s�o duplamente encadeados
		Set treeSet = new TreeSet();
		//Ordenados por classifica��o, e classificados por ordem natural ou implementa��o
		//personalizada atraves de Comparable ou Comparator
		//os elementos de TreeSet deve implementar comparable, e alem disso os elementos do TreeSet devem ser comparaveis
		//caso contrario haver� erro em tempo de execu��o
		System.out.println("Testando Set");
		boolean[] ba = new boolean[5];
		
		Set s = new HashSet();
		//Set s = new TreeSet(); IMPORTANTE, isso dara erro em tempo de execu��o
		//pois TreeSet tenta comparar os tipos de seus elementos para ordena-los
		//porem os tipos de s s�o diferentes, logo lan�ara um ClassCastException
		
		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a"); //retorna false pois ja existe "a" em s
		ba[4] = s.add(new Object());
		
		for (int x = 0;x<ba.length;x++) {
			System.out.println(ba[x]);
		}
		
		for (Object obj : s) { //ordem n�o garantida pois HashSet n�o � ordenado ou
							   //classificado
			System.out.println(obj);
		}
		
		System.out.println("Maps------------------");
		//os Maps s�o cole��es que armazenam chave/valor;
		//tanto sua chave quanto seu valor s�o objetos;
		//n�o aceitam duplicatas na chave logo somente um valor null � aceitavel,
		//porem duplicatas nos valores s�o permitidas, logo multiplos nulls s�o aceitaveis
		//utilizam as implementa��es de equals() para determinar se a chave � igual ou diferente
		//e hashCode() para armazenar os elementos em containers
		Map hashMap = new HashMap();
		//n�o ordenado e n�o classificado;
		//a itera��o sobre um map n � preciso por n ser ordenado;
		//a itera��o dependera exclusivamente da implementa��o de hashCode()
		Map hashTable = new Hashtable();
		//n�o ordenado e n�o classificado
		//Semelhante ao HashMap, Hashtable tem seus m�todos sincronizados ou seja, thread safe
		//outra semelhan�a � que Hashtable n aceita null em hipotese alguma
		Map linkedHashMap = new LinkedHashMap();
		//Ao contrario de HashMap, LinkedHashMap � ordenado por ordem se inser��o
		//ou ultimo acesso e n�o classificadas
		//e sua itera��o � mais mais rapida que HashMap
		Map treeMap = new TreeMap();
		//ordenado por classifica��o, e classificado por ordem
		//natura ou por regras de compara��o 
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
		//logo seu container � encontrado e equals determina a igualdade da chave
		System.out.println(map.get(new CatMap("Garfield")));
		//CatMap n�o implementa equals() e hashCode() logo utiliza da superclasse Object
		//Object compara refer�ncias, logo as duas referencias a CatMap nesse caso s�o diferentes
		//e o resultado � null
		System.out.println(map.get(new DogMap("Rex")));
		//DogMap implementa equals() e hashCode() logo n�o importa a referencia e sim o conteudo
		//� impresso o valor "Dog"
		System.out.println(map.get(cat));
		//CatMap n�o implementa equals() e hashCode() logo utiliza da superclasse Object
		//Object compara refer�ncias, logo as duas referencias a CatMap nesse caso s�o iguais
		//e o resultado � "Cat Instanciado"
		
		//RESUMINDO:
		//1 - hashCode() para a posi��o correta
		//2 - equals para encontrar o objeto dentro da posi��o
		//lembrando que para Maps essa relevancia � em rela��o � chave
		
		System.out.println("NAVECA��O E BUSCA - TreeMap e TreeSet");
		//Verificar a classe MetodosDeNavegacaoTreeSet
		
		System.out.println("Queues--------------------");
		//S�o utilizadas normalmente para coisas a fazer, ou seja, processamentos, por 
		//terem a caracteristica de pilha.
		Queue priorityQueue = new PriorityQueue();
		//como filas, porem ao inves de first in, first out, utiliza-se priority in,
		//priority-out
		//e em priority refere-set a por exemplo uma ordem ou classifica��o;
		//ex:
		Queue<Integer> testeQueue = new PriorityQueue<Integer>();
		//ordem natural quando n�o � passado um Comparator no contrutor
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
