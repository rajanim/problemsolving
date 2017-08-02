package basics.generics;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class GenericSort {
    public static void main(String[] args) {
        Integer[] intArray = {new Integer(2), new Integer(4), new Integer(3)};

        Character[] charArray = {new Character('a'), new Character('J'), new Character('r')};

        sort(intArray);
        sort(charArray);


    }

    public static void printArray(Object[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + " ");
        }

    }

    public static <E extends Comparable<E>> void sort(E[] list){
        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length; i++) {
            //find min in the list
            currentMin = list[i];
            currentMinIndex = i;

            for (int j = 0; j <list.length ; j++) {
                if(currentMin.compareTo(list[j])>0){
                    currentMin = list[j];
                    currentMinIndex=j;
                }
            }
            if(currentMinIndex!=i){
                list[currentMinIndex] = list[i];
                list[i]= currentMin;
            }
        }
    }
}
