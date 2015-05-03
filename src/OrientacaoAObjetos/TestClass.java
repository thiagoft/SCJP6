package OrientacaoAObjetos;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class AAA
{
	public int i = 10;
	private int j = 20;
	void teste() {
		System.out.println("1");
	}

}

class BBB extends AAA
{
	private int i = 30; //1
	public int j = 40;

	void teste() {
		System.out.println("2");
	}
}

class CCC extends BBB
{
	String test() {
		try{
			throw new Exception();
		} catch(Exception e) {
			System.out.println("teste");
			return "a";
		}finally {
			System.out.println("teste1");
			return "b"; // return em finally sempre substituirá o outros
		}
	}
}

public class TestClass
{
	/*public class AAA {
		public void m() { }
	}*/
	static String teste;
	public static void main(String args[])
	{
		CCC c = new CCC();
		//System.out.println(c.i); //2
		//System.out.println(c.j); //3
		System.out.println(c.j);
		String a = c.test();
		System.out.println(a);
		
		System.out.println(teste);
		
		//new TestClass().new AAA() { 	 public void m() { } };
		new StringBuffer("aa");
		AAA aaa = new BBB();
		aaa.teste();
	}
}

