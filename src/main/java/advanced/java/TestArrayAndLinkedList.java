package advanced.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by rajani.maski on 6/28/17.
 */
public class TestArrayAndLinkedList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();

        arrayList.add(2);
        arrayList.add(2,3);
        System.out.println("A list of integers in the array list:");
             System.out.println(arrayList);

        LinkedList<Object> linkedList = new LinkedList<>(arrayList);
        linkedList.add(1, "red");
        linkedList.addFirst("green");
        linkedList.removeLast();

        ListIterator<Object> listIterator = linkedList.listIterator();
    }
}
