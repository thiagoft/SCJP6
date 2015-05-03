package OrientacaoAObjetos.TestePolimorfismo;

public class Uno extends Car {
	
	public void teste2() {
		
	}

	public static void main(String[] args) {
		
		//somente pode acessar os metodos de car ou seus proprios metodos sobrescritos em Uno
		Car a = new Uno();
		//logo o codigo abaixo é inválido
		//a.teste2();
		
	}
	
}
