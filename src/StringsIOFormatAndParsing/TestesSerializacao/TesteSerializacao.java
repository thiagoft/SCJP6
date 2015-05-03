package StringsIOFormatAndParsing.TestesSerializacao;

import java.io.*;

public class TesteSerializacao {
	public static void main(String[] args) {
		System.out.println("Teste Simples de Serialização");
		Cat cat = new Cat();
		try {
			FileOutputStream fos = new FileOutputStream("cat.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(cat);
			oos.close();
			
			FileInputStream fis = new FileInputStream("cat.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				Cat catSerializado = (Cat) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				ois.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Teste Detalhado de Serialização com membros não Serializaveis");
		Dog dog = new Dog("Rex"); // implementa Serializable
		Coleira coleira = new Coleira("Cão Legal",1); // não implementa Serializable
		//nesse caso coleira não iria deixar que puddle fosse serializado, pois coleira não
		//é serializable (Lançara NotSerializableException), para resolver isso o 
		//atributo coleira de puddle deve ser marcado
		//como transient, LOGO, ele não será serializado voltará ao valor padrão
		//quando dog for deserializado
		Puddle puddle = new Puddle(dog,1,coleira); // implementa Serializable
		System.out.println(puddle);
		try {
			FileOutputStream fos2 = new FileOutputStream("puddle.ser");
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
			oos2.writeObject(puddle);
			oos2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Puddle puddleDeserializado;
		try {
			FileInputStream fis2 = new FileInputStream("puddle.ser");
			ObjectInputStream ois2 = new ObjectInputStream(fis2);
			puddleDeserializado = (Puddle) ois2.readObject();
			ois2.close();
			System.out.println(puddleDeserializado);
			//retornaria "Dog name:Rex de 1 anos com a identificação: null"
			//caso Puddle não sobrescrevesse writeObject() e readObject()
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Teste Detalhado de Serialização com SuperClass não serializavel");
		Cat cat2 = new Cat("Garfield",1);
		//Cat extends Animal, porem Animal não implementa Serializable e Cat sim
		//Animal tem o valor da variavel age inicializada em 4
		//Classes Serializadas não rodam o construtor;
		//Elas inicializam suas variaveis atribuidas por default ou literalmente
		//ex: em Animal: private int age = 4;
		//ou private Object obj; será atribuido o default null
		//ou private double num; será atribuido o default 0.0
		
		//OBSERVAÇÕES IMPORTANTES: 
		//-para um Array ser serializavel, seus elementos devem
		//implementar Serializable, caso contrario a serialização falhará
		
		//-Se a superclasse implementa Serializable, suas subclasses também a
		//implementarão implicitamente
		
		//-Membros Staticos não são serializaveis, pois a serialização trata-se de 
		//objetos, ou seja instancia de uma classe. Elas NUNCA são salvas, pois não
		//fazem parte do estado do objeto
		
		System.out.println(cat2);//nome: Garfield idade:1
		try {
			FileOutputStream fos3 = new FileOutputStream("newCat.ser");
			ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
			oos3.writeObject(cat2);
			oos3.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis3 = new FileInputStream("newCat.ser");
			ObjectInputStream ois3 = new ObjectInputStream(fis3);
			cat2 = (Cat) ois3.readObject();
			ois3.close();
			System.out.println(cat2);//nome: Garfield idade:4
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
