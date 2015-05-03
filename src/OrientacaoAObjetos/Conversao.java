package OrientacaoAObjetos;

class Conversao2 {}

public class Conversao extends Conversao2 {
	public static void main(String[] args) {
		Conversao2 a1 = new Conversao2();
		Conversao a2 = new Conversao();
		
		a1 = a2; //não ha necessidade de caste pois Conversao é um Teste1
		a2 = (Conversao) a1; //necessita cast
	}
}
