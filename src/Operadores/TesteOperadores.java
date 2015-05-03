package Operadores;

public class TesteOperadores {
	public static void main(String[] args) {
		Short k=9;
		Integer i=9;
		Boolean b=false;
		char c='a';
		String str="123";
		System.out.println(i = (int) k.shortValue());
		System.out.println(str += b);
		System.out.println(b=!b);
		//System.out.println(c=i); invalido pois n�o �possivel converter Integer para char
		System.out.println(c+=i); // � feito o unboxing e somado
		System.out.println(c*=i); // � feito o unboxing e multiplicado
		System.out.println(i*=5);
		
		//os operadores acima so podem ser usados com variaveis a esquerda
		
		// Operador ==
		Object a = new Object();
		Object d = new Object();
		
		System.out.println(a == b); //false pois a e d referenciam objetos diferentes
		
		d = a;
		System.out.println(a == d); //true pois a e d agora referenciam o mesmo objeto
		
		//instanceof somente � usado para comparar variaveis de referencia e verifica
		//se um objeto � de um tipo especifico
		ClasseTesteInstanceOf obj = new TesteOperadores().new ClasseTesteInstanceOf();
		System.out.println(obj instanceof TesteInstanceof); //retorna true pois ClasseTesteInstanceOf
															//implementa TesteInstanceof
		
		//Incrementadores
		int item1 = 0;
		System.out.println(item1++); //imprimira 0 e logo incrementar� 0+1 
		System.out.println(++item1); //incrementara 1+1 e depois imprimira 2
		System.out.println(item1--); //imprimira 2 e logo decrementar� 2-1
		System.out.println(--item1); //decrementar� 1-1 e depois imprimira 0
		
		final int item2 = 1;
		//item2++; //n�o compilar� pois uma variavel final n�o pode ser modificada

	}
	
	interface TesteInstanceof {}
	class ClasseTesteInstanceOf implements TesteInstanceof {}
}
