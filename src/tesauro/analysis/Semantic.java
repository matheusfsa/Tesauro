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
	String[] tipos_simples = {"Integer", "SymVal", "Real"};
	private final ArrayList<String> t_simples = new ArrayList<>(Arrays.asList(tipos_simples)); 
	String[] tipos_composto = {"SymValV", "IntegerV", "RealV"};
	private final ArrayList<String> t_composto = new ArrayList<>(Arrays.asList(tipos_composto));
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
	 public void outStart(Start node)
	    {
		    System.out.println("-------------------------------------------------");
	        System.out.println("Fim da análise semântica");
	        System.out.println("-------------------------------------------------");
			  
	    }
	@Override
	 public void inAPrograma(APrograma node)
    {
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
			boolean leftIsString = node.getLeft().getTipo().equals("String");
			boolean rightIsString = node.getRight().getTipo().equals("String");
			if(leftIsString || rightIsString ) 
				return -1;
			return 1;
			
		}else {
			if(node.getValor().getTipo().equals("String")) 
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
        for(TId e : copy)
        {
        	res = tabela.add(new Identificador(e.toString(), node.getTipo().toString(), false, false));
            System.out.println("-->Inserir ( "+ e.toString()+", " +node.getTipo()+")");
            if(!res)
            	erro("Variável já foi declarada", true);
        }
        res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), false, false));
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
        boolean res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), false, false));
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
			res = tabela.add(new Identificador(node.getId().toString(), tipo.getTipo().toString().replaceAll(" ", "V"), false, false));
			if(!res)
				erro("Variável já foi declarada", true);
	        System.out.println("-->Inserir ( "+ node.getId().toString()+", " + tipo.getTipo().toString().replaceAll(" ", "V")+" )");
		}else {
			res = tabela.add(new Identificador(node.getId().toString(), node.getTipo().toString(), false, false));
			if(!res)
				erro("Variável já foi declarada", true);
	        
		    System.out.println("-->Inserir ( "+ node.getId().toString()+", " + node.getTipo()+")");
		}
       
	}
	@Override
    public void outAVarExp(AVarExp node) {
		System.out.println("-------------------------------------------------");
		System.out.println("Verificar se a variável " + node.getId() + " está na tabela.");
		node.setOp_tipo(-1);
		Identificador id = tabela.get(new Identificador(node.getId().toString()));
		if(id == null)
			erro("Variável não foi declarada", true);
		//SÓ PARA TESTE
		node.setTipo("Integer");
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
			System.out.println("Tipos incopativeis");
		}
	}
    
	@Override
	public void outAAttVarCmdSemCmd(AAttVarCmdSemCmd node) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		//System.out.println(node.getRight());
		System.out.println("É compativel? " + compativel(node.getRight()));
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
