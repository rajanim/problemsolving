package basics.recursion;

/**
 * Created by rajani.maski on 6/15/17.
 */
public class Fibonacci {
    public static void main(String[] args) {

        int n = 7;
        System.out.println(fibonacci(n));
    }

    public static long fibonacci(int i){
        if(i==0){
            return 0;

        }else if(i==1){
            return 1;
        }else{
            return fibonacci(i-1) + fibonacci(i-2);
        }

    }
}
