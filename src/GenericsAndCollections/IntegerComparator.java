package GenericsAndCollections;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {
	public int compare(Integer one, Integer two) {
		return one.compareTo(two);
	}
}
