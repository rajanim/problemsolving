package reflection;

import gson.overlay.Book;

/**
 * Created by rajani.maski on 7/18/17.
 */
public class JavaRefectionTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {


        System.out.println(testRef(Book.class));
    }

    public static <T> T testRef(Class<T> tClass) throws IllegalAccessException, InstantiationException {

        return tClass.newInstance();

    }
}
