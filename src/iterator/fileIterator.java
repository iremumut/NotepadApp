package iterator;

import java.util.Scanner;

public class fileIterator implements Iterator{
    
    Scanner file;

    public fileIterator(Scanner file) {
        this.file = file;
    }
    
    
    
    @Override
    public boolean hasNext() {
        if(file.hasNext()){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object obj = file.nextLine();
        return obj;
    }
    
}
