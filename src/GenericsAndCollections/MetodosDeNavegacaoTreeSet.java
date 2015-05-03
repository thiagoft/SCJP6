package GenericsAndCollections;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class MetodosDeNavegacaoTreeSet {
	public static void main(String[] args) {
		NavigableSet<String> myset = new TreeSet<String>();
		myset.add("a");
		myset.add("b");
		myset.add("c");
		myset.add("aa");
		myset.add("bb");
		myset.add("cc");
		
		for (String obj : myset) {
			System.out.println(obj);
		}
		/* saida menos para o maior
		 a
		 aa
		 b
		 bb
		 c
		 cc
		 */
		
		System.out.println("___");
		System.out.println(myset.ceiling("a")); //a - pois ceiling >= que E 
		System.out.println(myset.lower("aaa")); //aa - pois lower < E, como aaa estaria a frente de "aa" então aa é imediatamente anterior a "aaa" 
		System.out.println(myset.higher("a")); //aa - pois higher > E 
		System.out.println(myset.floor("bb")); //bb - pois floor <= E
		System.out.println("___");
		System.out.println(myset.floor("a")); //a - pois floor <= a
		System.out.println(myset.ceiling("aaa")); //b - pois ceiling >= E, como "aaa" não é igual a "aa" seu maior imediato é b
		System.out.println(myset.lower("a")); //null - pois lower < E, como não há elementos antes de "a" o anterior imediato é null
		System.out.println(myset.higher("bb")); //c - pois higher > E
		
		//para TreeMaps
		//usa-se os mesmo metodos de TreeSet porem com o sufixo Key
		//ex: exemplo ceilingKey(), lowerKey() etc...
		
		System.out.println(myset.descendingSet());// retorna um NavigableSet em ordem reversa
		//para TreeMaps descendingMap();
		System.out.println(myset.pollFirst()); //retorna e remove a primeira entrada no caso "a"
		System.out.println(myset.pollLast()); //retorna e remove a ultima entrada no caso "cc"
		//em ambos os casos, em TreeMaps adiciona-se o sufixo Entry(); pollFirstEntry(), pollLastEntry()
		System.out.println(myset);
		
		System.out.println("Coleções Vinculadas");
		SortedSet<String> sortedSet = myset.subSet("b", "c");
		System.out.println(sortedSet);
		//subSet extrai de TreeSet do elemento "b" até o elemento antes de c
		SortedSet<String> sortedSet2 = myset.subSet("aa", "aa"); //retorna SorteMap vazio
		System.out.println(sortedSet2);
		//SortedSet<String> sortedSet3 = myset.subSet("aa", "a"); 
		//lança uma exceção de tempo de execução IllegalArgumentException: fromKey>toKey
		
		//como são coleções vinculadas, a alteração em um acarretará na alteração da outra
		//ex:
		sortedSet.add("bbb");
		//sortedSet.add("cc"); erro de tempo de execução pois "cc" está fora do range
		//de sortedSet
		System.out.println(myset);
		myset.add("bbbb");
		System.out.println(sortedSet);
		
		System.out.println(myset);
		SortedSet<String> headSet = myset.headSet("bb");//retorna um subSet do começo 
		//do conjunto até 1 item antes de "bb"
		System.out.println(headSet);

		SortedSet<String> tailSet = myset.tailSet("bbb");//retorna um subSet do item
		//citado até o final da lista
		System.out.println(tailSet);
		
	}
}
