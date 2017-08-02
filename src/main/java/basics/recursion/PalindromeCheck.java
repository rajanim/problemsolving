package basics.recursion;

/**
 * Created by rajani.maski on 6/15/17.
 */
public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalindrome("gadagss"));
    }

    public static boolean isPalindrome(String s){
        if(s.length()<=1){
            return true;
        }else if(s.charAt(0)!=s.charAt(s.length()-1)){
            return false;
        }else
            return isPalindrome(s.substring(1,s.length()-1));
    }
}
