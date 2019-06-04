import java.util.*;
import java.lang.*;
import java.io.*;

public class Graph
{
	public Node rootVertex;
	public Node goalVertex;

	public void setGoal(Node vertex)
	{
		this.goalVertex=vertex;
	}
	public void setRoot(Node vertex)
	{
		this.rootVertex=vertex;
	}
	public List<Node> printPath()
	{
        List<Node> path = new ArrayList<Node>();
        
        for(Node node = goalVertex; node!=null; node = node.parent)
        {
            path.add(node); // from muntinlupa to caloocan, so reverse it later
        }

        Collections.reverse(path);

        return path;
    }
	public void star()
	{
		ArrayList<Node> explored = new ArrayList<Node>();
		/*
			Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
			Comparator orders the elements, lower F should be given more priority
		*/
		PriorityQueue<Node> pq = new PriorityQueue<Node>(20, new Comparator<Node>()
		{
            //override compare method
            public int compare(Node i, Node j)
            {
            	if(i.f_scores > j.f_scores)
            	{
                   return 1;
                }

                else if (i.f_scores < j.f_scores)
                {
                   return -1;
                }

 				else
 				{
                   return 0;
                }
            }
        });

        //cost from start
        rootVertex.g_scores = 0;
		pq.add(rootVertex);

        boolean pathFound = false;

        while((!pq.isEmpty()) && (!pathFound))
        {
        	//the node in having the lowest f_score value
            Node current = pq.poll();
			explored.add(current);

            //goal pathFound
            if(current.label.equals(goalVertex.label))
            {
                pathFound = true;
                System.out.println("Path cost is " + goalVertex.g_scores);             
            }

            //check every child of current node
            for(Edge e : current.adjacencies) //check adjacencies array to see adjacent nodes to current
            {
                Node child = e.target; //child is the one connected by the edge(target), node current->edge target
                double weight = e.weight; 
                double temp_g_scores = current.g_scores + weight; //current path cost + edge weight
                double temp_f_scores = temp_g_scores + child.h_scores; // f is g+h, h of the child node

                //if node has been evaluated and the newer f_score is higher, we skip

                if((explored.contains(child)) && (temp_f_scores >= child.f_scores))
                {
                    continue;
                }

                //else if child node is not in pq or newer f_score is lower(lower path cost than previous one)
                /*
                	s->a path cost of 7
                	s->b->a path cost of 3+2=5
                		
                */               
                else if((!pq.contains(child)) || (temp_f_scores < child.f_scores))
                {
					child.parent = current;
                    child.g_scores = temp_g_scores; //replace
                    child.f_scores = temp_f_scores; //replace

                    if(pq.contains(child)) 
                    {
                       	pq.remove(child); 
                    }
					pq.add(child); //after exploring, add the child to pq
				}
            }
        }

    }
    public void greedy()
    {
        ArrayList<Node> explored = new ArrayList<Node>();
        /*
            Creates a PriorityQueue with the specified initial capacity that orders its elements according to the specified comparator.
            Comparator orders the elements, lower F should be given more priority
        */
        PriorityQueue<Node> pq = new PriorityQueue<Node>(20, new Comparator<Node>()
        {
            //override compare method
            public int compare(Node i, Node j)
            {
                if(i.f_scores > j.f_scores)
                {
                   return 1;
                }

                else if (i.f_scores < j.f_scores)
                {
                   return -1;
                }

                else
                {
                   return 0;
                }
            }
        });

        //cost from start
        rootVertex.g_scores = 0;
        pq.add(rootVertex);

        boolean pathFound = false;

        while((!pq.isEmpty()) && (!pathFound))
        {
            //the node in having the lowest f_score value
            Node current = pq.poll();
            explored.add(current);

            //goal pathFound
            if(current.label.equals(goalVertex.label))
            {
                pathFound = true;
                System.out.println("Path cost is " + goalVertex.g_scores);             
            }

            //check every child of current node
            for(Edge e : current.adjacencies) //check adjacencies array to see adjacent nodes to current
            {
                Node child = e.target; //child is the one connected by the edge(target), node current->edge target
                double weight = e.weight; 
                double temp_g_scores = current.g_scores + weight; //current path cost + edge weight
                double temp_f_scores = child.h_scores; // f is g+h, h of the child node

                //if node has been evaluated and the newer f_score is higher, we skip

                if((explored.contains(child)) && (temp_f_scores >= child.f_scores))
                {
                    continue;
                }

                //else if child node is not in pq or newer f_score is lower(lower path cost than previous one)
                /*
                    s->a path cost of 7
                    s->b->a path cost of 3+2=5
                        
                */               
                else if((!pq.contains(child)) || (temp_f_scores < child.f_scores))
                {
                    child.parent = current;
                    child.g_scores = temp_g_scores; //replace
                    child.f_scores = temp_f_scores; //replace

                    if(pq.contains(child)) 
                    {
                        pq.remove(child); 
                    }
                    pq.add(child); //after exploring, add the child to pq
                }
            }
        }

    }
}