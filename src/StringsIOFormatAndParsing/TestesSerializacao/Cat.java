package StringsIOFormatAndParsing.TestesSerializacao;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
	public static final String membroStatico = "souEstático e não Serializavel";
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Cat(String name, int age) {
		this.name = name;
		this.setAge(age);
		System.out.println("Cat...");
	}
	
	public Cat(){}
	
	public String toString() {
		return "nome: "+this.name+" idade:"+this.getAge();
	}
}
