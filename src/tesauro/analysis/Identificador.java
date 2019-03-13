package tesauro.analysis;

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
		
		return Math.floorMod(h, n);
	}
}
