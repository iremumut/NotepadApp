package iterator;


public class arrayIterator implements Iterator{

    Object[] arr; 
    int ind;

    public arrayIterator(Object[] arr) {
        this.arr = arr;
        this.ind = 0;
    }
    
    
    
    @Override
    public boolean hasNext() {
         if (arr.length > ind) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object obj = arr[ind];
        ind++;
        return obj;
    }
    
}
