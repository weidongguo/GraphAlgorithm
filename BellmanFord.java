public class BellmanFord{
	/*====================================================*/
	/**@fn boolean BellmanFord(int weight[][], int srcVertex) 
	 * @param 1[in] : int weight[][], weight for each edge
	 * @param 2[in] : int srcVertex, the source vertex that we find the distance from
	 * @return: true if no negative-weight cycles are reachable from the source, otherwise, false
	 */

	public static boolean BellmanFord(int weight[][], int srcVertex){
		int d[] = new int[weight.length];//distance from srcVertex for each vertex
		int p[] = new int[weight.length];//parent vertex u for each vertex v such that d[u] + w[u][v] makes d[v] = min
		
		for(int i = 0 ; i<weight.length; i++){
			d[i] = 999999;	// maximum positve integer to simulate infinity
			p[i] = -1; // no parent at first
		}
		d[srcVertex] = 0; // distance away from the source vertex itself
		
		// |V| - 1 passes
		for(int pass = 1 ; pass <= weight.length - 1; pass++)
			for(int i = 0; i < weight.length; i++) //NOTE below
				for(int j = 0 ; j < weight[i].length; j++)//Note below
					if(weight[i][j] != 0) //it's an edge (i,j)
						if( (d[i] + weight[i][j]) < d[j]){//shorter than exsting path 
							d[j] = d[i] + weight[i][j];			
							p[j] = i;	
						}
							
			 // NOTE:
			 // ideally, i would pass in a list of edges and
			 // walk through each edge, instead of
			 // doing a search through the weight[][] to locate edges
			 // i am doing this just for the sake of easiness 
		
		/* check for negative-weight cycles
		 * by doing 1 more pass since it guarantee to have the 
		 * the shortest path from the source vertex to 
		 * all other vertices after |V|-1 passes
		 * if by doing 1 more pass, we find a path from the source vertex
		 * to any other vertex that is better than 
		 * the existing one, then there must be a negative-weight cycle*/
		for(int i = 0; i < weight.length; i++)
			for(int j = 0; j < weight[i].length; j++)
				if( weight[i][j] != 0){ //it's an edge (i,j)
					if( (d[i] + weight[i][j]) < d[j])//shorter than existing path
						return false;
				}
		
		for(int i = 0 ; i< d.length; i++)
			System.out.print( d[i] + " ");
		
		return true;
	} //runtime should be O( |V| * |E| ) but in this case
	  //adjacency matrix is used, |E| = |V|^2 in a sense that
		//the program has to check every entry to know whether or not 
		//it is an edge before doing anything

 /*========================================================*/	
}
