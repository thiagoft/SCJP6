package GenericsAndCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CollectionsOutrosTestes {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("Teste1");
		a.add("Teste2");
		for (String o : a) {
			a.set(0, "AA");
		}
		
		for (String b : a)
			System.out.println(b);
	}
	
	class TesteHeranca extends HashMap {
		//as Collections não são final
	}
}
