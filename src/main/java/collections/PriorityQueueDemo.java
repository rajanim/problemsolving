package collections;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rajani.maski on 7/7/17.
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        java.util.PriorityQueue<String> queue = new PriorityQueue<>();

        queue.offer("NC");
        queue.offer("NY");
        queue.offer("CA");
        queue.forEach(elem -> System.out.println(elem));


        PriorityQueue<String> queue1 = new PriorityQueue(4, Collections.reverseOrder());
        queue1.offer("NC");
        queue1.offer("NY");
        queue1.offer("CA");

        queue1.forEach(elem -> System.out.println(elem));
    }
}
