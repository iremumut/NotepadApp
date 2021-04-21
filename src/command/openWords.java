package command;

import iterator.Container;
import iterator.Iterator;
import iterator.fileIterator;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class openWords implements Container{

    public List<String> words = new ArrayList<>();
    Scanner file = null;
    
     public List openwords() {
        try {
            this.file = new Scanner(new FileInputStream("words.txt.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }
        
        Iterator iter = getIterator();
        
        while(iter.hasNext()){
            words.add(iter.next().toString());
        }
        return words;
    }
    
    @Override
    public Iterator getIterator() {
        return new fileIterator(file);
    }
    
}
