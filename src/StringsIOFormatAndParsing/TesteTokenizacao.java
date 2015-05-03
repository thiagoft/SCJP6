package StringsIOFormatAndParsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteTokenizacao {
	public static void main(String[] args) {
		//String.split("regex"); � usado paratokenizar
		//onde "teste,teste1", teste e teste1 s�o tokens e "," o delimitador
		//split() � executado sobre toda a origem de uma so vez. n�o � possivel interromper
		
		//IMPORTANTE: PARA EXIBIR "." "\" ou "... � necess�rio utilizar o scape
		// "\\." exibe um . pois \. n�o �um metacaractere
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
