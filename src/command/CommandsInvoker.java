package command;

import editor.Frame;
import java.util.Stack;


public class CommandsInvoker {
    
    private Stack<Command> undoStack;
    private Frame frame;

	public CommandsInvoker(Frame frame) {
		undoStack = new Stack<>();
                this.frame = frame;
	}

	public void execute(Command cmd) {
		cmd.execute(frame);
		if (cmd.isReversible()){
                    undoStack.push(cmd);
                }
	}

	public void undo() {
		if (!undoStack.isEmpty()) {
			Command cmd = undoStack.pop();
			cmd.undo(frame);
		}
	}
    
}
