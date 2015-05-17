/* Weidong Guo */
public class MST_PrimTest{
	static int randomInt(int hi){
		return (int)(Math.random()*100) % hi;
	}
		
	public static void main(String argv[]){
		
								// a  b  c  d  e  f  g  h  i 				
		int w[][] = {{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },  //a 
							   { 0, 0, 8, 0, 0, 0, 0, 11,0 },	//b
								 { 0, 8, 0, 7, 0, 4, 0, 0 ,2 },	//c
								 { 0, 0, 7, 0, 9, 14,0, 0 ,0 },	//d
  							 { 0, 0, 0, 9, 0, 10,0, 0 ,0 }, //e
								 { 0, 0, 4, 14,10,0, 2, 0, 0 }, //f
								 { 0, 0, 0, 0, 0, 2, 0, 1, 6 },	//g
								 { 8, 11,0, 0, 0, 0, 1, 0, 7 },	//h
								 { 0, 0, 2, 0, 0, 0, 6, 7, 0 },	//i
							  };
		int parent[] = MST_Prim.MST_Prim(w);
		
		for(int i =  0; i < parent.length; i++){
			System.out.println( "(" + (char)(i+'a') + ", " + (char)(parent[i]+'a')	+ ")");
		}
		System.out.println("NOTE: ` means NIL");
	}

}	
