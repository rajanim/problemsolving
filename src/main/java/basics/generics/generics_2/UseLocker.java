package basics.generics.generics_2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajani.maski on 7/17/17.
 */
public class UseLocker {

    public static void main(String[] args) {
        Locker<String> stringLocker;
        Locker<List<Integer>> listLocker;
            stringLocker = new Locker<>();
            listLocker = new Locker<>();

            stringLocker.store("bear");
            listLocker.store(new ArrayList<>());
           System.out.println(stringLocker.retrieve());


           SecondLocker<String, Integer> myLocker = new SecondLocker<>();
           myLocker.storeItemOne("hello");
           myLocker.storeItemTwo(1);


    }
}
