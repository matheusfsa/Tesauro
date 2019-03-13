package tesauro;
import tesauro.parser.*;
import tesauro.lexer.*;
import tesauro.node.*;
import java.io.*;

public class Main2
{
	public static void main(String[] args)
	{
		try
		{
			String arquivo = "teste/teste.tesauro";
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