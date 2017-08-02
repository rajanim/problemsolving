package basics.generics;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class GenericMethodDemo {

    public static void main(String[] args) {

        Integer[] integers = {1,2,3,4,5};
        String[] strings = {"london", "paris", "ny"};

        GenericMethodDemo.print(integers);
        GenericMethodDemo.print(strings);

    }

    public static <E> void print(E[] list){
        for (int i = 0; i <list.length ; i++) {
            System.out.println(list[i]);
            System.out.print(" ");
        }
    }
}
