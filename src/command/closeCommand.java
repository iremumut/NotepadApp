package command;

import editor.Frame;

public class closeCommand implements Command{

    @Override
    public void execute(Frame frame) {
        System.exit(0);
    }

    @Override
    public void undo(Frame frame) {
    }

    @Override
    public boolean isReversible() {
        return false;
    }
    
}
