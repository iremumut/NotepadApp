package editor;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuItems implements frameItems{
    
    static JMenuItem menuItem;
    int menuidx;

    public MenuItems(String name,int menuidx) {
        menuItem = new JMenuItem(name);
        this.menuidx = menuidx;
    }


    @Override
    public void add(Frame frame) {
        frame.mb.getMenu(menuidx).add(menuItem);
        menuItem.addActionListener(frame);
    }
}
