package DeclaracoesEControleDeAcesso.ModificadoresDeAcesso.ExercicioPagina10;

import DeclaracoesEControleDeAcesso.ModificadoresDeAcesso.ExercicioPagina10.food.Car;

public class Ferrari extends Car {
	public void teste1() {
		teste();//metodo protected de Fruit pode ser usado por causa da heran�a
				//todas as filhas na hierarquia de heran�a poder�o usar o membro
		
		Car a = new Car();
		//a.teste();
		//isto n�o � possivel pois teste � protected ele somente pode ser acessado
		//atraves de heran�a
	}
}
