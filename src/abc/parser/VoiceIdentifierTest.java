package abc.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class VoiceIdentifierTest{
    private String temp="";
    public VoiceIdentifierTest(File fileName) throws FileNotFoundException{ 
        Scanner scanner= new Scanner(fileName);
        while(scanner.hasNext()){
            temp=temp+scanner.nextLine()+"\r";
        }
        System.out.println(temp);
        scanner.close();
    }

    public void testParse(){
        CharStream stream= new ANTLRInputStream(temp);
        VoiceIdentifierLexer lexer=new VoiceIdentifierLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        VoiceIdentifierParser parser = new VoiceIdentifierParser(tokens);
        ParseTree tree = parser.root();
        System.err.println(tree.toStringTree(parser));
        Trees.inspect(tree, parser);
    }

    public static void main(String[] args) throws FileNotFoundException{
        File testFile= new File("sample_abc/AbcSample.txt");
        VoiceIdentifierTest test = new VoiceIdentifierTest(testFile);
        test.testParse();
    }
}
