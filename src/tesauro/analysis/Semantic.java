package tesauro.analysis;

import java.util.ArrayList;
import java.util.List;

import tesauro.node.AConstAttDeclaracao;
import tesauro.node.AConstanteDeclaracao;
import tesauro.node.APrograma;
import tesauro.node.AVarDeclaracao;
import tesauro.node.Start;
import tesauro.node.TId;

public class Semantic extends DepthFirstAdapter {
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
		  
		//node.getIdentificadores é a lista de nome de veriáveis. Ela é uma lista porque eu 
		//a defini desta maneira na minha gramática abstrata.
		System.out.print("Constantes: ");
		System.out.print(node.getId().toString());
		System.out.print("Expressão: ");
		System.out.print(node.getExp().toString());
        System.out.println();
        System.out.println("Ações a serem tomadas na tabela de símbolos:");
        System.out.println("-->Inserir ( "+ node.getId().toString()+", " + node.getTipo()+")");
	}
}
