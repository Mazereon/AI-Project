# AI-Project

Route Finding for AI class implemented through Informed search using Java.

Run with java Driver a-star or java Driver greedy <br/>
Node class contains label and heuristic values (F,G,H). Also contains an array of adjacent edges
that contain the target node and weight. <br/>
Edge class contains the target node and edge weight <br/>
Graph class contains the a-star/greedy algorithm <br/>
   Both uses PriorityQueue to be able to pick the lowest number. <br/>
   Both uses an explored list to keep track of visited nodes. <br/>
   A-star uses the formula f=g+h to evaluate nodes while greedy only looks at f=h <br/>
