package editor;

//import command.openWords;
//import command.transposition;
//import iterator.Iterator;
//import iterator.listStrIterator;

public class Main {
    
    public static void main(String[] args) {
        
        Frame frame = new Frame();
        FactoryMenu fm = new FactoryMenu();
        fm.getFrame("Menu", "File", 0,frame);
        fm.getFrame("Menu", "Edit", 0,frame);
        fm.getFrame("menuitem", "New", 0,frame);
        fm.getFrame("menuitem", "Open", 0,frame);
        fm.getFrame("menuitem", "Save", 0,frame);
        fm.getFrame("menuitem", "Close", 0,frame);
        fm.getFrame("menuitem", "Find", 1,frame);
        fm.getFrame("menuitem", "Change", 1,frame);
        fm.getFrame("menuitem", "Undo", 1,frame);
        fm.getFrame("menuitem", "Correct Text", 1,frame);
        
       
       
       
    }
}
