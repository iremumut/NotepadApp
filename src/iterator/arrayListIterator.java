package iterator;

import java.util.ArrayList;


public class arrayListIterator implements Iterator {

    ArrayList arrlist;
    int curr;

    public arrayListIterator(ArrayList a) {
        arrlist = a;
        curr = 0;
    }

    @Override
    public boolean hasNext() {
        if (arrlist.size() > curr) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object obj = arrlist.get(curr);
        curr++;
        return obj;
    }

}
