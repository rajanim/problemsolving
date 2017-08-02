package collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajani.maski on 7/7/17.
 */
public class TestQueue {

    public static void main(String[] args) {
        java.util.Queue<String> queue = new LinkedList<>();

        queue.offer("NC");
        queue.offer("NY");
        queue.offer("CA");
        while (queue.size()>0)
            System.out.println(queue.remove());
    }
}
