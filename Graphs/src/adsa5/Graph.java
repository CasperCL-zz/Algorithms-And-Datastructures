package adsa5;

import java.util.Stack;

public class Graph {

    private final int MAX_VERTS;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    private int cVert;
    private Stack theStack;
    private int j;
// -----------------------------------------------------------

    public Graph(int maxVerts) // constructor
    {
        MAX_VERTS = maxVerts;
        vertexList = new Vertex[MAX_VERTS];
        j = 0;
        cVert = 0;

        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) // set adjacency
        {
            for (int k = 0; k < MAX_VERTS; k++) // matrix to 0
            {
                adjMat[j][k] = 0;
            }
        }
        theStack = new Stack();
    } // end constructor
// -----------------------------------------------------------

    public void addVertex(String lab) {
        vertexList[nVerts++] = new Vertex(lab, cVert++);
    }
// -----------------------------------------------------------

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
// ------------------------------------------------------------

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + '-');
    }
// ------------------------------------------------------------

    public void dfs(int vertex) // depth-first search
    {
        System.out.println("\n---------------------");
        System.out.println("\tDFS ");
        System.out.println("---------------------");

        vertexList[vertex].wasVisited = true; // mark it
        displayVertex(vertex); // display it
        theStack.push(vertex); // push it
        while (!theStack.isEmpty()) // until stack empty,
        {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex((int) theStack.peek());
            if (v == -1) // if no such vertex,
            {
                int vertexI = (int) theStack.pop();
                vertexList[vertexI].wasVisited = false;
            } else // if it exists,
            {
                vertexList[v].wasVisited = true; // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
            }
        } // end while
        // stack is empty, so we’re done
        for (int j = 0; j < nVerts; j++) // reset flags
        {
            vertexList[j].wasVisited = false;
        }
        System.out.println();
    } // end dfs
// ------------------------------------------------------------
// returns an unvisited vertex adj to v

    public int getAdjUnvisitedVertex(int v) {
        for (; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    } // end getAdjUnvisitedVertex()

    public void showAdjMatrix() {
        int counter = 0;
        System.out.println("--------------------");
        System.out.println("The Adjacency Matrix");
        System.out.println("--------------------");
        for (Vertex v : vertexList) {
            System.out.print('\t' + v.label);
        }
        System.out.println();


        for (int outAdj[] : adjMat) {
            System.out.print(vertexList[counter++].label + '\t');
            for (int inAdj : outAdj) {
                System.out.print(inAdj + "\t");
            }
            System.out.println();
        }

    }
// ------------------------------------------------------------
} // end class Graph
///