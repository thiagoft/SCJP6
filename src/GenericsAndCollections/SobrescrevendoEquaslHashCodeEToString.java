package GenericsAndCollections;

public class SobrescrevendoEquaslHashCodeEToString {
	
	public String teste = "";
	
	public static void main(String[] args) {
		//IMPORTANTE: tanto toString() equals() e hashCode() s�o publics
		// == compara refer�ncias
		// equals() compara objetos
		
		//Se equals n�o for sobrescrito n�o ser� possivel usar sua classe em uma
		//tabela de hash e n�o ter� sets precisos, pelo fato de que quando equals()
		//n�o � sobrescrito utiliza-se o padr�o da classe Object, que utiliza a referencia
		//como compara��o, logo 2 objetos diferentes mesmo com os atributos com valores identicos
		//nunca ter�o a mesma refer�ncia ou seja nunca ser�o ==
		
		//Classe sem toString() sobrescrito
		InformacoesDVD teste = new InformacoesDVD();
		System.out.println(teste);
		System.out.println(teste.toString());
		
		//Classe com toString() sobrescrito
		SobrescrevendoEquaslHashCodeEToString obj = new SobrescrevendoEquaslHashCodeEToString();
		obj.teste = "Thiago";
		System.out.println(obj);
		System.out.println(obj.toString());
	}
	
	//sobrescrevendo equals()
	public boolean equals(Object o) { //deve ter Object no argumento
		//por se tratar de um parametro Object, � ideal que se teste o objeto
		//com instanceof pois caso o object n tenha a instancia comparada vc ter� um
		//erro ClassCastException na segunda express�o,
		//confirmado que o object possui uma instancia de sua classe
		//� necess�rio fazer o cast para ter acesso direto aos membros da classe
		//pois object n�o ter� acesso aos membros da classe filha,
		//para depois fazer a compara��o
		
		if ((o instanceof SobrescrevendoEquaslHashCodeEToString) &&
			(((SobrescrevendoEquaslHashCodeEToString) o).teste == this.teste) ) {
			return true;
		} else {
			return false;
		}
		
		//REGRAS DE CONTRATO DE EQUALS
		//reflexivo - para qualquer valor de refer�ncia de x, x.equals() deve retornar true
		//sim�trico - x.equals(y) == true; ent�o y.equals(x) deve ser true
		//transitivo - x.equals(y) == true; y.equals(z) == true ent�o z.equals(x) deve ser true
		//consistente - se x.equals(y) == true; ent�o sempre ser� true;
		//se x != null; x.equals(null) sempre ser� false;
	}
	
	//sobrescrevendo toString(), este � o valor que ser� retornado quando
	//o objeto quiser ser impresso, System.out.println(object) ou System.out.println(object.toString())
	public String toString() {
		return "Valores:"+this.teste;
	}
	
	//HASHCODE - s�o os codigos usados como referencia a um container, normalmente
	//uma collection Hash ou um Map, s�o codigos otimizadores para que cole��es possam,
	//ser mais performaticas, ou seja, ter faceis referencias de onde procurar um objeto
	
	//sobrescrevendo hashCode()
	public int hashCode() { //deve ser public, e n�o possui argumentos, e retorna um int
		return (this.teste.length() * 17);
		//se o metodo equals diz que o valor de teste deve ser igual a outro valor de teste
		//ent�o hashCode() para os dois objetos deve ser o mesmo
		//porem se:
		//return 1000;
		//seria tamb�m correto, dous objetos com o mesmo valor de teste, retornariam o 
		//mesmo valor de hash, porem o mesmo aconteceria com valores diferentes,
		//logo em todos objetos seriam armazenados no mesmo container, e teriam que ser
		//comparados por equals, tornando o codigo hash totalmente ineficiente, porem correto
		
	}
	
	//CONTRATO HASHCODE
	//-deve ser consistente, se o mesmo objeto com os mesmo valores de atributos,
	//for testado por seu hashCode(), ele sempre deve consistentemente retornar o mesmo
	//valor
	//-se x.equals(y) ent�o x.hashCode() == y.hashCode()
	//-se x.equals(y) == false, x.hashCode() == y.hashCode() pode ser false ou true
	//exemplo: se o codigo hash seja implementado de forma que seu retorno seja a quantidade
	//dos valores de um nome. Alex retornaria 4 e Vick retornaria 4. logo true, porem 
	//false para "Alex".equals("Vick");
	
	//RESUMIDAMENTE
	//se x.equals(y) == true // (x.hashCode() == y.hashCode()) ser� true
	//se (x.hashCode() == y.hashCode()) retornar true // x.equals(y) pode ser true ou false
	//se x.equals(y) == false // (x.hashCode() == y.hashCode()) pode ser true ou false
	//se x.hashCode() != y.hashCode() // x.equasl(y) == false
	
	//OBS: VARIAVEIS TRANSIENTE N�O S�O APROPRIADAS PARA EQUALS E HASHCODE POREM S�O PERMITIDAS
	
}
