package StringsIOFormatAndParsing;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TesteNumberFormat {
	public static void main(String[] args) {
		float f1 = 123.56656f;
		System.out.println("Instanciando um NumberFormat");
		Locale localePT = new Locale("pt","PT");
		
		NumberFormat[] nfa = new NumberFormat[6];
		
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getInstance(localePT);
		nfa[2] = NumberFormat.getNumberInstance();
		nfa[3] = NumberFormat.getNumberInstance(localePT);
		nfa[4] = NumberFormat.getCurrencyInstance();
		nfa[5] = NumberFormat.getCurrencyInstance(localePT);
		
		for (NumberFormat nf : nfa) {
			System.out.println(nf.format(f1)); //ao formatar de acordo com a qntidade
											   //maxima de casas decimais da linguagem
											   //padrão ele arredonda o valor
			System.out.println(nf.getMaximumFractionDigits()+"");//diz a quantidade
																 //de casas apos a virgula
																 //permitida na linguagem
			nf.setMaximumFractionDigits(5);  //seta a quantidade
											 //de casas apos a virgula
			try {
				System.out.println(nf.parse("123,56656")); //parse(String obj)
				nf.setParseIntegerOnly(true); //trunca valor
				System.out.println(nf.parse("123,56656"));//parse(String obj)
			} catch(ParseException e) {
				//e.printStackTrace();
			}
			System.out.println("-------------------------------");
		}
	}
}
