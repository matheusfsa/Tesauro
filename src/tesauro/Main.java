package tesauro;
import tesauro.parser.*;
import tesauro.analysis.Semantic;
import tesauro.lexer.*;
import tesauro.node.*;
import java.io.*;

public class Main
{
 public static void main(String[] args)
 {
  try
  {
   String arquivo = "teste/teste.tesauro";
  
   Parser p =
    new Parser(
    new Lexer(
    new PushbackReader(  
    new FileReader(arquivo), 1024))); 
   
   Start tree = p.parse();
   //Imprime árvore na saída padrão
   //tree.apply(new ASTPrinter());
   //Imprime árvore em interface gráfica
   //tree.apply(new ASTDisplay());
   tree.apply(new Semantic());
  }
  catch(Exception e)
  {
   System.out.println(e.getMessage());
  }
 }
}