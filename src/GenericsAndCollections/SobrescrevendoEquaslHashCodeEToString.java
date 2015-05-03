package GenericsAndCollections;

public class SobrescrevendoEquaslHashCodeEToString {
	
	public String teste = "";
	
	public static void main(String[] args) {
		//IMPORTANTE: tanto toString() equals() e hashCode() são publics
		// == compara referências
		// equals() compara objetos
		
		//Se equals não for sobrescrito não será possivel usar sua classe em uma
		//tabela de hash e não terá sets precisos, pelo fato de que quando equals()
		//não é sobrescrito utiliza-se o padrão da classe Object, que utiliza a referencia
		//como comparação, logo 2 objetos diferentes mesmo com os atributos com valores identicos
		//nunca terão a mesma referência ou seja nunca serão ==
		
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
		//por se tratar de um parametro Object, é ideal que se teste o objeto
		//com instanceof pois caso o object n tenha a instancia comparada vc terá um
		//erro ClassCastException na segunda expressão,
		//confirmado que o object possui uma instancia de sua classe
		//é necessário fazer o cast para ter acesso direto aos membros da classe
		//pois object não terá acesso aos membros da classe filha,
		//para depois fazer a comparação
		
		if ((o instanceof SobrescrevendoEquaslHashCodeEToString) &&
			(((SobrescrevendoEquaslHashCodeEToString) o).teste == this.teste) ) {
			return true;
		} else {
			return false;
		}
		
		//REGRAS DE CONTRATO DE EQUALS
		//reflexivo - para qualquer valor de referência de x, x.equals() deve retornar true
		//simétrico - x.equals(y) == true; então y.equals(x) deve ser true
		//transitivo - x.equals(y) == true; y.equals(z) == true então z.equals(x) deve ser true
		//consistente - se x.equals(y) == true; então sempre será true;
		//se x != null; x.equals(null) sempre será false;
	}
	
	//sobrescrevendo toString(), este é o valor que será retornado quando
	//o objeto quiser ser impresso, System.out.println(object) ou System.out.println(object.toString())
	public String toString() {
		return "Valores:"+this.teste;
	}
	
	//HASHCODE - são os codigos usados como referencia a um container, normalmente
	//uma collection Hash ou um Map, são codigos otimizadores para que coleções possam,
	//ser mais performaticas, ou seja, ter faceis referencias de onde procurar um objeto
	
	//sobrescrevendo hashCode()
	public int hashCode() { //deve ser public, e não possui argumentos, e retorna um int
		return (this.teste.length() * 17);
		//se o metodo equals diz que o valor de teste deve ser igual a outro valor de teste
		//então hashCode() para os dois objetos deve ser o mesmo
		//porem se:
		//return 1000;
		//seria também correto, dous objetos com o mesmo valor de teste, retornariam o 
		//mesmo valor de hash, porem o mesmo aconteceria com valores diferentes,
		//logo em todos objetos seriam armazenados no mesmo container, e teriam que ser
		//comparados por equals, tornando o codigo hash totalmente ineficiente, porem correto
		
	}
	
	//CONTRATO HASHCODE
	//-deve ser consistente, se o mesmo objeto com os mesmo valores de atributos,
	//for testado por seu hashCode(), ele sempre deve consistentemente retornar o mesmo
	//valor
	//-se x.equals(y) então x.hashCode() == y.hashCode()
	//-se x.equals(y) == false, x.hashCode() == y.hashCode() pode ser false ou true
	//exemplo: se o codigo hash seja implementado de forma que seu retorno seja a quantidade
	//dos valores de um nome. Alex retornaria 4 e Vick retornaria 4. logo true, porem 
	//false para "Alex".equals("Vick");
	
	//RESUMIDAMENTE
	//se x.equals(y) == true // (x.hashCode() == y.hashCode()) será true
	//se (x.hashCode() == y.hashCode()) retornar true // x.equals(y) pode ser true ou false
	//se x.equals(y) == false // (x.hashCode() == y.hashCode()) pode ser true ou false
	//se x.hashCode() != y.hashCode() // x.equasl(y) == false
	
	//OBS: VARIAVEIS TRANSIENTE NÃO SÃO APROPRIADAS PARA EQUALS E HASHCODE POREM SÃO PERMITIDAS
	
}
