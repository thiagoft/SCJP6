package GenericsAndCollections;

public class InformacoesDVD implements Comparable<InformacoesDVD> {
									   //Comparable é uma classe generica
									   //Logo o tipo deve ser passado atravez
									   //de generics
	String titulo;
	String genero;
	String autor;
	
	//contrato da interface Comparable que deve ser implementado
	public int compareTo(InformacoesDVD obj) { //como argumento deve ser passado
											   //a propria classe ou Object
											   //porem com object deve ser feito cast
											   //InformacoesDVD a = (InformacoesDVD) obj;
		//o retorno deve ser um int:
		//negativo: se thisObject < outroObject;
		//zero: se thisObject == outroObject;
		//positivo: se thisObject > outroObject;
		return titulo.compareTo(obj.titulo); 
		//neste caso titulo é uma String e implementa Comparable, logo podemos usa-lo
	}
	
	InformacoesDVD(String t, String g, String a) {
		this.titulo = t;
		this.genero = g;
		this.autor = a;
	}
	
	InformacoesDVD() {}
	
	public String toString() {
		return this.titulo;
	}
}
