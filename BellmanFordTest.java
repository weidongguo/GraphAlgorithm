/* Weidong Guo */
public class BellmanFordTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
		
	public static void main(String argv[]){
								//vertex 0  1  2
		int weight[][] = {	{0, 2, 6},  //vertex 0
												{0, 0, 3},  //vertex 1
												{0,-5, 0},  //vertex 2 
		};
							 //vertex 0	 1	2  3  4	
	 int weight2[][] = { {0,-1, 4, 0, 0}, //vertex 0 
											 {0, 0, 3, 2, 2}, //vertex 1 
											 {0, 0, 0, 0, 0}, //vertex 2 
										 	 {0, 1, 5, 0, 0}, //vertex 3 
											 {0, 0, 0,-3, 0}, //vertex 4 
		};//             if changes  ^ to a -4, there will be a neg.w.cycle
	 
	 						 //vertex 0	 1	2  3  4	
	 int weight3[][] = { {0,-1, 4, 0, 0}, //vertex 0 
										 	 {0, 0, 3, 2, 2}, //vertex 1 
										 	 {0, 0, 0, 0, 0}, //vertex 2 
										 	 {0, 1, 5, 0, 0}, //vertex 3 
										 	 {0, 0, 0,-4, 0}, //vertex 4 
	 };

		System.out.println( BellmanFord.BellmanFord(weight, 0) );
		System.out.println( BellmanFord.BellmanFord(weight2, 0) );
		System.out.println( BellmanFord.BellmanFord(weight3, 0) );
	}
}	
