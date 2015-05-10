import java.util.Arrays;
import java.util.Queue; //interface
import java.util.PriorityQueue;//implementing class of Queue

public class BFS{ //Breadth First Search
	public static int[] distances(char adj[][], char src){
		int dist[] = new int[ adj.length +1];	
		Arrays.fill(dist, (-1>>>1)) ;
		// (-1>>>1) gives the max signed nteger for 32 bits 	
		dist[src-'a'] = 0; //distance to the source itself is 0
		
		/*initialize a queue*/	
		Queue<Integer> Q = new PriorityQueue<Integer>();
		Q.add(src-'a');//put source vertex index in queue to start!

		Integer u;
		while( (u = Q.poll()) != null){
			System.out.println( (char)(u+'a'));
			for(int v = 0; v < adj[u].length; v++){ //go through neighbor vertices
				System.out.println("go through neigbour " + adj[u][v]);	
				if(dist[ adj[u][v] - 'a' ] == (-1>>>1) ){//distance not set yet
					dist[ adj[u][v] - 'a' ] = dist[u] + 1;//1 unit of distance more	
					Q.add( adj[u][v] - 'a' ); //push vertices for next level inspection
					System.out.println("vertex "  + (adj[u][v] ) + " pushed");	
				}
			}
			System.out.println();
		}
		return dist;
	}
}
