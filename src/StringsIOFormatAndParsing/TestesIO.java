package StringsIOFormatAndParsing;

import java.io.*;

public class TestesIO {
	public static void main(String[] args) {
		//neste momento fora declarados objetos file porem
		//tanto arquivo qnto diretorio n foram criados fisicamente
		File arquivo = new File("FileTxt.txt");
		System.out.println("arquivo criado?:"+arquivo.exists()); //verifica se existe o arquivo
		File diretorio = new File("diretorio");
		System.out.println("diretorio criado?:"+diretorio.exists()); //verifica se existe o diretorio
		
		System.out.println("TESTANDO A MANIPULAÇÃO DO FILE");
		try {
			//nesse momento são ambos criados
			arquivo.createNewFile();
			System.out.println("é um arquivo?:"+arquivo.isFile());
			
			File arquivoRenomeado = new File("FileTxt2.txt");
			arquivo.renameTo(arquivoRenomeado);
			arquivoRenomeado.delete();
			
			diretorio.mkdir();
			System.out.println("é um diretorio?:"+arquivo.isDirectory());
			
			File arquivoParaDiretorio = new File(diretorio, "arquivoNoDiretorio.txt");
			//File arquivoParaDiretorio = new File("diretorio", "arquivoNoDiretorio.txt"); //valido
			arquivoParaDiretorio.createNewFile();
			
			String[] listaDeArquivosEmDiretorio = diretorio.list();
			System.out.println("qntidade de arquivos no diretorio:"+
								listaDeArquivosEmDiretorio.length);
			for (String arquivoCriado : listaDeArquivosEmDiretorio) {
				System.out.println(arquivoCriado);
			}
			
			//LEMBRANDO QUE, tentar apagar diretorios não vazios gerará IOException
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("TESTANDO A MANIPULAÇÃO DOS WRITERS E READERS");
		File file = new File("txtFileWirterFileReader.txt");
		File file2 = new File("txtBuffereds.txt");
		try {
			System.out.println("TESTE FILEWRITER E FILEREADER");
			FileWriter fw = new FileWriter(file); // argumentos: File ou String
			fw.write("Thiago\n"); // \n é um scape para quebra de linha pois não a recursos nessa classe para isso
			fw.write("Fonseca");
			fw.flush(); //faz com que os dados do stream sejam escritos de fato no arquivo
						//e liberado o buffer
			fw.close(); //libera recursos do sistema
			
			FileReader fr = new FileReader(file); // argumentos: File ou String
			char[] read = new char[50]; 
			int size = fr.read(read); // retorna a quantidade de char's lidas
									  // armazena no array de char read
			System.out.println(size);
			for (char a : read) {
				System.out.print(a);
			}
			fr.close();
			//os recursos aqui são limitados e de dificil uso
			//existe a limitação de um array para receber a leitura
			//essas classes devem ser encapsuladas por classe de mais alto nivel
			file.delete();
			
			System.out.println();
			System.out.println("TESTE BufferedWriter E BufferedReader");
			FileWriter fwBuffered = new FileWriter(file2);// argumentos: File ou String
			BufferedWriter bw = new BufferedWriter(fwBuffered); //SOMENTE RECEBE WRITERS
			bw.write("Thiago");
			bw.newLine();
			bw.write("Fonseca");
			bw.flush();
			bw.close();
			
			FileReader frBuffered = new FileReader(file2);// argumentos: File ou String
			BufferedReader br = new BufferedReader(frBuffered); //SOMENTE RECEBE READERS
			//System.out.println("qntidade de caracteres:"+br.read()); //usado da mesma forma que um FileReader;
			String b;
			while ((b = br.readLine()) != null) {
				System.out.println(b);
			}
			br.close();
			
			System.out.println("TESTE PrintWriter");
			//PrintWriter pode receber qualquer Writer, ou File/String
			FileWriter fwPrint = new FileWriter("printTeste.txt");// argumentos: File ou String
			PrintWriter pw = new PrintWriter(fwPrint);
			//PrintWriter pw = new PrintWriter(new File("printTeste.txt")); valido
			//PrintWriter pw = new PrintWriter(printTeste.txt); valido
			//PrintWriter pw = new PrintWriter(new OutputStream("printTexte.txt")); valido
			
			pw.println("Thiago");
			pw.println("Fonseca");
			
			//pw.write("Thiago"); valido
			//pw.println();
			//pw.write("Fonseca"); valido			
			
			pw.flush();
			pw.close();
			
			FileReader frPrint = new FileReader("printTeste.txt");
			BufferedReader brPrint = new BufferedReader(frPrint); //SOMENTE RECEBE READERS
			String c;
			while ((c = brPrint.readLine()) != null) {
				System.out.println(c);
			}
			brPrint.close();
			
			//A partir do java5 PrintWriter tem metodos: append(),format(),printf()
			
			/*System.out.println("TESTE Console");
			
			Console console = System.console(); // instanciando um console
			char[] password = console.readPassword("%s","pw: "); //le e retorna array de char
			for (char charP : password ) {
				console.format("%c", charP);
			}
			String nome = console.readLine("%s","login:");
			console.format("%s", nome);*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
