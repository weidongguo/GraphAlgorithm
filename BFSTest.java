/* Weidong Guo */
public class BFSTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
		
	public static void main(String argv[]){
		//char vertex[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		char adj[][] = { {'b', 'c'},//adj[a] 
										 {'f'}, //adj[b]
										 {'f'}, //adj[c]
										 {'c'}, //adj[d]
										 {'h', 'i', 'd'}, //adj[e]
										 {'g', 'h'}, //adj[f]
										 {'b'}, //adj[g]
										 {'e'}, //adj[h]
										 {'h'}, //adj[i]
									 };
		int dist[];
		dist = BFS.distances(adj, 'a');
		
		for(int i =  0; i < adj.length; i++){
			//System.out.println(adj[i].length);
			System.out.println( "dist away from " + (char)('a'+i) + " is " + dist[i]);
		}
	}


}	
