package DeclaracoesEControleDeAcesso;

public class DeclaracaoStatic {
	static int a = 1;
	public static void main(String[] args) {
		int a = (a= 2)*2;
		System.out.println(a);
	}
}
