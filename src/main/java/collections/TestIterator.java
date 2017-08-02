package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by rajani.maski on 7/7/17.
 */
public class TestIterator {

    public static void main(String[] args) {
        Collection<String> strings = new ArrayList<>();
        strings.add("NY");
        strings.add("CA");
        strings.add("NC");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }
}
