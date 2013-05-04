package adsa4;

import java.util.Stack;

/**
 *
 * @author Casper
 */
public class Postfix {

    private Stack theStack;

    public Postfix() {
    }

    public Tree postToTree(String input) {
        theStack = new Stack(); // make new stack
        char ch;
        int i = 0;
        int j;
        Tree a, b, c;
        for (j = 0; j < input.length(); j++, i++) // for each char,
        {
            ch = input.charAt(j); // read from input
            if (ch >= '0' && ch <= '9') // if it's a operand
            {
                // Make a new tree
                Tree t = new Tree();
                t.insert(i, ch);
                theStack.push(t); // push it on the stack as a (sub)tree
            } else // it's an operator
            {
                // pop tree operands
                c = (Tree) theStack.pop();
                b = (Tree) theStack.pop();
                a = new Tree();
                a.insert(i, ch);
                a.addTreeRightChild(b);
                a.addTreeLeftChild(c);

                theStack.push(a); // push result
            }
        }

        return (Tree) theStack.pop(); // a is the tree containing the algebraic expression
    }
}
