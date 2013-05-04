package adsa4;

/**
 *
 * @author Casper
 */
public class Node {

    public int id; // data item (key)
    public char dData; // data item
    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child

    public void displayNode() // display ourself
    {
        System.out.print('{');
        System.out.print(id);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}
