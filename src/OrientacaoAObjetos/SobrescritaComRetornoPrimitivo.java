package OrientacaoAObjetos;

class Base {
	public short getValue() {
		return 1;
	}
	
	/*public Integer getValue2() {
		return new Byte; //wrappers não aceitam covariantes
	}*/
}
class Base2 extends Base {
	/*public Byte getValue2() { // wrappers não aceitam covariantes
		return 0;
	}*/
	
	/*public byte getValue() {
		return 2;
	}*/
	//a sobrescrita acima não compilara pois quando sobrescreve-se
	//metodos com retorno primitivo, o retorno deve ser exatamente o mesmo.
}

public class SobrescritaComRetornoPrimitivo {
	public static void main(String[] args) {
		Base b = new Base2();
		System.out.println(b.getValue());
	}
}
