package editor;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu implements frameItems {
    
     static JMenu menu;

    public Menu(String name) {
        menu = new JMenu(name);
    }

    @Override
    public void add(Frame frame) {
        frame.mb.add(menu);
        menu.addActionListener(frame);
    }



}
