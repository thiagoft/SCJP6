package GenericsAndCollections;

import java.util.HashMap;
import java.util.Map;

public class IterandoEmUmMap {
	public static void main(String[] args) {
		
		Map<String,Object> myHashMap = new HashMap<String,Object>();
		myHashMap.put("1", new Object());
		
		for (Map.Entry<String,Object> pair : myHashMap.entrySet()) {
		    System.out.println(pair.getKey());
		    System.out.println(pair.getValue());
		}
	}
}
