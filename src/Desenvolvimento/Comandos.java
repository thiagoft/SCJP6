package Desenvolvimento;

public class Comandos {
	//estrutura de comandos prompt
	//javac [opções] [arquivos-fonte]
	
	//-d (destino) - diz onde os .class serão salvos, por default eles são salvos no
	//mesmo pacote em que o .java estiver
	//ex:
	//cd myProject
	//java -d classes source/MyClass.java
	
	//estando em myProject, adicionar em classes, MyClass.java que esta em source
	
	//em uma estrutura mais elaborada e na conversão  ".." volta diretorios
	
	//java [opcoes] classe [argumentos]
	//a opção -D adiciona propriedades à execução
	//ex:
	//java -DmyProp=Testando Comandos
	//nesse caso
	//Properties p= System.getProperties(); p.getPropertie("myProp"); retornara Testando
	//caso queira colocar string compostas... deve ser adicionado ""
	//ex:
	//java -DmyProp="Testando essa Parada" Comandos
	//que retornara Testando essa Parada para p.getProperties("myProp");
	
	//a opção -classpath especifica localização de diretórios
	//":" separa diretorios
	//ex: java -classpatch /com/foo/acct:/com/foo:.
	//OBS:não é feita a busca em diretorios acima logo se precisar dabusca em com, :/com devera
	//ser especificado, detalhe que a primeira "/" significa diretorio raiz, e "." o diretorio atual
	
	//METODO MAIN
						  //String args[]
						  //String... args	
	public static void main(String[] args) {
		
	}
}
