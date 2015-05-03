package GenericsAndCollections;

import java.util.Arrays;

public class TestandoBinarySearch {
	public static void main(String[] args) {
		String[] arrTeste = {"a","aa","b","bb","c","cc"};
		Arrays.sort(arrTeste);
		for (String obj : arrTeste) 
			System.out.println(obj);
		System.out.println(Arrays.binarySearch(arrTeste, "bbb")); //deve imprimir -3
		//ou seja o lugar o qual "aaa" seria inserido a partir de 0... -1
		//ou seja (-(lugar de inserção) -1)
	}
}
