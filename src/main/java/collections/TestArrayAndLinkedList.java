package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rajani.maski on 7/7/17.
 */
public class TestArrayAndLinkedList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1); // 1 is autoboxed to new Integer(1)
         arrayList.add(2);
         arrayList.add(3);
         arrayList.add(1);
         arrayList.add(4);
         arrayList.add(0, 10);
         arrayList.add(3, 30);


         LinkedList<Integer> linkedList = new LinkedList<>();
         linkedList.add(1);
         linkedList.add(2);
         linkedList.removeLast();

    }
}
