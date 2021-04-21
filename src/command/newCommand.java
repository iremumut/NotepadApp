package command;

import editor.Frame;

public class newCommand implements Command {

    @Override
    public void execute(Frame frame) {
        frame.text.setText("");
    }

    @Override
    public void undo(Frame frame) {
    }

    @Override
    public boolean isReversible() {
        return false;
    }



}
