package DeclaracoesEControleDeAcesso;

enum CoffeeSize {
	BIG,HUGE,OVERHELMING
	//não podem ser private ou protected
}

public class Enums {
	//Enuns podem ser declarados fora ou dentro de uma classe, mas não em um método;
	//Um enum somente pode ser declarado como default ou public;
	//Enums implementam por padrão equasl() e hashCode()
	//logo pode ser comparado com == ou equals()
	//o construtor de um enum não pode acessar uma variavei static que n seja final
	
	public static void main(String[] args) {
		CoffeeSize a = CoffeeSize.BIG;
		CoffeeSize b = CoffeeSize.HUGE;
		CoffeeSize c = CoffeeSize.OVERHELMING;
		System.out.println(CoffeeSize.BIG); //BIG
		System.out.println(CoffeeSize.HUGE); //HUGE
		System.out.println(CoffeeSize.OVERHELMING); //OVERHELMING
		
		System.out.println(CoffeeSize.values()); //retorna um Array com os itens do enum
	}
	
}

class EnumDentroDeUmaClasse {
	enum Tamanho {PEQUENO,MEDIO,GRANDE}//; - ponto e virgula pode existir ou não
	
	Tamanho tamanho;
}

class TestandoEnumDentroDeUmaClasse {
	public static void main(String[] args) {
		EnumDentroDeUmaClasse obj = new EnumDentroDeUmaClasse();
		
		obj.tamanho = EnumDentroDeUmaClasse.Tamanho.GRANDE;
					  //como o enum dentro de uma classe deve ser chamado
	}
}

//TESTE DE ENUMS COM CORPO
enum TamanhoDeCafe {
	
	//constantes passando valor ao contrutor
	PEQUENO(100),
	MEDIO(200){ //adiciona um corpo para sobrescrever os metodos do Enum
		public String getString() {
			return "A";
		}
	},
	GRANDE(300);
	
	//construtor
	TamanhoDeCafe(int tamanho) {
		this.tamanho = tamanho;
	}
	
	//variavel de instancia
	private int tamanho;

	public int getTamanho() {
		return tamanho;
	}

	public String getString() {
		return "B";
	}
	
}

class TestandoEnumComCorpo {
	
	TamanhoDeCafe tamanho;
	
	public static void main(String[] args) {
		TestandoEnumComCorpo obj = new TestandoEnumComCorpo();
		obj.tamanho = TamanhoDeCafe.PEQUENO;
		
		System.out.println(obj.tamanho);
		System.out.println(obj.tamanho.getTamanho());
		System.out.println(obj.tamanho.getString());
		
		for (TamanhoDeCafe objIterado : TamanhoDeCafe.values()) {
			System.out.println(objIterado);
			System.out.println(objIterado.getTamanho());
			System.out.println(objIterado.getString());
		}
	}
}
