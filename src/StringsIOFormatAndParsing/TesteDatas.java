package StringsIOFormatAndParsing;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TesteDatas {
	public static void main(String[] args) {
		//Date ponte para Calendar e DateFormat é contada em milliseconds e começa em
		//1º de janeiro de 1970
		//Calentar, Classe com muitos metodos de tratamento de datas e tempo
		//DateFormat formtação de data/tempo
		//NumberFormat formatação de numeros
		//Locale usado em conjunto com DateFormat e NumberFormat
		
		System.out.println("Extraindo data atual atraves de um Date");
		Date dateTimeFromDate = new Date();
		dateTimeFromDate.setTime(dateTimeFromDate.getTime()+30000);
		System.out.println(dateTimeFromDate); // Date implementa toString
		
		System.out.println("Extraindo data atual atraves de um Calendar");
		Calendar calendar = Calendar.getInstance(); //pode receber um Locale
		Calendar calendarFromDate = Calendar.getInstance();
		calendarFromDate.setTime(dateTimeFromDate);
		System.out.println("primeiro dia da semana:"+calendarFromDate.getFirstDayOfWeek()); //de 1 a 7
		System.out.println("hoje em dias da semana:"+calendarFromDate.get(calendarFromDate.DAY_OF_WEEK));
		calendarFromDate.add(calendarFromDate.DAY_OF_MONTH, 5);
		System.out.println(calendarFromDate.get(calendarFromDate.DAY_OF_WEEK)+" - "+calendarFromDate.getTime());
		//ou
		System.out.println(calendarFromDate.get(calendarFromDate.DAY_OF_WEEK)+" - "+new Date(calendarFromDate.getTimeInMillis()));		
		System.out.println(calendar.getTime());
		
		System.out.println(calendar.getTime());
		calendar.roll(calendar.DAY_OF_MONTH, 40); //adiciona o valor ao elemento
												  //rotaciona normalmente dependendo
												  //do parâmetro, porém
												  //sem modificar os outros campos
		System.out.println(calendar.getTime());
		
		System.out.println("Testes DateFormat");
		Date d1 = new Date();
		DateFormat[] dfa = new DateFormat[6];
		//Criando instâncias de DateFormat
		dfa[0] = DateFormat.getInstance(); //Date/Time
		dfa[1] = DateFormat.getDateInstance(); 
		dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
		dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
		dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
		dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);
		
		System.out.println("Teste DateFormat - Date para String Formatado");
		for (DateFormat df : dfa) {
			String dataFormatada = ""; 
			try {
				System.out.println(dataFormatada = df.format(d1));
				
				System.out.println("Teste DateFormat - String para Date");
				Date d2 = dfa[2].parse(dataFormatada);
				//ao converter uma String formatada para date perde-se precisão
				//pelo fato de usar uma formatação que não utiliza Tempo na formatação
				System.out.println(d2);
			} catch(ParseException e) {
				e.printStackTrace();
			}			
		}

		System.out.println("Criando um locale");
		Locale localeITCH = new Locale("it","CH"); //argumentos (Linguagem,Pais) "it","CH" Italiano usado na Suiça
		System.out.println(localeITCH.getDisplayCountry()); //nome do Pais por default da JVM
		System.out.println(localeITCH.getDisplayCountry(localeITCH)); //Pela Linguagem
		System.out.println(localeITCH.getDisplayLanguage()); //nome do Pais por default da JVM
		System.out.println(localeITCH.getDisplayLanguage(localeITCH)); //Pela Linguagem
		Locale localeIT = new Locale("it");//argumentos (Linguagem) no caso de "it" Italiano
		Locale localePTBR = new Locale("pt","BR"); //argumentos (Linguagem,Pais) "pt","BR" Portugues usado no Brasil
		System.out.println(localePTBR.getDisplayCountry()); //nome do Pais por default da JVM
		System.out.println(localePTBR.getDisplayCountry(localePTBR));//Pela Linguagem
		System.out.println(localePTBR.getDisplayLanguage()); //nome do Pais por default da JVM
		System.out.println(localePTBR.getDisplayLanguage(localePTBR)); //Pela Linguagem
		Locale localePT = new Locale("pt");//argumentos (Linguagem) no caso de "pt" Portugues
		
		DateFormat dfDefault = DateFormat.getInstance(); //Default da jvm retorna Data/Hora
		System.out.println("Default JVM "+dfDefault.format(d1));
		
		DateFormat dfDefaultFull =DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Default JVM FULL "+dfDefaultFull.format(d1));
		
		System.out.println("Usando Locale com DateFormat");
		//atribuindo um locale ao calendar
		Calendar calendarComLocale = Calendar.getInstance(localePT); //pode receber um Locale
		System.out.println(calendar.getTime());
		
		DateFormat dfPt = DateFormat.getDateInstance(DateFormat.FULL, localePT);
		System.out.println(dfPt.format(d1));
		
		DateFormat dfPtBr = DateFormat.getDateInstance(DateFormat.FULL, localePTBR);
		System.out.println(dfPtBr.format(d1));
		
		DateFormat dfIt = DateFormat.getDateInstance(DateFormat.FULL, localeIT);
		System.out.println(dfIt.format(d1));
		
		DateFormat dfItCh = DateFormat.getDateInstance(DateFormat.FULL, localeITCH);
		System.out.println(dfItCh.format(d1));
		
		
		Locale l = Locale.getDefault(); // traz o Locale default
        DateFormat df = DateFormat.getDateInstance();
        System.out.println(l.getCountry()+" "+ df.format(new Date()));
	}
}
