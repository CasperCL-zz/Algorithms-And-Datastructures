package adsa5;

public class Vertex {

    public String label; // label (e.g. ‘A’)
    public boolean wasVisited;
    public int id;
// ------------------------------------------------------------

    public Vertex(String lab, int id) // constructor
    {
        label = lab;
        this.id = id;
        wasVisited = false;
    }
// ------------------------------------------------------------
} // end class Vertex
////////////////////////////////////////////////////////////////