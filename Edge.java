public class Edge{
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
