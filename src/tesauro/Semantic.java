package tesauro;

import java.util.ArrayList;
import java.util.List;
import tesauro.analysis.*;

import tesauro.node.*;

public class Semantic extends DepthFirstAdapter {
	private Tabela tabela;
	private String id_programa;
	public Semantic() {
		tabela =new Tabela(null);
	}
	private void erro(String msg, boolean para) {
		if(para) {
			System.err.println("Erro: " + msg);
			System.exit(0);
		}else {
			System.err.println("Warning: " + msg);
		}
	}
	@Override
    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
		if(node instanceof ABloco) {
        	System.out.println("-------------------------------------------------");
        	System.out.println("Hash: " + tabela);

          
        	
    		tabela = tabela.getNext();
    	}
    	
    }
	@Override
	public void defaultIn(Node node) {
		if(node instanceof ABlocoCmd || node instanceof ABlocoCmdNoShortIct) 
				tabela = new Tabela(tabela);
	}
	@Override
	public void inStart(Start node)
	    {
		   System.out.println("-------------------------------------------------");
		   System.out.println("Iniciando análise semântica...");
	    }
	
	@Override
	public void outStart(Start node){
	    System.out.println("-------------------------------------------------");
        System.out.println("Fim da análise semântica");
        System.out.println("-------------------------------------------------");
	}
@Override
 	public void inAPrograma(APrograma node){
		id_programa =node.getId().toString();
        defaultIn(node);
    }
	@Override
	public void outAPrograma(APrograma node) {
		defaultOut(node);
	}
