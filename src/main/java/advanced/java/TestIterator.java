package advanced.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by rajani.maski on 6/28/17.
 */
public class TestIterator {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        collection.add("NY");
        collection.add("NC");
        collection.add("CA");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
