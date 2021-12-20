import java.util.ArrayList;
import java.util.Scanner;

public class F {

	static class Edge {
		int weight;
		boolean isportal;
		Vertex origin;
		Vertex destination;
	}
	
	static class Vertex {
		boolean shortest;
		long dis;
		ArrayList<Edge> edge = new ArrayList<Edge>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt(), p=input.nextInt(), k=input.nextInt();
		int u,v,w;
		
		//int[][] adjacency = new int[n+1][n+1];
		while(m-->0) {
			u = input.nextInt();
			v = input.nextInt();
			w = input.nextInt();
			//adjacency[u][v] = w;
			
			
		}
		
		
		
		input.close();
	}

}
