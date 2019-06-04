public class Edge
{
    public final double weight;
    public final Node target;

    public Edge(Node targetNode, double costVal)
    {
        this.target = targetNode;
        this.weight = costVal;
    }
}