package GenericsAndCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class OutrosTestesGenericos {
	public static void main(String[] args) {
		//ArrayList<String> a = new ArrayList<String>();
		List<CharSequence> a = new ArrayList<CharSequence>();
		doIt(a);
		
		
		NavigableMap<String, String> mymap = new TreeMap<String, String>();
        mymap.put("a", "apple"); mymap.put("b", "boy"); mymap.put("c", "cat");
        mymap.put("aa", "apple1"); mymap.put("bb", "boy1"); mymap.put("cc", "cat1");

        System.out.println(mymap);
        
        System.out.println(mymap.pollLastEntry()); //LINE 1
        System.out.println(mymap.pollFirstEntry()); //LINE 2
        
        NavigableMap<String, String> tailmap = mymap.tailMap("bb", false); //esse cosntrutor
        //recebe o segundo argumento para dizer se o primeiro será inclusive ou exclusive no tailMap
        System.out.println(tailmap);
        
        System.out.println(tailmap.pollFirstEntry()); //LINE 4
        System.out.println(mymap.size()); //LINE 5
	}
	
	public static <E extends CharSequence> List<? super E> doIt(List<E> nums)  {
		return nums;
	}
}
