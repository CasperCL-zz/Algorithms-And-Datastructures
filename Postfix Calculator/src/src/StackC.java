package src;

/**
 * A skinny version of a ADT stack.
 *
 * @author Casper
 */
public class StackC {
    
    private int top;
    private int[] sArray;

    /**
     * Create a new Stack.
     *
     * @param size the size of the new stack
     */
    public StackC(int size) {
        top = -1;
        sArray = new int[size];
    }

    /**
     * Push something on the stack.
     *
     * @param i item to be pushed
     */
    public void push(int i) {
        sArray[++top] = i;
    }

    /**
     * Pop something from the stack.
     *
     * @return the top value
     */
    public int pop() {
        return sArray[top--];
    }

    /**
     * Look at the top item of the stack.
     *
     * @return the top item
     */
    public int peek() {
        return sArray[top];
    }

    /**
     * Checks whether the stack is empty or not.
     *
     * @return true when empty
     */
    public boolean isEmpty() {
        return (top == -1);
    }
}
