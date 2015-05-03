package StringsIOFormatAndParsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteTokenizacao {
	public static void main(String[] args) {
		//String.split("regex"); é usado paratokenizar
		//onde "teste,teste1", teste e teste1 são tokens e "," o delimitador
		//split() é executado sobre toda a origem de uma so vez. não é possivel interromper
		
		//IMPORTANTE: PARA EXIBIR "." "\" ou "... é necessário utilizar o scape
		// "\\." exibe um . pois \. não éum metacaractere
		// "\\" exibe uma \
		// "\"" exibe um "
		
		List<String> c = new ArrayList<String>();
		String a = ",,,,,,,";
		Scanner b = new Scanner(a);
		b.useDelimiter(",");
		while (b.hasNext()) {
			c.add(b.next());
		}
		System.out.println(c.size());
		
	}
}
