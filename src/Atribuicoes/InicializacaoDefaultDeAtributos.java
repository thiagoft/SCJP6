package Atribuicoes;

public class InicializacaoDefaultDeAtributos {

	//Character -> de \u0000 (0) a \u007F (127)
	char teste;
	
	public static void main(String[] args) {
		InicializacaoDefaultDeAtributos a = new InicializacaoDefaultDeAtributos();
		System.out.println(a.teste); // imprime \u0000
		System.out.println(a.teste == 0); //true pois a inicialização default de char é /u0000 (0) 
	}
	
}
