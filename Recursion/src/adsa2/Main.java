package adsa2;

/**  
 * This class contains the exercises of Algorithms and DataStructures PO2 Year 2
 * at the HvA.
 * @author Casper Eekhof
 */
public class Main {

    public static void main(String args[]) {

    }
    
    public static void print(String s, int pos) {
        if (pos > s.length() - 1) 
            return;
        
        System.out.print(s.charAt(pos));
        print(s, ++pos);
    }

    public static void printR(String s, int pos) {
        if (pos > s.length() - 1) 
            return;
        
        printR(s, ++pos);
        System.out.print(s.charAt(pos - 1));
    }

    public static boolean isPalindrome(String s, int length, int pos) {
        if (length < 1) 
            return true;
        
        if (s.charAt(pos) == s.charAt(length - 1)) 
            return isPalindrome(s, --length, ++pos);
        else 
            return false;
    }

    public static int mult(int nr, int n) {
        if (n <= 1) 
            return nr;
        
        if (n > 1) 
            return nr + mult(nr, n - 1);
         else 
            return -nr + mult(nr, n + 1);
    }
}