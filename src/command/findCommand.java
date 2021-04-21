package command;

import editor.Frame;
import iterator.Container;
import iterator.Iterator;
import iterator.listIntIterator;
import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import visitor.Visitor;
import visitor.visitable;
import visitor.visitorImp;


public class findCommand implements Command, visitable, Container{

    String word;
    Visitor vs;
    List<Integer> indexes;
    Highlighter highlighter;
    
            
    @Override
    public void execute(Frame frame) {
        word =  JOptionPane.showInputDialog(frame, "Aranacak kelimeyi girin:");
        vs = new visitorImp(frame);
        indexes = accept(vs);
        int wlen = 0;
            if(word != null){
               wlen = word.length();
            }
            if (indexes != null) {
                highlighter = frame.text.getHighlighter();
                Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
                Iterator iter = getIterator();
                
                while(iter.hasNext()){
                    String str = iter.next().toString();
                    int curr = Integer.parseInt(str);
                    try {
                        highlighter.addHighlight(curr, curr + wlen, painter);
                    } catch (BadLocationException ex) {
                        Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
              
            }
    }
    


    @Override
    public List accept(Visitor visitor) {
        return visitor.findwords(this,word);
    }

    @Override
    public Iterator getIterator() {
        return new listIntIterator(indexes);
    }

    @Override
    public void undo(Frame frame) {
        highlighter.removeAllHighlights();
    }

    @Override
    public boolean isReversible() {
        return true;
    }
    

}
