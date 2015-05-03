package DeclaracoesEControleDeAcesso;

public class ParametroVarArgs {
	
	//VAR ARGS ACEITAM NENHUM OU VARIOS ARGUMENTOS
	void teste(int x,String...a) {
		//retorna um array do tipo
		//System.out.println(a[0]); se acessado lança java.lang.ArrayIndexOutOfBoundsException
		System.out.println(a.length);
		for (String o : a) {
			System.out.println(o);
		}
	}
	
	/*void teste1(String...a,int x) {
		//deve ser o ultimo parametro a ser declarado
	}*/
	
	/*void teste2(String...a,String...b) {
		//deve haver somente um parametro varargs
	}*/
	
	public static void main(String[] args) {
		ParametroVarArgs parametro = new ParametroVarArgs();
		parametro.teste(1);
	}
}
