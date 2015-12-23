package abc.sound.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import abc.parser.XyzListener;
import abc.parser.XyzParser.FieldcomposerContext;
import abc.parser.XyzParser.FielddefaultlengthContext;
import abc.parser.XyzParser.FieldkeyContext;
import abc.parser.XyzParser.FieldmeterContext;
import abc.parser.XyzParser.FieldnumberContext;
import abc.parser.XyzParser.FieldtempoContext;
import abc.parser.XyzParser.FieldtitleContext;
import abc.parser.XyzParser.FieldvoiceContext;
import abc.parser.XyzParser.FillerContext;
import abc.parser.XyzParser.HeaderContext;
import abc.parser.XyzParser.KeyContext;
import abc.parser.XyzParser.MeterContext;
import abc.parser.XyzParser.OtherfieldsContext;
import abc.parser.XyzParser.RootContext;
import abc.parser.XyzParser.TempoContext;
import abc.sound.LinkingClasses.HeaderHolder;


public class MakeHeader implements XyzListener  {
    private Optional<List<String>> voices=Optional.empty();
    private List<String> stack= new ArrayList<>();
    private String fieldNumber;
    private String title;
    private String key;
    private Optional<String> composer=Optional.empty();
    private Optional<String> length=Optional.empty();
    private Optional<String> tempo=Optional.empty();
    private Optional<String> meter=Optional.empty();

    /**
     * Returns the HeaderHolder Object obtained from the header of the abc file parsed
     * @return HeaderHolder containing all data extracted from header
     */
    public HeaderHolder getResult(){
        voices=Optional.of(stack);
        return new HeaderHolder(fieldNumber,title,key,composer,length,meter,tempo,voices);
    }

    @Override public void enterFieldnumber(FieldnumberContext ctx) {}
    @Override public void exitFieldnumber(FieldnumberContext ctx) {
        if (ctx.DIGIT()!=null){
            fieldNumber=ctx.DIGIT().getText();
        }
    }
    @Override public void exitFieldtitle(FieldtitleContext ctx) {
        String temp="";
        if (ctx.TEXT()!=null){
            for (int x=0;x<ctx.getChildCount()-1;x++){
                temp=temp+ctx.getChild(x).getText()+" ";
            }
        }
        temp=temp.substring(3, temp.length()-1);
        this.title=temp;  
    }
    @Override public void enterOtherfields(OtherfieldsContext ctx) {}
    @Override public void exitOtherfields(OtherfieldsContext ctx) {}
    @Override public void enterFieldcomposer(FieldcomposerContext ctx) {}
    @Override public void exitFieldcomposer(FieldcomposerContext ctx) {
        String temp="";
        if(ctx.TEXT()!=null){
            for (int x=0;x<ctx.getChildCount()-1;x++){
                temp=temp+ctx.getChild(x).getText()+" ";
            } 
            temp=temp.substring(3, temp.length()-1);
            this.composer= Optional.of(temp); 
        }
    }
    @Override public void enterFielddefaultlength(FielddefaultlengthContext ctx) {}
    @Override public void exitFielddefaultlength(FielddefaultlengthContext ctx) {
        String temp="";
        if(ctx.METERFRACTION()!=null){
            for (int x=0;x<ctx.getChildCount()-1;x++){
                temp=temp+ctx.getChild(x).getText()+" ";
            } 
            temp=temp.substring(3, temp.length()-1);
            this.length= Optional.of(temp);
        }
    }
    @Override public void exitFieldmeter(FieldmeterContext ctx) {
        String temp="";
        if(ctx.meter()!=null){
            for (int x=0;x<ctx.getChildCount()-1;x++){
                temp=temp+ctx.getChild(x).getText()+" ";
            } 
            temp=temp.substring(3, temp.length()-1);
            this.meter= Optional.of(temp);
        }
    }
    @Override public void exitFieldtempo(FieldtempoContext ctx) {
        String temp="";
        if(ctx.tempo()!=null){
            for (int x=0;x<ctx.getChildCount()-1;x++){
                temp=temp+ctx.getChild(x).getText()+" ";
            } 
            temp=temp.substring(3, temp.length()-1);
            this.tempo= Optional.of(temp);
        }
    }
    @Override public void enterFieldvoice(FieldvoiceContext ctx) {}
    @Override public void exitFieldvoice(FieldvoiceContext ctx) {
        String temp= "";
        if(ctx.TEXT()!=null){
            for (int x=0;x<ctx.getChildCount()-1;x++){
                temp=temp+(ctx.getChild(x).getText());
            } 
        }
        temp=temp.substring(2);
        stack.add(temp);
    }
    @Override public void exitKey(KeyContext ctx) {
        String temp="";
        if(ctx.TEXT()!=null){
            temp=ctx.getText();
        }
        this.key= temp;
    }
    @Override public void enterMeter(MeterContext ctx) {}
    @Override public void exitMeter(MeterContext ctx) {}
    @Override public void enterTempo(TempoContext ctx) {}
    @Override public void exitTempo(TempoContext ctx) {}
    @Override public void enterFiller(FillerContext ctx) {}
    @Override public void exitFiller(FillerContext ctx) {}
    @Override public void enterEveryRule(ParserRuleContext arg0) {}
    @Override public void exitEveryRule(ParserRuleContext arg0) {}
    @Override public void visitErrorNode(ErrorNode arg0) {}
    @Override public void visitTerminal(TerminalNode arg0) {}
    @Override public void enterRoot(RootContext ctx) {}
    @Override public void exitRoot(RootContext ctx) {}
    @Override public void enterHeader(HeaderContext ctx) {}
    @Override public void exitHeader(HeaderContext ctx) {}
    @Override public void enterFieldkey(FieldkeyContext ctx) {}
    @Override public void exitFieldkey(FieldkeyContext ctx) {}
    @Override public void enterKey(KeyContext ctx) {}
    @Override public void enterFieldtempo(FieldtempoContext ctx) {}
    @Override public void enterFieldmeter(FieldmeterContext ctx) {}
    @Override public void enterFieldtitle(FieldtitleContext ctx) {}
}
