package Testes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TesteDeConsistenciaEqualsHash {
	public static void main(String[] args) {
		TesteEquals a = new TesteEquals();
		TesteEquals b = new TesteEquals();
		System.out.println(a.equals(b));
		System.out.println(a.hashCode() == b.hashCode());
		
		Map<TesteEquals,String> teste = new HashMap<TesteEquals,String>();
		teste.put(a,"Teste1");
		teste.put(b,"Teste2");
		
		TesteEquals c = new TesteEquals();
		System.out.println(teste.get(c));
		System.out.println(teste.get(b));
	}
}

class TesteEquals{
	
	public String item = "Thiago";

	@Override
	public int hashCode() {
		return this.item.length() *2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteEquals other = (TesteEquals) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	
}

class TesteEquals2 {
	
	public String item = "Thiago";

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TesteEquals other = (TesteEquals) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
}
