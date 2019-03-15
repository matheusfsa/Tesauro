package tesauro.analysis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Identificador {
	private String nome;
	private String tipo;
	private boolean init;
	private boolean is_prog;
	public Identificador(String nome, String tipo, boolean init, boolean is_prog) {
		this.nome = nome;
		this.tipo = tipo;
		this.init = init;
		this.is_prog = is_prog;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isInit() {
		return init;
	}
	public void setInit(boolean init) {
		this.init = init;
	}
	public boolean isIs_prog() {
		return is_prog;
	}
	public void setIs_prog(boolean is_prog) {
		this.is_prog = is_prog;
	}
	@Override
	public int hashCode() {
		int n = nome.length();
		int h = 0;
		double alpha = 137;
		for(int i = 0; i < n; i++) {
			h += Math.pow(alpha, n - i)*nome.charAt(i);
		}
		
		return Math.abs(h);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
	public static void main(String[] args) {
		HashMap<Identificador, Identificador> hs = new HashMap<>();
		Identificador id = new Identificador("sdaso", "int", false, false);
		Identificador id1 = new Identificador("dskdks", "int", false, false);
		Identificador id2 = new Identificador("sd,dsl", "int", false, false);
		Identificador id3 = new Identificador("dskd", "int", false, false);
		Identificador id4 = new Identificador("lskl", "int", false, false);
		Identificador id5 = new Identificador("cafsfs", "int", false, false);
		Identificador id6 = new Identificador("asd", "int", false, false);
		Identificador id7 = new Identificador("kdskdsl", "int", false, false);
		Identificador id8 = new Identificador("bsd", "int", false, false);
		hs.put(id, id);
		hs.put(id1,id1);
		hs.put(id2,id2);
		hs.put(id3,id3);
		hs.put(id4,id4);
		hs.put(id5,id5);
		hs.put(id6,id6);
		hs.put(id7,id7);
		 // creating set view for hash table 
        Set s = hs.entrySet(); 
  
        // printing set entries 
        System.out.println("set entries: " + s); 
		System.out.println(hs.containsKey(id8));
	}
}
