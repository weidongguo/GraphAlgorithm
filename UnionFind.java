import java.util.Arrays;

public class UnionFind{ /* note: no dynamic expansion of set size*/
	private int []parent; 
	/* parent of the element, trace it all the way to the element whose
	 * parent is -1 tells you that such element is the canonical name
	 * for the set */ 
	private int size;
	
	UnionFind(int n){
		size = n;
		parent = new int[n];
		Arrays.fill(parent, -1);
	}

	public void union(int i, int j){
		i = simpleFind(i);// find what set i is in 
		j = simpleFind(j);// find what set j is in
		int total = parent[i] + parent[j]; //it's negative 
		/* abs(total) tells	the number of elements in the set */

		if( parent[i] > parent[j]){
		// the smaller, the more negative, therefore contains more elements
			parent[i] = j; // set_j has more elements in this case	
			parent[j] = total; //# of elements are in this set after union
		}
		else{ // i has more elements
			parent[j] = i;
			parent[i] = total;
		}	
	}

	public int simpleFind(int i){
		while(parent[i] >= 0 ) //trace until the ancestor is reached
			i = parent[i]; 
		return i;		
	} //returns the canonical representation of the set;


	public int collapsingFind(int i){
		int next, root = simpleFind(i);
		while( i != root ){
			next = parent[i];
			parent[i] = root; //collapse, rename its set name to its ancestor
			i = next;	
		}
		return root;
	} /* Though, it cost more up front than simpleFind(),
	   * collapsingFind do goods for the future
		 * (i.e. no need to trace later on because of the renaming
		 * to match its ancestor(already at the top, no tracing)
		 */
}
