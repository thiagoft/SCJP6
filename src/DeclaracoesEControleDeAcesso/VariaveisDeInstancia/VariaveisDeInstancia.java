package DeclaracoesEControleDeAcesso.VariaveisDeInstancia;

import DeclaracoesEControleDeAcesso.ModificadoresDeAcesso.ExercicioPagina10.food.Car;

public class VariaveisDeInstancia {
	
	//podem terqualquer modificador de acesso
	public int a;
	protected int b;
	int c;
	private int d;
	
	//transiente somente pode ser aplicado a variaeis de instancia
	public transient int e;
	//volatile somente pode ser aplicado a variaeis de instancia
	public volatile int g;
	
	//uma variavel de instancia final deve ser inicializada
	//ela nunca se modificará
	public final int f = 1;
	
	//caso seja um objeto, o objeto referido nunca será modificado
	//podem seus valores de membros podem ser modificados
	public final Car car = new Car();
	

}
