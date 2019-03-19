package tesauro;

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
		hash.put(id.hashCode(), id);
		return true;
	}
	public int size() {
		if(next == null) {
			return 1;
		}else
			return 1 + next.size();
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
	public void altera(Identificador id_new) {
		hash.replace(id_new.hashCode(), id_new);
	}
}
