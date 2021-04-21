package command;

import editor.Frame;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
////import java.util.ArrayList;
//import java.util.List;

public class undoCommand implements Command {

    @Override
    public void execute(Frame frame) {        
    }

    @Override
    public void undo(Frame frame) {
        if(frame.count > 0){
                frame.count = frame.count-1;
                frame.text.setText(frame.prevList.get(frame.count));
            }
    }

    @Override
    public boolean isReversible() {
        return true;
    }



}
