/* Weidong Guo */
public class DFSTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
		
	public static void main(String argv[]){
		//char vertex[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
		/*char adj[][] = { {'b', 'c'},//adj[a] 
										 {'f'}, //adj[b]
										 {'f'}, //adj[c]
										 {'c'}, //adj[d]
										 {'d', 'h', 'i'}, //adj[e]
										 {'g', 'h'}, //adj[f]
										 {'b'}, //adj[g]
										 {'e'}, //adj[h]
										 {'h'}, //adj[i]
		};*/
		char adj[][] = { {'b', 'd'}, //adj[a]
										 {'e'}, //adj[b]
										 {'e', 'f'}, //adj[c] 
										 {'b'}, //adj[d]
										 {'d'}, //adj[e]
										 {'c', 'f'}, //adj[f]
		};
		int numberOfVertices = adj.length;	
		int d[] = new int[numberOfVertices];//discovery time;
		int f[] = new int[numberOfVertices];//finish time;
		DFS.DFS(adj, d, f);	
		
		for(int i =  0; i < adj.length; i++){
			System.out.println("The discovery time for vertex " + (char)(i+'a') +
			" is " + d[i] +
			"\nthe finish time for it is " + f[i]);	
		}
	}


}	
