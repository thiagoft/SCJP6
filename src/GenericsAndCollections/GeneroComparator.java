package GenericsAndCollections;

import java.util.Comparator;

public class GeneroComparator implements Comparator<InformacoesDVD> {
										   //como argumento deve ser passado
										   //a propria classe ou Object
										   //porem com object deve ser feito cast
										   //InformacoesDVD a = (InformacoesDVD) obj;	
	//compara 2 objetos separados e retorna um int
	public int compare(InformacoesDVD one, InformacoesDVD two) {
		return one.genero.compareTo(two.genero);
	}
	
}
