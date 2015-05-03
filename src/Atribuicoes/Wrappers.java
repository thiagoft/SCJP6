package Atribuicoes;

public class Wrappers {
	//Principais Metodos:
	public static void main(String[] args) {
		Integer a = new Integer("1");
		Integer b = new Integer(1);
		int d = 2;
		Integer c = new Integer(d);
		
		//Byte byteNum = new Byte(10); invalido pois 10 não é um byte e sim um int
		Byte byteNum = new Byte("1");
		
		long e = a.longValue(); //xxxValue() retornao valor convertido primitivo a partir de uma instancia
		int f = Integer.parseInt("1"); //parsexxx(String a) recebe uma string e retorna um primitivo
		int i = Integer.parseInt("1010",2);//parsexxx(String a,int base) pode ser passado a base para conversão
		//2 = binaria; 8 = octal; 16 = hexadecimal
		Integer g = Integer.valueOf("1"); //valueOf(String a) recebe uma string e retorna um wrapper
		Integer h = Integer.valueOf(1); //valueOf(int a) recebe um primitivo e retorna um wrapper
		int j = Integer.valueOf("1010",2);//valueOf(String a,int base) pode ser passado a base para conversão
		
		Integer integerObj = 1;
		Integer integerObj3 = 1;
		Integer integerObj2 = new Integer(1);
		int intPrimitivo = 1;
		Byte byteObj = 1;
		Long longObj = 1L;
		
		System.out.println(integerObj == integerObj2); //false pois apontam para objetos diferentes e esta utilizando comparação por == que compara objetos
		System.out.println(integerObj == intPrimitivo); //true pois quando comparado com um primitivo e ==, Integer faz unboxing e a comparação é entre primitivos
		//System.out.println(integerObj == byteObj); não compila pois na comparação == o tipo de referencia diferente gera erro de compilação 
		System.out.println(integerObj.equals(integerObj2)); //true pois os objetos são iguais e é feita a comparação de valores 
		System.out.println(integerObj.equals(longObj)); //false pois os tipos de referencia são diferentes
		System.out.println(integerObj.equals(byteObj)); //false pois os tipos de referencia são diferentes
		System.out.println(integerObj.equals(1)); //true pois nesse caso o primitivo gera autoBoxing para object
		
		//Importante
		//testeLong(integerObj); erro de compilação pois não faz alongamento de Wrappers
		//testeInteger(longObj); erro de compilaçãio pois não faz estreitamento de Wrappers
		testeInt(byteObj); //é feito o unboxing são permitidos alongamento
		//testeLong(intPrimitivo); erro de compilação pois é feito o boxing de int para Integer porem não é feito alongamento ou estreitamento de Wrappers
		
		System.out.println(integerObj == integerObj3); //true nesse caso quando é atribuido um primitivo literal a um Integer
													   //por meio de boxing então de -128 a 127 eles serão iguais
		
		Integer m = new Integer(1) + new Integer(2);
		int k = new Integer(1) + new Integer(2);
		int l = new Integer(1) + new Byte("2"); 
		//int gk = new Integer(1) + new Long("2"); não compila se a referencia do resultado for < long
		long gsk = new Integer(1) + new Long("2"); 
	}
	
	static void testeLong(Long l) {}
	static void testeInteger(Integer i) {}
	static void testeInt(int i) {}
}
