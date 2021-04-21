package visitor;

import java.util.List;


public interface visitable {
    
    public List accept(Visitor visitor);
    
}
