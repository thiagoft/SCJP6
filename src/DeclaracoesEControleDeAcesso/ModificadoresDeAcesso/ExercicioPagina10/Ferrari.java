package DeclaracoesEControleDeAcesso.ModificadoresDeAcesso.ExercicioPagina10;

import DeclaracoesEControleDeAcesso.ModificadoresDeAcesso.ExercicioPagina10.food.Car;

public class Ferrari extends Car {
	public void teste1() {
		teste();//metodo protected de Fruit pode ser usado por causa da herança
				//todas as filhas na hierarquia de herança poderão usar o membro
		
		Car a = new Car();
		//a.teste();
		//isto não é possivel pois teste é protected ele somente pode ser acessado
		//atraves de herança
	}
}