//EXP
	private String getTipo(PExp node) {
		String tipo_l;
		String tipo_r;
		if(node instanceof AMenorExp || node instanceof AMenorIExp || node instanceof AMaiorExp || 
				node instanceof AMaiorIExp || node instanceof AIgualExp || node instanceof ADiffExp || 
				node instanceof AOrExp || node instanceof AAndExp || node instanceof AXorExp || node instanceof ANotExp) 
			return "integer";
		if(node instanceof ASymValExp) {
			return "symbol";
		}
		if(node instanceof ASymVecValExp) {
			return "symbol";
		}
		
		if(node instanceof AIntValExp) {
			return "integer";
		}
		if(node instanceof ARealValExp) {
			return "real";
		}
		if(node instanceof AMinusExp) {
			AMinusExp no = (AMinusExp)node;
			tipo_l = getTipo(no.getLeft());
			tipo_r = getTipo(no.getRight());
			if(tipo_l.equals("real") || tipo_r.equals("real"))
				return "real";
			else 
				return "integer";
		}
		if(node instanceof ASumExp) {
			ASumExp no = (ASumExp)node;
			tipo_l = getTipo(no.getLeft());
			tipo_r = getTipo(no.getRight());
			if(tipo_l.equals("real") || tipo_r.equals("real"))
				return "real";
			else 
				return "integer";
		}
		if(node instanceof AMultExp) {
			AMultExp no = (AMultExp)node;
			tipo_l = getTipo(no.getLeft());
			tipo_r = getTipo(no.getRight());
			if(tipo_l.equals("real") || tipo_r.equals("real"))
				return "real";
			else 
				return "integer";
		}
		if(node instanceof ADivExp) {
			ADivExp no = (ADivExp)node;
			tipo_l = getTipo(no.getLeft());
			tipo_r = getTipo(no.getRight());
			if(tipo_l.equals("real") || tipo_r.equals("real"))
				return "real";
			else 
				return "integer";
		}
		if(node instanceof AModExp) {
			AModExp no = (AModExp)node;
			tipo_l = getTipo(no.getLeft());
			tipo_r = getTipo(no.getRight());
			if(tipo_l.equals("real") || tipo_r.equals("real"))
				return "real";
			else 
				return "integer";
		}
		if(node instanceof AMinUnExp) {
			AMinUnExp no = (AMinUnExp)node;
			tipo_l = getTipo(no.getExp());
			return tipo_l;
		}
		if(node instanceof AVarExp) {
			AVarExp no = (AVarExp)node;
			Identificador id = tabela.get(new Identificador(no.toString()));
			return id.getTipo();
		}
		return null;


			
	}
	private boolean isVec(PExp node) {
		if(node instanceof AVarExp) {
			AVarExp no = (AVarExp)node;
			Identificador id = tabela.get(new Identificador(no.getId().toString()));
			return id.isVetor() && no.getExp().size()==0;
		}
		return false;
	}
	private  int compativel(PExp node) {
		/**
		 * -1: erro
		 * 0: warning
		 * 1: show
		 */
		String tipo_l;
		String tipo_r;
		if(node instanceof AMenorExp || node instanceof AMenorIExp || node instanceof AMaiorExp || 
				node instanceof AMaiorIExp || node instanceof AIgualExp || node instanceof ADiffExp || 
				node instanceof AOrExp || node instanceof AAndExp || node instanceof AXorExp || node instanceof ANotExp)
			return 1;
		if(node instanceof AMinusExp) {
			AMinusExp no = (AMinusExp)node;
			if(isVec(no.getLeft()) || isVec(no.getRight()) ) 
				return -1;
			return 1;
		}
		if(node instanceof ASumExp) {
			ASumExp no = (ASumExp)node;
			if(isVec(no.getLeft()) || isVec(no.getRight()) ) 
				return -1;
			return 1;
		}
		if(node instanceof ADivExp) {
			ADivExp no = (ADivExp)node;
			if(isVec(no.getLeft()) || isVec(no.getRight()) ) 
				return -1;
			return 1;
		}
		if(node instanceof AMultExp) {
			AMultExp no = (AMultExp)node;
			if(isVec(no.getLeft()) || isVec(no.getRight()) ) 
				return -1;
			return 1;
		}
		if(node instanceof AModExp) {
			AModExp no = (AModExp)node;
			if(isVec(no.getLeft()) || isVec(no.getRight()) ) 
				return -1;
			return 1;
		}
		if(node instanceof AMinUnExp) {
			AMinUnExp no = (AMinUnExp)node;
			if(isVec(no.getExp()) ) 
				return -1;
			return 1;
		}
		return 1;
		
	}
	@Override
	public void outAVarDeclaracao(AVarDeclaracao node) {

		List<TId> copy = new ArrayList<TId>(node.getLista());
		
        boolean res;
        String tipo;
        boolean is_vetor = false;
        if(node.getTipo() instanceof ACompostoTipo) {
			ACompostoTipo a_tipo = (ACompostoTipo)node.getTipo();
			tipo = a_tipo.getTipo().toString();
			is_vetor = true;
        }else {
        	tipo = node.getTipo().toString();
        }
        for(TId e : copy)
        {
        	if(e.toString().equals(id_programa)) {
    			erro("Constante não pode ter o mesmo identificador que o  programa", true);
    		}
        	res = tabela.add(new Identificador(e.toString(), tipo, false, false, is_vetor, false));
            
            if(!res)
            	erro("Variável já foi declarada", true);
        }
        if(node.getId().toString().equals(id_programa)) {
			erro("Constante não pode ter o mesmo identificador que o  programa", true);
		}
        res = tabela.add(new Identificador(node.getId().toString(), tipo, false, false, is_vetor, false));
        if(!res)
        	erro("Variável já foi declarada", true);
	}
	@Override
	public void outAConstanteDeclaracao(AConstanteDeclaracao node) {
		
        boolean res;
        if(node.getId().toString().equals(id_programa)) {
			erro("Variável não pode ter o mesmo identificador que o  programa", true);
		}
		if(node.getTipo() instanceof ACompostoTipo) {
			ACompostoTipo tipo = (ACompostoTipo)node.getTipo();
												//nome, tipo, init, prog, vetor, constante
			res = tabela.add(new Identificador(node.getId().toString(), tipo.getTipo().toString(), false, false, true, true));
			if(!res)
				erro("Variável já foi declarada", true);
		}else {
												//nome, tipo, init, prog, constante
			res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), false, false, false, true));
			if(!res)
				erro("Variável já foi declarada", true);
		}
       
       
	}
	@Override
	public void outAConstAttDeclaracao(AConstAttDeclaracao node) {

		boolean res;
		if(node.getId().toString().equals(id_programa)) {
			erro("Constante não pode ter o mesmo identificador que o  programa", true);
		}
		if(node.getTipo() instanceof ACompostoTipo) {
			ACompostoTipo tipo = (ACompostoTipo)node.getTipo();
												//nome, tipo, init, prog, vetor, constante
			res = tabela.add(new Identificador(node.getId().toString(), tipo.getTipo().toString(), true, false, true, true));
			if(!res)
				erro("Variável já foi declarada", true);
		}else {
												//nome, tipo, init, prog, vetor, constante
			res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), true, false, false, true));
			if(!res)
				erro("Variável já foi declarada", true);
		}
       
	}
	@Override
    public void outAVarExp(AVarExp node) {
		if(node.getId().toString().equals(id_programa)) {
			erro("Variável não pode ter o mesmo identificador que o  programa", true);
		}
		Identificador id = tabela.get(new Identificador(node.getId().toString()));
		if(id == null)
			erro("Variável " + node.getId() +"não foi declarada", true);
    }
    public void outExp(PExp node) {
		if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
	}
    @Override
    public void outAAndExp(AAndExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", true);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", true);
    	}
    	
    }
    @Override
    public void outADiffExp(ADiffExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outADivExp(ADivExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAIgualExp(AIgualExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMaiorExp(AMaiorExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMaiorIExp(AMaiorIExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMenorExp(AMenorExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMenorIExp(AMenorIExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMinusExp(AMinusExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAModExp(AModExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMultExp(AMultExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAOrExp(AOrExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outASumExp(ASumExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAXorExp(AXorExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getLeft() instanceof AVarExp) {
    		AVarExp left = (AVarExp)node.getLeft();
    		Identificador id = tabela.get(new Identificador(left.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	if(node.getRight() instanceof AVarExp) {
    		AVarExp right = (AVarExp)node.getRight();
    		Identificador id = tabela.get(new Identificador(right.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    @Override
    public void outAMinUnExp(AMinUnExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getExp() instanceof AVarExp) {
    		AVarExp exp = (AVarExp)node.getExp();
    		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    	
    }
    @Override
    public void outANotExp(ANotExp node) {
    	if(compativel(node)  == -1) 
			erro("Tipos incompatíveis", true);
    	if(node.getExp() instanceof AVarExp) {
    		AVarExp exp = (AVarExp)node.getExp();
    		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
    }
    private boolean isVector(PExp node) {
    	if(node instanceof AVarExp)
    		return ((AVarExp)node).getExp().size()>0;
    	return false;
    }
	@Override
	public void outAAttVarCmdSemCmd(AAttVarCmdSemCmd node) {
		// TODO Auto-generated method stub
		AVarExp left = (AVarExp) node.getLeft();
		Identificador id = tabela.get(new Identificador(left.getId().toString()));
		
		if(id.isConstante())
			erro("Esse tipo de atribuição não é permitido para constantes", true);
		if(!isVector(node.getLeft()) && id.isVetor()) {
			erro("Esse tipo de atribuição não é permitido para vetores", true);
		}
		
		id.setInit(true);
		tabela.altera(id);
	}
	
	@Override
	public void outAAttConstCmdSemCmd(AAttConstCmdSemCmd node) {
		AVarExp left = (AVarExp) node.getLeft();
		Identificador id = tabela.get(new Identificador(left.getId().toString()));
		if(!id.isConstante()) {
			erro("Esse tipo de atribuição não é permitido para variáveis", true);
		}
		if(id.isInit()) {
			erro("O valor da constante " + id.getNome() + " não pode ser alterado", true);
		}
		id.setInit(true);
		tabela.altera(id);
		
		super.outAAttConstCmdSemCmd(node);
	}
	@Override
	public void outACaptureCmdSemCmd(ACaptureCmdSemCmd node) {
		AVarExp exp = (AVarExp) node.getExp();
		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
		if(id.isConstante() && id.isInit()) {
			erro("O valor da constante " + id.getNome() + " não pode ser alterado", true);
			
		}
		id.setInit(true);
		tabela.altera(id);
		List<PExp> rest = node.getLista();
		for (PExp pExp : rest) {
			AVarExp e = (AVarExp)pExp;
			id = tabela.get(new Identificador(e.getId().toString()));
			if(id.isConstante() && id.isInit()) {
				erro("O valor da constante " + id.getNome() + " não pode ser alterado", true);
			}
			id.setInit(true);
			tabela.altera(id);
			
		}
	}
	public void verificaVariavel(PExp exp) {
		if(exp instanceof AVarExp) {
			AVarExp e = (AVarExp)exp;
			Identificador id = tabela.get(new Identificador(e.getId().toString()));
			if(id.isConstante())
				erro("A variável não pode ser uma constante", true);
		}
	}
	@Override
	public void inAConsideringIterationCmd(AConsideringIterationCmd node) {
		AVarExp var = (AVarExp)node.getI();
		
		if(var.toString().equals(id_programa)) {
			erro("Variável não pode ter o mesmo identificador que o  programa", true);
		}
		Identificador id = tabela.get(new Identificador(var.getId().toString()));
		if(id == null)
			erro("Variável " + var.getId() +"não foi declarada", true);
		if(id.isVetor() && var.getExp().size() == 0) {
			erro("A variável "+ var.getId() +"não pode ser um vetor", true);
		}
		if(id.isConstante()) {
			erro("A variável "+ var.getId() +" não pode ser uma consante", true);
		}
		id.setInit(true);
		tabela.altera(id);
	}
	@Override
	public void inAConsideringIterationCmdNoShortIct(AConsideringIterationCmdNoShortIct node) {
		AVarExp var = (AVarExp)node.getI();
		
		if(var.toString().equals(id_programa)) {
			erro("Variável não pode ter o mesmo identificador que o  programa", true);
		}
		Identificador id = tabela.get(new Identificador(var.getId().toString()));
		if(id == null)
			erro("Variável " + var.getId() +"não foi declarada", true);
		if(id.isVetor() && var.getExp().size() == 0) {
			erro("A variável "+ var.getId() +"não pode ser um vetor", true);
		}
		if(id.isConstante()) {
			erro("A variável "+ var.getId() +" não pode ser uma consante", true);
		}
		id.setInit(true);
		tabela.altera(id);
	}
}
