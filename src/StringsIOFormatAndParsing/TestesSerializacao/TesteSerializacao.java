package StringsIOFormatAndParsing.TestesSerializacao;

import java.io.*;

public class TesteSerializacao {
	public static void main(String[] args) {
		System.out.println("Teste Simples de Serializa��o");
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
		
		System.out.println("Teste Detalhado de Serializa��o com membros n�o Serializaveis");
		Dog dog = new Dog("Rex"); // implementa Serializable
		Coleira coleira = new Coleira("C�o Legal",1); // n�o implementa Serializable
		//nesse caso coleira n�o iria deixar que puddle fosse serializado, pois coleira n�o
		//� serializable (Lan�ara NotSerializableException), para resolver isso o 
		//atributo coleira de puddle deve ser marcado
		//como transient, LOGO, ele n�o ser� serializado voltar� ao valor padr�o
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
			//retornaria "Dog name:Rex de 1 anos com a identifica��o: null"
			//caso Puddle n�o sobrescrevesse writeObject() e readObject()
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Teste Detalhado de Serializa��o com SuperClass n�o serializavel");
		Cat cat2 = new Cat("Garfield",1);
		//Cat extends Animal, porem Animal n�o implementa Serializable e Cat sim
		//Animal tem o valor da variavel age inicializada em 4
		//Classes Serializadas n�o rodam o construtor;
		//Elas inicializam suas variaveis atribuidas por default ou literalmente
		//ex: em Animal: private int age = 4;
		//ou private Object obj; ser� atribuido o default null
		//ou private double num; ser� atribuido o default 0.0
		
		//OBSERVA��ES IMPORTANTES: 
		//-para um Array ser serializavel, seus elementos devem
		//implementar Serializable, caso contrario a serializa��o falhar�
		
		//-Se a superclasse implementa Serializable, suas subclasses tamb�m a
		//implementar�o implicitamente
		
		//-Membros Staticos n�o s�o serializaveis, pois a serializa��o trata-se de 
		//objetos, ou seja instancia de uma classe. Elas NUNCA s�o salvas, pois n�o
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
