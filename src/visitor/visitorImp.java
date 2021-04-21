package visitor;

import command.changeCommand;
import command.findCommand;
import editor.Frame;
import java.util.ArrayList;
import java.util.List;


public class visitorImp implements Visitor{

    public Frame frame;

    public visitorImp(Frame frame) {
        this.frame = frame;
    }
    
    
    @Override
    public List findwords(findCommand nc,String word) {
        if (word != null && frame.text != null) {

            String metin = frame.text.getText();
            List<Integer> indexList = new ArrayList<>();

            int index = metin.indexOf(word);
            indexList.add(index);
            while (index >= 0) {
                index = metin.indexOf(word, index + 1);
                if(index != -1){
                     indexList.add(index);
                }
            }
            return indexList;
            }
            return null;
    }


    @Override
    public List findwords(changeCommand cc, String word) {
        if (word != null && frame.text != null) {
            String metin = frame.text.getText();
            List<Integer> indexList = new ArrayList<>();
            int index = metin.indexOf(word);
            if(index != -1){
                indexList.add(index);
            }
            return indexList;
        }
        return null;
    }
    
}
