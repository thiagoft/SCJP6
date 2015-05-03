package GenericsAndCollections;

import java.util.Comparator;

public class ComparatorString implements Comparator<String> {
	public int compare(String one, String two) {
		return one.compareTo(two);
	}
}
