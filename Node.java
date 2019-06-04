import java.util.*;
import java.lang.*;
import java.io.*;

public class Node 
{
	public final String label;
    public double g_scores;
    public double f_scores = 0;
    public final double h_scores;
    public Edge[] adjacencies;
    public Node parent;

    //f=g+h

    public Node(String name, double hValue)
    {
        this.label = name;
        this.h_scores = hValue;
    }

    public String toString()
    {
        return label;  
	}
}