import java.util.*;
import java.lang.*;
import java.io.*;

/* 
	run with java Driver a-star
			 java Driver greedy
*/
public class Driver
{
	public static void main(String[] args)
	{
		//added heuristic to parameter
		Graph graph=new Graph();

        Node manila=new Node("manila",20);
        Node pasay=new Node("pasay",13.6);
        Node qc=new Node("qc",26.8);
        Node pasig=new Node("pasig",17.4);
        Node makati=new Node("makati",14.8);
        Node muntinlupa=new Node("muntinlupa",0);
        Node mandaluyong=new Node("mandaluyong",17.1);
        Node paranaque=new Node("paranaque",7.4);
        Node caloocan=new Node("caloocan",34.8);
		
		manila.adjacencies = new Edge[]
		{
            new Edge(pasay,9),
            new Edge(mandaluyong,12),
            new Edge(caloocan,20)
        };

        caloocan.adjacencies = new Edge[]
        {
        	new Edge(qc,15),
        	new Edge(manila,20)
        };

        pasay.adjacencies = new Edge[]
        {
        	new Edge(manila,9),
        	new Edge(makati,10),
        	new Edge(paranaque,6)
        };

        qc.adjacencies = new Edge[]
        {
        	new Edge(mandaluyong,10),
        	new Edge(caloocan,15),
        	new Edge(pasig,7)
        };

        mandaluyong.adjacencies = new Edge[]
        {
        	new Edge(manila,12),
        	new Edge(qc,10),
        	new Edge(makati,2)
        };

        makati.adjacencies = new Edge[]
        {
        	new Edge(pasay,10),
        	new Edge(mandaluyong,2),
        	new Edge(pasig,8),
        	new Edge(muntinlupa,17)
        };

        pasig.adjacencies = new Edge[]
        {
        	new Edge(qc,7),
        	new Edge(makati,8),
        	new Edge(muntinlupa,20)
        };

        paranaque.adjacencies = new Edge[]
        {
        	new Edge(pasay,6),
        	new Edge(muntinlupa,11)
        };

        muntinlupa.adjacencies = new Edge[]
        {
        	new Edge(paranaque,11),
        	new Edge(makati,17),
        	new Edge(pasig,20)
        };

       	graph.setRoot(caloocan);
		graph.setGoal(muntinlupa);

		if(args[0].toLowerCase().equals("a-star"))
		{
			System.out.println("Running a-star...");
			graph.star();
			List<Node> path = graph.printPath();
			System.out.println("Path: " + path);
		}
		if(args[0].toLowerCase().equals("greedy"))
		{
			System.out.println("Running greedy...");
			graph.greedy();
            List<Node> path = graph.printPath();
            System.out.println("Path: " + path);
		}
	}
}