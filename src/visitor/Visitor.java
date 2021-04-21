package visitor;

import command.changeCommand;
import command.findCommand;
import java.util.List;


public interface Visitor {
    
    public List findwords(findCommand nc,String word);
    public List findwords(changeCommand cc,String word);
    
    
}
