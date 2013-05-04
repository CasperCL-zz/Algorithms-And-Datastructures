package adsa4;

import java.util.Stack;
import ptools.Constants;

/**
 *
 * @author Casper
 */
public class PostFixCalc implements Constants {

    /**
     * This makes the PostFixCalc a SingleTon
     *
     */
    private PostFixCalc() {
    }

    /**
     * Calculates the answer of a postfix expression in a tree
     *
     * @param postfixE the postfix expression
     * @return the answer of the postfix expression
     */
    public static int calculate(Tree postfixE) {
        char postfixC[] = postfixE.postOrder().toCharArray();
        Stack stk = new Stack();
        int n1, n2, ans = 0, rn; //Real Number(rn)
        char zero = '0';
        char ch;

        for (int i = 0; i < postfixC.length; i++) {
            ch = postfixC[i];
            rn = ch - zero;

            // If number
            if (rn >= 0 && rn <= 9) {
                // push it on the stack. 
                if (VERBOSE) {
                    System.out.println("Pushing " + ch);
                }
                stk.push((int) (ch - zero)); //No further action should take place
            } else {
                // If operand, pop numbers from the stack to calculate with
                n2 = (int) stk.pop();
                n1 = (int) stk.pop();

                // Pick appropiate calculation with operand
                switch (ch) {
                    case '+':
                        if (VERBOSE) {
                            System.out.println("ans = " + n1 + " + " + n2);
                        }
                        ans = n1 + n2;
                        break;
                    case '-':
                        if (VERBOSE) {
                            System.out.println("ans = " + n1 + " - " + n2);
                        }
                        ans = n1 - n2;
                        break;
                    case '/':
                        if (VERBOSE) {
                            System.out.println("ans = " + n1 + " / " + n2);
                        }
                        ans = n1 / n2;
                        break;
                    case '*':
                        if (VERBOSE) {
                            System.out.println("ans = " + n1 + " * " + n2);
                        }
                        ans = n1 * n2;
                        break;
                    case '^':
                        if (VERBOSE) {
                            System.out.println("ans = " + n1 + " ^ " + n2);
                        }
                        ans = n1 ^ n2;
                        break;
                }
                // Push the answer for now on the stack
                if (VERBOSE) {
                    System.out.println("Pushing " + ans);
                }
                stk.push((int) ans);
            }
        }

        return ans;
    }
}
