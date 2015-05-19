import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
class Edge{
	int u, v, w; 
	// vertex u and v
	// w is the weight of the edge (u,v)
	Edge(int i, int j, int k){
		u = i; v = j ; w = k;
	}
	public String toString(){
		return "(" + u + ", " + v + ") and weight = " + w;
	}
}

class EdgeComparator implements Comparator<Edge>{
	public int compare(Edge e1, Edge e2){
		return e1.w - e2.w; 
		/* positive -> e1.w is greater
		 * negative -> e2.w is greater */
	}
}


public class MST_Kruskal{
	public static ArrayList<Edge> MST_Kruskal(Edge [] E, int numOfVertices){ 
		/* NOTE: assumes the Graph have vertices naming from 0 up to
		 * (numOfVertices - 1) */
		  
		UnionFind powerSet = new UnionFind(numOfVertices);	

		Comparator<Edge> cmp = new EdgeComparator();
		PriorityQueue<Edge> Q = new PriorityQueue<Edge>(E.length, cmp);		
		ArrayList<Edge> MST = new ArrayList<Edge>(); 
		//Minimum Spanning Tree(MST) that we are going to contruct
		
		for( Edge e : E){
			Q.add(e); //add each weighted edge into the priority queue		
		}

		Edge e;
		while( (e = Q.poll()) != null){
			if(powerSet.collapsingFind(e.u) != powerSet.collapsingFind(e.v)){
				/* if vertex u and vertex v is in a different set,
				 * then adding (u,v) does NOT make a cycle 
				 */
				MST.add(e);//this edge should be in the miminum spanning tree				
				powerSet.union(e.u, e.v);
				/* make a new connected component(vertices in the same set are connected) */	
			}
		}
		return MST;	
	}
}
