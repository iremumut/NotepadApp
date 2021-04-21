package iterator;

import java.util.List;


public class listIntIterator implements Iterator{

    List<Integer> list;
    int current;

    
    public listIntIterator(List<Integer> list) {
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
        int obj = list.get(current);
        current++;
        return obj;
    }
    
}
