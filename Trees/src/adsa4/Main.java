package adsa4;

/**
 *
 * @author Casper
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Postfix f = new Postfix();
        Tree algT = f.postToTree("239^+");
        algT.displayTree();
        System.out.println("Preordered:\t" + algT.preOrder());
        System.out.println("Inordered:\t" + algT.inOrder());
        System.out.println("Postordered:\t" + algT.postOrder());
    }
}
