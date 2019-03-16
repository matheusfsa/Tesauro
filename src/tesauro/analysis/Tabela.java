package tesauro.analysis;

import java.util.Hashtable;

public class Tabela {
	private Hashtable<Integer, Identificador> hash;
	private Tabela next;
	public Tabela(Tabela next) {
		this.hash = new Hashtable<>();
		this.next = next;
	}
	public boolean contains(Identificador id) {
		if(hash.contains(id)) {
			return true;
		}else {
			if(next == null)
				return false;
			else
				return next.contains(id);
		}
	}
	public boolean add(Identificador id) {
		Identificador res = get(id);
		if(res != null && res.getTipo().equals(id.getTipo()))
			return false;
		System.out.println("Inserindo " + id + "na tabela");
		hash.put(id.hashCode(), id);
		return true;
	}
	public Identificador get(Identificador id) {
		Identificador res = hash.get(id.hashCode());
		if(res == null) {
			if(next != null)
				return next.get(id);
			else
				return null;
		}
		return res;
		
	}
	public Tabela getNext() {
		return this.next;
	}
	
	@Override
	public String toString() {
		if(next == null)
			return hash.toString();
		else
			return hash.toString() + "<-" + next.toString();
	}
}
