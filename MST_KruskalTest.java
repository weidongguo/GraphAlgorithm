import java.util.ArrayList;
/* Weidong Guo */
public class MST_KruskalTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
		
	public static void main(String argv[]){
											// u, v, w
		int edgeInfo[][]={ { 0, 1, 2},
											 { 0, 6, 8},
											 { 0, 5, 14},
											 { 1, 5, 25},
											 { 1, 2, 19},
											 { 2, 5, 17},
											 { 2, 4, 5},
											 { 2, 3, 9},
											 { 3, 4, 1},
											 { 4, 5, 13},
											 { 5, 6, 21},
										};
		int numberOfVertices = 7; // eyeballed this, bad practice.
															// anyway, should be user input

		Edge E[] = new Edge[edgeInfo.length];	//array of obj references
		for(int i = 0 ; i < edgeInfo.length; i++){
			E[i] = new Edge(edgeInfo[i][0], edgeInfo[i][1], edgeInfo[i][2]);
			System.out.println(E[i].u + " " + E[i].v + " " + E[i].w);	
		}
		ArrayList<Edge> MST = MST_Kruskal.MST_Kruskal(E, numberOfVertices);
		System.out.println("The minimum spanning tree for the problem:");
		for(int i = 0; i < MST.size(); i++){
			System.out.println(MST.get(i));
		}

	}

}	
