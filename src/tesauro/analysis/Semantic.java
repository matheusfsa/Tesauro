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
		if(node.getOp_tipo() == 1 || node.getOp_tipo() == -1) {
			return 1;
		}
		if(node.getValor() == null) {
			boolean leftIsString = node.getLeft().getTipo().equals("SymVecVal");
			boolean rightIsString = node.getRight().getTipo().equals("SymVecVal");
			if(leftIsString ^ rightIsString ) 
				return -1;
			return 1;
			
		}else {
			if(node.getValor().getTipo().equals("SymVecVal")) 
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
        System.out.println("Ações a serem tomadas na tabela de símbolos: ");
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " + node.getTipo()+")");
	}
	@Override
    public void outAVarExp(AVarExp node) {
		System.out.println("-------------------------------------------------");
		System.out.println("Verificar se a variável " + node.getId() + " está na tabela.");
		node.setOp_tipo(-1);
		//SÓ PARA TESTE
		node.setTipo("Integer");
    }

	@Override
	public void outAAttVarCmdSemCmd(AAttVarCmdSemCmd node) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		//System.out.println(node.getRight());
		System.out.println("É compativel? " + compativel(node.getRight()));
	}
	public void outExp(PExp node) {
		
		if(compativel(node) > -1) {
			if(node.getOp_tipo()>-1) {
					if(node.getOp_tipo() == 0 || node.getOp_tipo() == 1) {
						node.setTipo("Integer");
					}else {
						if(node.getLeft().getTipo().equals("RealVal") || node.getRight().getTipo().equals("RealVal")) 
							node.setTipo("RealVal");
						else
							node.setTipo("Integer");
					}
			}
		}else {
			System.out.println("Tipos incopativeis");
		}
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
		node.setTipo("Integer");
	}
    @Override
    public void outARealValExp(ARealValExp node) {
    	node.setTipo("RealVal");
    }
    @Override
    public void outAAndExp(AAndExp node) {
    	outExp(node);
    }
    @Override
    public void outADiffExp(ADiffExp node) {
    	outExp(node);
    }
    @Override
    public void outADivExp(ADivExp node) {
    	outExp(node);
    }
    @Override
    public void outAIgualExp(AIgualExp node) {
    	outExp(node);
    }
    @Override
    public void outAMaiorExp(AMaiorExp node) {
    	outExp(node);
    }
    @Override
    public void outAMaiorIExp(AMaiorIExp node) {
    	outExp(node);
    }
    @Override
    public void outAMenorExp(AMenorExp node) {
    	outExp(node);
    }
    @Override
    public void outAMenorIExp(AMenorIExp node) {
    	outExp(node);
    }
    @Override
    public void outAMinUnExp(AMinUnExp node) {
    	outExp(node);
    }
    @Override
    public void outAMinusExp(AMinusExp node) {
    	outExp(node);
    }
    @Override
    public void outAModExp(AModExp node) {
    	outExp(node);
    }
    @Override
    public void outAMultExp(AMultExp node) {
    	outExp(node);
    }
    @Override
    public void outANotExp(ANotExp node) {
    	outExp(node);
    }
    @Override
    public void outAOrExp(AOrExp node) {
    	outExp(node);
    }
    @Override
    public void outASumExp(ASumExp node) {
    	outExp(node);
    }
    
    @Override
    public void outAXorExp(AXorExp node) {
    	outExp(node);
    }
	
	
}
