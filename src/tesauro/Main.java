package tesauro;

import java.io.FileReader;
import java.io.PushbackReader;

import tesauro.lexer.Lexer;
import tesauro.node.EOF;
import tesauro.node.Token;

public class Main {
	public static void main(String[] args)
	{
		try
		{
			String arquivo = "teste/merge.tesauro";
			Lexer lexer =
					new Lexer(
							new PushbackReader(  
									new FileReader(arquivo), 1024)); 			
			
					
			Token token;
			while(!((token = lexer.next()) instanceof EOF)) {
				System.out.print(token.getClass());
				System.out.println(" ( "+token.toString()+")");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
