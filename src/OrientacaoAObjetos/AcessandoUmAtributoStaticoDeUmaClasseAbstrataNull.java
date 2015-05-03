package OrientacaoAObjetos;

class Mountain {
	static String name = "Himalaya";
	static Mountain getMountain() {
		System.out.println("Getting Name ");
		return null;
	}
	
	public static void executa() {
		System.out.println(getMountain().name);
		//mesmo Mountain retornando uma referencia null de Mountain
		//a variavel statica name pode ser acessada.
		//logo imprimira:
		//Getting Name
		//Himalaya
	}
}

public class AcessandoUmAtributoStaticoDeUmaClasseAbstrataNull {
	public static void main(String[] args) {
		Mountain.executa();
	}
}
