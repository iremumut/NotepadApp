package command;
import editor.Frame;

public interface Command {

    public void execute(Frame frame);

    public void undo(Frame frame);
    
    public boolean isReversible();
}
