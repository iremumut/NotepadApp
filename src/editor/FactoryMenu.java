package editor;

//import javax.swing.JMenuBar;

public class FactoryMenu {
    
    public void getFrame(String menutype,String name,int ind,Frame frame){           
          if(menutype.equalsIgnoreCase("Menu")){
              Menu menu = new Menu(name);
              menu.add(frame);
          }else if(menutype.equalsIgnoreCase("MenuItem")){
              MenuItems menuitem = new MenuItems(name,ind);
              menuitem.add(frame);
          }
    }
}
