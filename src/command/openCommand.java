package command;

import editor.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class openCommand implements Command {

    @Override
    public void execute(Frame frame) {
        JFileChooser j = new JFileChooser();
        int r = j.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fi = new File(j.getSelectedFile().getAbsolutePath());

            try {
                String s1 = "", sl = "";
                FileReader fr = new FileReader(fi);
                BufferedReader br = new BufferedReader(fr);
                sl = br.readLine();
                while ((s1 = br.readLine()) != null) {
                    sl = sl + "\n" + s1;
                }

                frame.text.setText(sl);
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
