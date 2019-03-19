package tesauro.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

import tesauro.node.*;

public class Semantic extends DepthFirstAdapter {
	private static String[] tipos_simples = {"integer", "symbol", "real"};
	private static ArrayList<String> t_simples = new ArrayList<>(Arrays.asList(tipos_simples)); 
	private static String[] tipos_composto = {"SymValV", "IntegerV", "RealV"};
	private static ArrayList<String> t_composto = new ArrayList<>(Arrays.asList(tipos_composto));
	private Tabela tabela;
	public Semantic() {
		tabela = new Tabela(null);
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
        // Do nothing
    	if(node instanceof PExp)
    		outExp((PExp) node);
    	else if(node instanceof ABloco || node instanceof ABlocoCmd || node instanceof ABlocoCmdNoShortIct) {
			System.out.println("Hash: " + tabela);
    		tabela = tabela.getNext();
    	}
    	
    }
	@Override
	public void defaultIn(Node node) {
		if(node instanceof ABloco || node instanceof ABlocoCmd || node instanceof ABlocoCmdNoShortIct)
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
		System.out.println("Programa");
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
		System.out.println("-------------------------------------------------");
		System.out.println("O tipo desta declaração é " + node.getTipo());
		  
		//node.getIdentificadores é a lista de nome de veriáveis. Ela é uma lista porque eu 
		//a defini desta maneira na minha gramática abstrata.
		System.out.print("Variáveis: ");
		List<TId> copy = new ArrayList<TId>(node.getLista());
		
        for(TId e : copy)
        {
      	  //e contém o token associado a cada var da lista. 
            System.out.print(e.toString());
        } 
        System.out.print(node.getId().toString());
        System.out.println();
        System.out.println("Ações a serem tomadas na tabela de símbolos:");
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
        	res = tabela.add(new Identificador(e.toString(), tipo, false, false, is_vetor, false));
            System.out.println("-->Inserir ( "+ e.toString()+", " +node.getTipo()+")");
            if(!res)
            	erro("Variável já foi declarada", true);
        }
        res = tabela.add(new Identificador(node.getId().toString(), tipo, false, false, is_vetor, false));
        if(!res)
        	erro("Variável já foi declarada", true);
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " +tipo+")");
	}
	@Override
	public void outAConstanteDeclaracao(AConstanteDeclaracao node) {
		System.out.println("-------------------------------------------------");
		System.out.println("O tipo desta declaração é " + node.getTipo());
		  
		//node.getIdentificadores é a lista de nome de veriáveis. Ela é uma lista porque eu 
		//a defini desta maneira na minha gramática abstrata. 
		System.out.print("Constantes: ");
		System.out.print(node.getId().toString());
        System.out.println();
        System.out.println("Ações a serem tomadas na tabela de símbolos:");
        boolean res;
		if(node.getTipo() instanceof ACompostoTipo) {
			ACompostoTipo tipo = (ACompostoTipo)node.getTipo();
			res = tabela.add(new Identificador(node.getId().toString(), tipo.getTipo().toString(), false, false, true, true));
			if(!res)
				erro("Variável já foi declarada", true);
	        System.out.println("-->Inserir ( "+ node.getId().toString()+", " + tipo.getTipo().toString()+" )");
		}else {
			res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), false, false, true, true));
			if(!res)
				erro("Variável já foi declarada", true);
			System.out.println("-->Inserir ( "+ node.getId().toString()+", " + node.getTipo()+")");
		}
       
        if(!res)
        	erro("Variável já foi declarada", true);
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " +node.getTipo()+")");
	}
	@Override
	public void outAConstAttDeclaracao(AConstAttDeclaracao node) {
		System.out.println("-------------------------------------------------");
		System.out.println("O tipo desta declaração é " + node.getTipo());
		System.out.print("Constantes: ");
		System.out.print(node.getId().toString());
		System.out.print("Expressão: ");
		System.out.println(node.getExp().toString());
		System.out.println("Ações a serem tomadas na tabela de símbolos: ");
		boolean res;
		if(node.getTipo() instanceof ACompostoTipo) {
			ACompostoTipo tipo = (ACompostoTipo)node.getTipo();
			res = tabela.add(new Identificador(node.getId().toString(), tipo.getTipo().toString(), true, false, true, true));
			if(!res)
				erro("Variável já foi declarada", true);
	        System.out.println("-->Inserir ( "+ node.getId().toString()+", " + tipo.getTipo().toString().replaceAll(" ", "V")+" )");
		}else {
			res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), true, false, true, true));
			if(!res)
				erro("Variável já foi declarada", true);
			System.out.println("-->Inserir ( "+ node.getId().toString()+", " + node.getTipo()+")");
		}
       
	}
	@Override
    public void outAVarExp(AVarExp node) {
		System.out.println("-------------------------------------------------");
		System.out.println("Verificar se a variável " + node.getId() + " está na tabela.");
		Identificador id = tabela.get(new Identificador(node.getId().toString()));
		if(id == null)
			erro("Variável não foi declarada", true);
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
		System.out.println("-------------------------------------------------");
		AVarExp left = (AVarExp) node.getLeft();
		Identificador id = tabela.get(new Identificador(left.getId().toString()));
		
		if(id.isConstante())
			erro("Esse tipo de atribuição não é permitido para constantes", true);
		if(!isVector(node.getLeft()) && id.isVetor()) {
			erro("Esse tipo de atribuição não é permitido para vetores", true);
		}
		
		id.setInit(true);
		tabela.altera(id);
		System.out.println("-------------------------------------------------");
	}
	
	@Override
	public void outAAttConstCmdSemCmd(AAttConstCmdSemCmd node) {
		System.out.println("-------------------------------------------------");
		AVarExp left = (AVarExp) node.getLeft();
		Identificador id = tabela.get(new Identificador(left.getId().toString()));
		if(!id.isConstante()) {
			erro("Esse tipo de atribuição não é permitido para variáveis", true);
		}
		if(id.isInit()) {
			erro("O valor de uma constante não pode ser alterado", true);
		}
		id.setInit(true);
		tabela.altera(id);
		System.out.println("-------------------------------------------------");
		
		super.outAAttConstCmdSemCmd(node);
	}
	
	public void outAIctDo(AIctDo node) {
		if(node.getExp() instanceof AVarExp) {
    		AVarExp exp = (AVarExp)node.getExp();
    		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
    		if(id == null)
    			erro("Variável não declarada", true);
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
		}
	}
	
	public void outAIctDoElse(AIctDoElse node) {
		if(node.getExp() instanceof AVarExp) {
    		AVarExp exp = (AVarExp)node.getExp();
    		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
    		if(id == null)
    			erro("Variável não declarada", true);
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
	}
	
	public void outAIctDoElseNoShortIct(AIctDoElseNoShortIct node) {
		if(node.getExp() instanceof AVarExp) {
    		AVarExp exp = (AVarExp)node.getExp();
    		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
    		if(id == null)
    			erro("Variável não declarada", true);
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
	}
	
	public void outAAsLongAsIterationCmd(AAsLongAsIterationCmd node) {
		if(node.getCond() instanceof AVarExp) {
    		AVarExp exp = (AVarExp)node.getCond();
    		Identificador id = tabela.get(new Identificador(exp.getId().toString()));
    		if(id == null)
    			erro("Variável não declarada", true);
    		if(!id.isInit()) 
    			erro("Variável " + id.getNome() + " não inicializada", false);
    	}
	}
	
	
}
