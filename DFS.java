/*Weidong Guo*/
enum Color {
	WHITE,
	GRAY,
	BLACK;	
}

public class DFS{ //Depth First Search
	static int time; 
	public static void DFS(char adj[][], int d[], int f[]){
		/* Input Parameters: adjacency list adj[][] <-> graph represetation
		 * Output Parameters: d[] for discovery time, f[] for finish time
		 */
		Color color[] = new Color[adj.length];//adj.length=number of vertices
		time = 0 ;	
		for(int i = 0 ; i < color.length; i++) //initialize each vertex to have color WHITE
			color[i] = Color.WHITE;
		for(int u = 0 ; u < adj.length; u++)//go through each vertex
			if(color[u] == Color.WHITE) //new vertex just discovered
					DFS_VISIT(u, adj, d, f, color);	

	}
	 
	static void DFS_VISIT(int u, char adj[][], int d[], int f[], Color color[]){
		/* Input Paramemters: vertex u, time, adjacency list adj[][]	
		 * Output Parameters: d[] for discovery time, f[] for finish time	
		 *										color for representating vertex's progress
		 */
		time = time + 1;
		d[u] = time;
		color[u] = Color.GRAY; 	
		for(int i = 0 ; i < adj[u].length; i++){
			/* i is only the index of neigbour vertices for vertex u
			 * the actual vertex is adj[u][i] - 'a' to get its number rep
			 */
			 if( color[ adj[u][i] - 'a'] == Color.WHITE )
				 /* go as far as possible */
				 DFS_VISIT( adj[u][i] - 'a', adj, d, f, color ); //recursive call
		}
		/* gets back from recursive call, meaning finished */
		time = time + 1;
		f[u] = time;
		color[u] = Color.BLACK;
	}
}
/* Big Theta of ( |V| ) since every vertices is processed at least
		/* twice for the discovery time and finish time
		/* Big Theta of ( |E| ) since every edges are touched once
		/* Total: Big Theta of ( |V| + |E| ); 
		 */
