/* Weidong Guo */
import java.util.ArrayList;
/* Minimum Spanning Tree implemented using Prim's algorithem */
public class MST_Prim{ 
	public static int[] MST_Prim(int w[][]){
	int key[] = new int[w.length]; // keys associated with each vertex
	int parent[] = new int[w.length];// parent of each vertex
		
	//PriorityQueue Q = new PriorityQueue(10, new keyComparator());		
	ArrayList<Integer> Q = new ArrayList<Integer>();	
	for(int i = 0 ;  i < w.length; i++){
			key[i] = (-1 >>>1); //largest postive integer -> infinity
			parent[i] = -1;	 // use -1 to indicate no parent
			Q.add(new Integer(i)); // add each index into queue
	}
	key[0] = 0; // key of vertex 0 is 0
	int u;
	while(!Q.isEmpty()){ // O( |V| )
		u = extractMin(Q, key); // O( |V| )
		for(int v = 0; v < w[u].length; v++){
			/* scan through the row (|V| vertices = |V| times) 
			 * alternative: could've been doing adjacency list, and 
			 * only go through total of |E| edges regardless of the
			 * while loop outside */
			if( w[u][v] > 0 )// indication of an edge (u,v);
				if( (Q.indexOf(v) != -1) && w[u][v] < key[v]) {
					key[v] = w[u][v];	 //instant access(1) //if minheap, log|V|
					parent[v] = u;;// instant access O(1)
				}
		} // total only go through E edges out of the the vertices

	}
	return parent;
	} /* O( |V|^2) by using adjacency matrix */

	public static int extractMin(ArrayList<Integer> Q, int key[]){
		/* not extracting from a minHeap, 
		 * instead, just simply searching for it. -> O(|V|) time*/
		int minKey = key[Q.get(0)], minVertex = Q.get(0); 
		for(int i = 1; i < Q.size(); i++){
			if( key[Q.get(i)] < minKey ){
				minKey = key[Q.get(i)];	
				minVertex = Q.get(i);	
			}
		}
		Q.remove(new Integer(minVertex));// remove the minVertex from the Q
		return minVertex; 
	} //O(|V|)
}
/* What we use here is adjacency matrix + linear search to locate the m * in key
 * the while(Q != empty) will do excalty |V| time
 * extract min takes O( |V| )
 * total of O( |V|^2 )
 * /


/* ***** Alternative ****** 
 * If use adjacency matrix + minHeap
 * the runtime would be O( |V|*log|V| + |E|*log|V| ) but since
 * |E| >= |V| must be satisfied to find a MST for a graph,
 * the runtime can be rewritten as O( |E|*log|V| )  <----------
 *
 * log|V| comes into play since it takes log|V| to maintain the 
 * minHeap structure whenever we change the key's value of a vertex
 * or when we just extract(pop) the min out. 
 	


