package iterator;

import java.util.List;

public class listStrIterator implements Iterator{

    List<String> list;
    int current;

    
    public listStrIterator(List<String> list) {
        this.list = list;
        this.current = 0;
    }
    

    @Override
    public boolean hasNext() {
        if (list.size() > current) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object obj = list.get(current);
        current++;
        return obj;
    }
}