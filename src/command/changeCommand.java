package command;

import editor.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import visitor.Visitor;
import visitor.visitable;
import visitor.visitorImp;

public class changeCommand implements Command, visitable {

    String word;
    Visitor vs;
    String replacement;
    String previousText;
    

    @Override
    public void execute(Frame frame) {
        previousText = frame.text.getText();
        word = JOptionPane.showInputDialog(frame, "Değiştirmek istediğiniz kelimeyi girin: ");
        replacement = JOptionPane.showInputDialog(frame, "Yeni kelimeyi giriniz: ");
        vs = new visitorImp(frame);
        List<Integer> indexes = accept(vs);
        if (indexes != null) {
            String metin = frame.text.getText();
            String newm = metin.replaceAll(word, replacement);
            frame.text.setText(newm);
        }

    }

    @Override
    public void undo(Frame frame) {
        frame.text.setText(previousText);
    }


    @Override
    public boolean isReversible() {
        return true;
    }
    
    @Override
    public List accept(Visitor visitor) {
        return visitor.findwords(this, word);
    }

}
