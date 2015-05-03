package StringsIOFormatAndParsing.TestesSerializacao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Puddle implements Serializable {
	private Dog dog;
	private int age;
	private transient Coleira coleira; //Coleira n�o � Serializable, logo deve ser
									   //marcado como transient para ser ignorado
									   //caso contrario Puddle n�o poder� ser 
									   //Serializado
	
	public Coleira getColeira() {
		return coleira;
	}
	public void setColeira(Coleira coleira) {
		this.coleira = coleira;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Puddle(Dog dog, int age, Coleira coleira) {
		this.dog = dog;
		this.age = age;
		this.coleira = coleira;
	}
	
	//SOBRESCREVENDO writeObject()
	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeUTF(this.coleira.getNome());
			os.writeInt(this.coleira.getNumero());
			//escreve os parametros em uma ordem
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//SOBRESCREVENDO readObject()
	private void readObject(ObjectInputStream is) {
		try {
			is.defaultReadObject();
			this.coleira = new Coleira(is.readUTF(),is.readInt());
			//l� os par�metros na ordem que foram escritos
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	
	public String toString() {
		return this.dog+" de "+this.age+" anos com a identifica��o: "+this.coleira;
	}
}
