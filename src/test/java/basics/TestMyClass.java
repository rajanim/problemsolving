package basics;

/**
 * Created by rajani.maski on 6/14/17.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestMyClass {

    @Test
    public void testAdd(){
        MyClass testMyClass = new MyClass();
        assertEquals(7,testMyClass.add(4,3));
    }





}
