package command;

import editor.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class saveCommand implements Command {

    @Override
    public void execute(Frame frame) {
        JFileChooser j = new JFileChooser();
        int r = j.showSaveDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {

            File fi = new File(j.getSelectedFile().getAbsolutePath());

            try {
                FileWriter wr = new FileWriter(fi, false);
                BufferedWriter w = new BufferedWriter(wr);
                w.write(frame.text.getText());

                w.flush();
                w.close();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }

        }
    }

    @Override
    public void undo(Frame frame) {
    }

    @Override
    public boolean isReversible() {
        return false;
    }

}
