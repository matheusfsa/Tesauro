package tesauro.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tesauro.node.*;

public class Semantic extends DepthFirstAdapter {
	private ArrayList<HashMap<Integer, Identificador>> tabs;
	public Semantic() {
		tabs = new ArrayList<>();
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
	private int compativel(PExp node) {
		/**
		 * -1: erro
		 * 0: warning
		 * 1: show
		 */
		if(node instanceof AIgualExp) {
			AIgualExp exp  = (AIgualExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
		}
		if(node instanceof AMaiorExp) {
			AMaiorExp exp  = (AMaiorExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
		}
		if(node instanceof AMaiorIExp) {
			AMaiorIExp exp  = (AMaiorIExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
		}
		if(node instanceof AMenorExp) {
			AMenorExp exp  = (AMenorExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
		}
		if(node instanceof AMenorIExp) {
			AMenorIExp exp  = (AMenorIExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
		}
		if(node instanceof AMinusExp) {
			AMinusExp exp  = (AMinusExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
		}
		if(node instanceof AModExp) {
			AMinusExp exp  = (AMinusExp) node;
			if(exp.getLeft().getTipo().equals(exp.getRight().getTipo())) {
				return 1;
			}else {
				return -1;
			}
			
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
        for(TId e : copy)
        {
            System.out.println("-->Inserir ( "+ e.toString()+", " +node.getTipo()+")");
        }
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
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " +node.getTipo()+")");
	}
	@Override
	public void outAConstAttDeclaracao(AConstAttDeclaracao node) {
		System.out.println("-------------------------------------------------");
		System.out.println("O tipo desta declaração é " + node.getTipo());
		System.out.print("Constantes: ");
		System.out.print(node.getId().toString());
		System.out.print("Expressão: ");
		System.out.print(node.getExp().toString());
        System.out.println();
        System.out.println("Ações a serem tomadas na tabela de símbolos:");
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " + node.getTipo()+")");
	}
	@Override
	public void outASymValExp(ASymValExp node) {
		node.setTipo("SymVal");
	}
	@Override
	public void outASymVecValExp(ASymVecValExp node) {
		node.setTipo("SymVecVal");
	}
	@Override
	public void outAIntValExp(AIntValExp node) {
		node.setTipo("IntVal");
	}
    @Override
    public void outARealValExp(ARealValExp node) {
    	node.setTipo("RealVal");
    }
	@Override
	public void outAAttVarCmdSemCmd(AAttVarCmdSemCmd node) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		AVarExp left = (AVarExp) node.getLeft();
		System.out.println("Verificar se a variável " + left.getId() + " está na tabela.");
		if(node.getRight() instanceof AVarExp) {
			AVarExp right = (AVarExp) node.getRight();
			System.out.println("Verificar se a variável " + right.getId() + " está na tabela.");
		}else { 
			System.out.println("Tipo da direita: " + node.getRight().getTipo());
		}
	}
	
}
