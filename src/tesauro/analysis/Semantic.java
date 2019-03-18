package tesauro.analysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

import tesauro.node.*;

public class Semantic extends DepthFirstAdapter {
	private ArrayList<HashMap<Integer, Identificador>> tabs;
	private static String[] tipos_simples = {"Integer", "SymVal", "Real"};
	private static ArrayList<String> t_simples = new ArrayList<>(Arrays.asList(tipos_simples)); 
	private static String[] tipos_composto = {"SymValV", "IntegerV", "RealV"};
	private static ArrayList<String> t_composto = new ArrayList<>(Arrays.asList(tipos_composto));
	private Tabela tabela;
	public Semantic() {
		tabs = new ArrayList<>();
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
	public static int compativel(PExp node) {
		/**
		 * -1: erro
		 * 0: warning
		 * 1: show
		 */
		if(node.getOp_tipo() <= 1 ) {
			return 1;
		}
		if(node.getValor() == null) {
			if(node.getRight().getIsVec() == 1  || node.getRight().getIsVec() == 1 ) 
				return -1;
			return 1;
			
		}else {
			if(node.getValor().getIsVec() == 1) 
				return -1;
			return 1;
			
		}
		
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
        res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), false, false, is_vetor, false));
        if(!res)
        	erro("Variável já foi declarada", true);
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " +node.getTipo()+")");
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
		System.out.println("Classe: " + node.getClass());
		System.out.println("Verificar se a variável " + node.getId() + " está na tabela.");
		node.setOp_tipo(-1);
		Identificador id = tabela.get(new Identificador(node.getId().toString()));
		if(id == null)
			erro("Variável não foi declarada", true);
		if(id.isInit())
			node.setIsInit(1);
		else
			node.setIsInit(0);
		if(id.isConstante())
			node.setIsConstant(1);
		else
			node.setIsConstant(0);
		if(node.getExp().size() > 0)
			node.setIsVec(0);
		else {
			if(id.isVetor())
				node.setIsVec(1);
		}
		//SÓ PARA TESTE
		//System.out.println(id.getTipo().getClass());
		node.setTipo(id.getTipo());
    }
    public void outExp(PExp node) {
		if(Semantic.compativel(node) > -1) {
			if(node.getOp_tipo()>-1) {
					if(node.getOp_tipo() == 0 || node.getOp_tipo() == 1) {
						node.setTipo("Integer");
					}else {
						if(node.getLeft().getTipo().equals("Real") || node.getRight().getTipo().equals("Real")) 
							node.setTipo("Real");
						else
							node.setTipo("Integer");
					}
			}
		}else {
			erro("Tipos incompatíveis", true);
		}
	}
    
	@Override
	public void outAAttVarCmdSemCmd(AAttVarCmdSemCmd node) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		if(node.getLeft().getIsConstant() ==  1) {
			erro("Esse tipo de atribuição não é permitido para constantes", true);
		}
		if(node.getLeft().getIsVec() == 1 || node.getRight().getIsVec() == 1 ) {
			erro("Esse tipo de atribuição não é permitido para vetores", true);
		}
		
		System.out.println("-------------------------------------------------");
		
		
	}
	@Override
	public void outAAttConstCmdSemCmd(AAttConstCmdSemCmd node) {
		System.out.println("-------------------------------------------------");
		if(node.getLeft().getIsConstant() ==  0) {
			erro("Esse tipo de atribuição não é permitido para variáveis", true);
		}
		if(node.getLeft().getIsInit() == 1) {
			erro("O valor de uma constante não pode ser alterado", true);
		}
		System.out.println("-------------------------------------------------");
		super.outAAttConstCmdSemCmd(node);
	}
	
	@Override
	public void outASymValExp(ASymValExp node) {
		node.setTipo("SymVal");
	}
	@Override
	public void outASymVecValExp(ASymVecValExp node) {
		node.setTipo("SymVal");
	}
	@Override
	public void outAIntValExp(AIntValExp node) {
		node.setTipo("Integer");
	}
    @Override
    public void outARealValExp(ARealValExp node) {
    	node.setTipo("Real");
    }
    
	
	
}
