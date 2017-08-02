package advanced.java;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rajani.maski on 6/28/17.
 */
public class TestCollection implements Cloneable{

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("NY");
        strings.add("NC");
        strings.add("CA");
        strings.remove("NY");
        System.out.println(strings.contains("NY"));

        Collection<String> collection2 = new ArrayList<>();
         collection2.add("Seattle");
         collection2.add("Portland");
         collection2.add("Los Angeles");
         collection2.add("Atlanta");

    }
}
