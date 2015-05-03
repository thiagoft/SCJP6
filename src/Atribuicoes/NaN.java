package Atribuicoes;

public class NaN {
	public static void main(String[] args) {
		Float a = Float.NaN;
		Float b = Float.NaN;
		
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println(Float.NaN == Float.NaN);
		System.out.println(Float.NaN != Float.NaN);
	}
}
