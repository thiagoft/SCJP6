package Atribuicoes;

public class Wrappers {
	//Principais Metodos:
	public static void main(String[] args) {
		Integer a = new Integer("1");
		Integer b = new Integer(1);
		int d = 2;
		Integer c = new Integer(d);
		
		//Byte byteNum = new Byte(10); invalido pois 10 n�o � um byte e sim um int
		Byte byteNum = new Byte("1");
		
		long e = a.longValue(); //xxxValue() retornao valor convertido primitivo a partir de uma instancia
		int f = Integer.parseInt("1"); //parsexxx(String a) recebe uma string e retorna um primitivo
		int i = Integer.parseInt("1010",2);//parsexxx(String a,int base) pode ser passado a base para convers�o
		//2 = binaria; 8 = octal; 16 = hexadecimal
		Integer g = Integer.valueOf("1"); //valueOf(String a) recebe uma string e retorna um wrapper
		Integer h = Integer.valueOf(1); //valueOf(int a) recebe um primitivo e retorna um wrapper
		int j = Integer.valueOf("1010",2);//valueOf(String a,int base) pode ser passado a base para convers�o
		
		Integer integerObj = 1;
		Integer integerObj3 = 1;
		Integer integerObj2 = new Integer(1);
		int intPrimitivo = 1;
		Byte byteObj = 1;
		Long longObj = 1L;
		
		System.out.println(integerObj == integerObj2); //false pois apontam para objetos diferentes e esta utilizando compara��o por == que compara objetos
		System.out.println(integerObj == intPrimitivo); //true pois quando comparado com um primitivo e ==, Integer faz unboxing e a compara��o � entre primitivos
		//System.out.println(integerObj == byteObj); n�o compila pois na compara��o == o tipo de referencia diferente gera erro de compila��o 
		System.out.println(integerObj.equals(integerObj2)); //true pois os objetos s�o iguais e � feita a compara��o de valores 
		System.out.println(integerObj.equals(longObj)); //false pois os tipos de referencia s�o diferentes
		System.out.println(integerObj.equals(byteObj)); //false pois os tipos de referencia s�o diferentes
		System.out.println(integerObj.equals(1)); //true pois nesse caso o primitivo gera autoBoxing para object
		
		//Importante
		//testeLong(integerObj); erro de compila��o pois n�o faz alongamento de Wrappers
		//testeInteger(longObj); erro de compila��io pois n�o faz estreitamento de Wrappers
		testeInt(byteObj); //� feito o unboxing s�o permitidos alongamento
		//testeLong(intPrimitivo); erro de compila��o pois � feito o boxing de int para Integer porem n�o � feito alongamento ou estreitamento de Wrappers
		
		System.out.println(integerObj == integerObj3); //true nesse caso quando � atribuido um primitivo literal a um Integer
													   //por meio de boxing ent�o de -128 a 127 eles ser�o iguais
		
		Integer m = new Integer(1) + new Integer(2);
		int k = new Integer(1) + new Integer(2);
		int l = new Integer(1) + new Byte("2"); 
		//int gk = new Integer(1) + new Long("2"); n�o compila se a referencia do resultado for < long
		long gsk = new Integer(1) + new Long("2"); 
	}
	
	static void testeLong(Long l) {}
	static void testeInteger(Integer i) {}
	static void testeInt(int i) {}
}
