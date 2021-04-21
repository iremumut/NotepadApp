package editor;

import command.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
//import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextArea;

public class Frame extends JFrame implements ActionListener, KeyListener{

    public JFrame frame;
    public JTextArea text;
    public JMenuBar mb;
    public List<String> prevList = new ArrayList<>();
    public int count = 0;
     CommandsInvoker invoker = new CommandsInvoker(this);

    public Frame() {
        frame = new JFrame("Text Editor");
        frame.setSize(1000, 500);
        frame.setLocation(220, 100);
        text = new JTextArea(500, 500);
        mb = new JMenuBar();
        frame.getContentPane().add(BorderLayout.CENTER, text);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        text.addKeyListener(this);
        frame.setJMenuBar(mb);
        frame.setVisible(true);
        frame.add(text);
        Menu m1 = new Menu("Edit");
         
        
    }

  
   
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        Command cmd;
        
        if(s.equalsIgnoreCase("New")){
            cmd = new newCommand();
            invoker.execute(cmd);
        }else if (s.equalsIgnoreCase("open")){
            cmd = new openCommand();
            invoker.execute(cmd);
        }else if(s.equalsIgnoreCase("save")){
            cmd = new saveCommand();
            invoker.execute(cmd);
        }else if(s.equalsIgnoreCase("close")){
            cmd = new closeCommand();
            invoker.execute(cmd);
        }else if(s.equalsIgnoreCase("find")){
            cmd = new findCommand();
            invoker.execute(cmd);
        }else if(s.equalsIgnoreCase("change")){
            cmd = new changeCommand();
            invoker.execute(cmd);
        }else if(s.equalsIgnoreCase("undo")){
            invoker.undo();
        }else if(s.equalsIgnoreCase("correct text")){
            cmd = new correctTextCommand();
            invoker.execute(cmd);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        prevList.add(count,text.getText());  
        count++;
        invoker.execute(new undoCommand());
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}
