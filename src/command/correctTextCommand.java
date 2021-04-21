package command;

import editor.Frame;
//import iterator.Container;
//import iterator.Iterator;
//import iterator.fileIterator;
//import iterator.listStrIterator;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import static java.lang.Character.isLetter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
//import javax.swing.JTextArea;

public class correctTextCommand implements Command{

    List<String> words = new ArrayList<>();
    Scanner file = null;
    String previousText;
    
    @Override
    public void execute(Frame frame) {
        previousText = frame.text.getText();
        transposition tpc = new transposition();
        List<String> hata = tpc.tp(frame.text);
       // hata = tp.transposition(frame.text); 
        if(hata != null){
             JOptionPane.showMessageDialog(null,hata+" kelimeleri sözlükte bulunmamaktadır." , "InfoBox: " + "ERROR", JOptionPane.INFORMATION_MESSAGE);
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
    
   

   
    
    

}
