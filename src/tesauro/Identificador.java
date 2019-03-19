package tesauro;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Identificador {
	private String nome;
	private String tipo;
	private boolean init;
	private boolean prog;
	private boolean vetor;
	private boolean constante;
	public Identificador(String nome, String tipo, boolean init, boolean prog, boolean vetor,boolean constante) {
		this.nome = nome;
		this.tipo = tipo;
		this.init = init;
		this.prog = prog;
		this.vetor = vetor;
		this.constante = constante;
	}
	public Identificador(String nome) {
		this.nome = nome;
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
	public boolean isprog() {
		return prog;
	}
	public void setprog(boolean prog) {
		this.prog = prog;
	}
	public boolean isVetor() {
		return vetor;
	}
	public void seVetor(boolean vetor) {
		this.vetor = vetor;
	}
	public boolean isConstante() {
		return constante;
	}
	public void setConstante(boolean constante) {
		this.constante = constante;
	}
	@Override
	public int hashCode() {
		int n = nome.length();
		int SHIFT = 4;
		int temp = 0;
		int i = 0;
		while(i < n ) {
			temp = (temp << SHIFT) + nome.charAt(i);
			i++;
		}
		return Math.abs(temp);
	}
	@Override
	public boolean equals(Object obj) {
		Identificador other = (Identificador)obj;
		return nome.equals(other.getNome());
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + nome +", " + tipo + ")";
	}
	
}
