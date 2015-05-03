package StringsIOFormatAndParsing;

import java.util.Scanner;
import java.util.regex.*;

public class TestesRegex {
	public static void main(String[] args) {
		
		//OBSERVAÇÕES: o caracter "\" é um caracter de escape, logo para usar
		//operador do tipo \d em uma String é necessário colocar \ antes...
		//ou seja "\\d" ... "\d" < isto não irá compilar
		
		//no caso do .(ponto) ... "." - isto é considerado um metacaracter (qualquer coisa em regex)
		//"\\." o compilador ve isto como um ponto literalmente
		
		Pattern p = Pattern.compile("aba"); // cria a expressão
		Matcher m = p.matcher("abababa"); // cria a origem do dado
		while (m.find()) { //busca a proxima ocorrência de expressão na origem 
						   //e retorna true caso exista
			System.out.println(m.start()+" "+m.group()); 
			//start() retorna o indice onde começa o resultado
			//group() retorna a ocorrência completa para cada resultado
		}
		
		//Primeira regra para regex: é feita a análise da esquerda para direita
		//sendo que depois que um caractere da origem tenha sido usado em uma ocorrencia
		//ele n será reutilizado
		
		System.out.println("-----------------------------");
		System.out.println("Outros Exemplos de uso de regex");
		// \d Um digito
		// \s Um caracter de espaço em branco
		// \w Um caracter de palavra (letras,digitos ou "_")
		
		p = Pattern.compile("\\w");
		m = p.matcher("a 1 56 _Z");
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0 2 4 5 7 8
			//start() retorna a posição a qual atende a primeira ocorrência do padrão
		}
		
		System.out.println("-----------------------------");
		// [] reune conjuntos de padrões,e "-" demarca intervalos
		p = Pattern.compile("[a-fA-F]"); //ou conjuntos especificos [abcdef] 
										 //ou intervalos unicos [a-f]
		m = p.matcher("aHfGABcDDE");
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0 2 4 5 6 7 8 9
		}
		
		System.out.println("-----------------------------");
		System.out.println("Exemplos complexo de regex");
		// + uma ou mais ocorrências "\\d+"(uma ou mais ocorrencias de decimais)
		p = Pattern.compile("\\d+");
		m = p.matcher("0989 - 909 09-");
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0 7 11
		}
		System.out.println("-----------------------------");
		
		//[abc]+ (uma ou mais ocorrências de a ou b ou c)
		p = Pattern.compile("[abc]+"); 
		m = p.matcher("acb bacabcab c - 909 09- ab");
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0 4 13 25
		}
		System.out.println("-----------------------------");
		
		p = Pattern.compile("abc+"); //especificamente abc<qualquer coisa>
		m = p.matcher("acb bacabcab c - 909 09- ab");
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 7
		}
		System.out.println("-----------------------------");
		
		
		// "\\w+" uma ou mais ocorrências de letras digitos ou "_"
		p = Pattern.compile("\\w+");
		m = p.matcher("acb bacabcab c _ 909 09- ab");
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 7
		}
		System.out.println("-----------------------------");
		
		//padrão 0 seguido por x ou X seguido por um numero de 0 a 9 ou de a à f ou A à F
		//1 especificamente; para pegar toda uma sequência continua desses caracteres
		//precisaria acrescentar ()+ na segunda expressão ficando assim 0[xX]([0-9a-fA-F])+
		p = Pattern.compile("0[xX][0-9a-fA-F]");
		m = p.matcher("12 0x 0x1g2 0Xf 0xg"); 
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 6 e 12
		}
		System.out.println("-----------------------------");
		
		// * nenhuma ou mais ocorrências
		p = Pattern.compile("proj1([^,])*"); // proj1[^,]* pegaria tudo que for proj1
										   //mais nenhuma ou qualquer ocorrencia que n seja ,(virgula)
										   //nesse caso proj1([^,])* pega todas as proximas
										   //ocorrencias que n seja ,(virgula)
		m = p.matcher("proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java"); //retorna 6 e 12
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 10 25 37
		}
		System.out.println("-----------------------------");
		
		// ? nenhuma ou uma ocorrência
		p = Pattern.compile("\\d\\d\\d\\d([-\\s])?\\d\\d\\d\\d");
		m = p.matcher("1234567 1234 4567 1234-4567"); 
		//ele pega da primeira sequencia "4567 1234" "4567 1234"
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 3 13
		}
		System.out.println("-----------------------------");
		
		// . (ponto) qualquer coisa
		p = Pattern.compile("a.c");
		m = p.matcher("abc ac a c"); //encontra tanto abc qnto "a c"
		while (m.find()) {
			System.out.println(m.start()+ " " +m.group()); //retorna 0 7
		}
		System.out.println("-----------------------------");
		
		//QUANTIFICADORES GANANCIOSOS
		//? é ganancioso,?? é relutante, para zero ou um
		//* é ganancioso, *? é relutante, para zero ou mais
		//+ é ganancioso, +? é relutante, para um ou mais
		p = Pattern.compile(".*xx"); //como prefixo de uma expressão
		//o quantificador ganancioso lê a origem de dados completamente
		//depois procura da direita para a esquerda
		m = p.matcher("yyxxxyxx"); 
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0
		}
		System.out.println("-----------------------------");
		p = Pattern.compile(".*\\d"); //como prefixo de uma expressão
		m = p.matcher("kj23k"); 
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0
		}
		
		System.out.println("-----------------------------");
		
		// \n 
		p = Pattern.compile("\n"); //não é um metacaracter é um scape para pular linha
		m = p.matcher("abc ac \n a c"); //encontra o literal \n
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 7
		}
		
		System.out.println("-----------------------------");
		
		p = Pattern.compile("\\d*"); //como prefixo de uma expressão
		m = p.matcher("kj23k"); // retorna posição 5(que seria a 6ª posição)
								//por causa do operador * zero ou mais
		while (m.find()) {
			System.out.println(m.start()+ " "+m.group()); //retorna 0
		}
		
		System.out.println("-----------------------------");
		System.out.println("Teste Com Scanner");
		System.out.print("input: ");
		try {
			Scanner s = new Scanner(System.in);
			String token;
			do {
				token = s.findInLine("\\d\\d"); //recebe uma entrada ... no caso 1b2c335f456
												//itera sobre a entrada até não encontrar mais ocorrências
				System.out.println("found "+token);
			} while (token != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("------------------------------");
		System.out.println("Outros Testes");
		Pattern p1 = Pattern.compile("[\\d\\d]*");
		Matcher m1 = p1.matcher("123ddc2ab23");
		boolean b = false;
		while(b = m1.find())
		{
		    System.out.println(m1.start()+" "+m1.group());
		}

	}
}
