package src;

/**
 *
 * @author Casper
 */
public class InToPost {

    // The postfix to return
    private static String postfix;
    // The stack used to stack numbers and operators
    private static StackC stack;

    /**
     * This makes the InToPost a Singleton
     *
     */
    private InToPost() {
    }

    /**
     * Puts the operators on the stack.
     *
     * @param thisOp the operator to push on the stack
     * @param prec1 the precedence of the operator
     */
    private static void putOper(char thisOp, int prec1) { // got operator from input
        while (!stack.isEmpty()) {
            char opTop = (char) (char) stack.pop();

            if (opTop == '(') // if it’s a ‘(‘
            {
                stack.push((char) opTop); // restore ‘(‘
                break;
            } else // it’s an operator
            {
                int prec2; // precedence of new op
                if (opTop == '+' || opTop == '-') // find new op prec
                {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) // if prec of new op less
                { // than prec of old
                    stack.push((char) opTop); // save newly-popped op
                    break;
                } else // prec of new not less
                {
                    postfix = postfix + (char) opTop; // than prec of old
                }
            }
        }
        stack.push((char) thisOp); // push new operator
    }

    /**
     * Pops the ) from the stack.
     *
     */
    private static void gotPare() { // got right paren from input
        while (!stack.isEmpty()) {
            char c = (char) stack.pop();
            if (c == '(') // if popped '('
            {
                break; // we’re done
            } else // if popped operator
            {
                postfix = postfix + (char) c; // output it
            }
        }
    }

    /**
     * Translates the input to a postfix expression.
     *
     * @param input from the user
     * @return postfix
     */
    public static String translate(String input) // do translation to postfix
    {
        stack = new StackC(input.length());
        postfix = "";

        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);

            switch (ch) {
                case '+': // it’s + or -
                case '-':
                    putOper(ch, 1); // go pop operators
                    break; // (precedence 1)
                case '/':
                case '*': // it’s * or /
                    putOper(ch, 2); // go pop operators
                    break; // (precedence 2)
                case '(': // it’s a left paren
                    stack.push((char) ch); // push it
                    break;
                case ')': // it’s a right paren
                    gotPare(); // go pop operators
                    break;
                default: // must be an operand
                    postfix = postfix + ch; // write it to output
                    break;
            }
        }
        while (!stack.isEmpty()) {
            postfix = postfix + (char) stack.pop(); // write to output
        }
        return postfix; // return postfix
    }
}
