package basics.recursion;

/**
 * Created by rajani.maski on 6/15/17.
 */
public class ComputeFactorial {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(factorial(n));
    }

    public static long factorial(int n) {
        if(n==0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
}
