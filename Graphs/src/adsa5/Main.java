package adsa5;

import pTools.Debugger;

/**
 *
 * @author Casper
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph(25);
        char cRange[] = {'A', 'B', 'C', 'D', 'E'};
        int iRange = 5;
        int round = 0;
        int i2 = 0;

        // Add the vertexes
        while (round < cRange.length) {
            for (int i = 1; i <= iRange; i++, i2++) {
                g.addVertex(cRange[round] + "" + i);
                Debugger.println("Adding: " + cRange[round] + "" + i);
            }
            round++;
        }
        System.out.println("Added " + iRange * cRange.length + " vertexes");
        System.out.println("Adding the edges..");
        g.addEdge(0, 7);
        g.addEdge(0, 11);
        g.addEdge(1, 8);
        g.addEdge(1, 10);
        g.addEdge(1, 12);
        g.addEdge(2, 5);
        g.addEdge(2, 9);
        g.addEdge(2, 11);
        g.addEdge(2, 13);
        g.addEdge(3, 6);
        g.addEdge(3, 12);
        g.addEdge(3, 14);
        g.addEdge(4, 7);
        g.addEdge(4, 13);
        g.addEdge(5, 2);
        g.addEdge(5, 12);
        g.addEdge(5, 16);
        g.addEdge(6, 3);
        g.addEdge(6, 13);
        g.addEdge(6, 15);
        g.addEdge(6, 17);
        g.addEdge(7, 4);
        g.addEdge(7, 14);
        g.addEdge(7, 10);
        g.addEdge(8, 1);
        g.addEdge(8, 11);
        g.addEdge(8, 17);
        g.addEdge(8, 19);
        g.addEdge(9, 2);
        g.addEdge(9, 12);
        g.addEdge(9, 18);
        g.addEdge(10, 17);
        g.addEdge(11, 20);
        g.addEdge(11, 22);
        g.addEdge(11, 18);
        g.addEdge(12, 15);
        g.addEdge(12, 19);
        g.addEdge(12, 21);
        g.addEdge(12, 23);
        g.addEdge(13, 16);
        g.addEdge(13, 22);
        g.addEdge(13, 24);
        g.addEdge(14, 23);
        g.addEdge(14, 17);
        g.addEdge(15, 22);
        g.addEdge(16, 23);
        g.addEdge(17, 20);
        g.addEdge(17, 24);
        g.addEdge(18, 21);
        g.addEdge(19, 2);
        System.out.println("Edges added");


        g.showAdjMatrix();
        g.dfs(6);
    }
}
