package basics.generics;

import basics.io.GenericStack;

/**
 * Created by rajani.maski on 6/19/17.
 */
public class WildCardNeedDemo {
    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(-2);
        System.out.println(max(intStack));
    }

    public static double max(GenericStack<? extends Number> stack){
        double max = stack.pop().doubleValue();
        while (!stack.isEmpty()){
            double value = stack.pop().doubleValue();
            if(value>max){
                max=value;
            }
        }
        return max;
    }
}
