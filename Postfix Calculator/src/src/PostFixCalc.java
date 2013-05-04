package src;

/**
 *
 * @author Casper
 */
public class PostFixCalc implements ptools.Constants {

    /**
     * This makes the PostFixCalc a SingleTon
     *
     */
    private PostFixCalc() {
    }

    /**
     * Calculates the answer of a postfix expression
     *
     * @param postfixE the postfix expression
     * @return the answer of the postfix expression
     */
    public static int calculate(String postfixE) {
        char postfixC[] = postfixE.toCharArray();
        StackC stk = new StackC(postfixC.length);
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
                n2 = stk.pop();
                n1 = stk.pop();

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
                        ans = (int)Math.pow(n1, n2);
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
