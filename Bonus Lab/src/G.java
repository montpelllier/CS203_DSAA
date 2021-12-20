import java.util.ArrayList;
import java.util.Scanner;

public class G {
	
	static class Node {
		int index;
		int path = -1;
		boolean isvisited;
		boolean portal;
		ArrayList<Node> next = new ArrayList<Node>();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t=input.nextInt(), n, m;
		//Node[][] cell;
		String[][] map;
		Integer[][] dis;
		Integer S, T;
		
		while(t-->0) {
			n = input.nextInt();
			m = input.nextInt();
			dis = new Integer[n+1][m+1];
			map = new String[n][m];
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					map[i][j] = input.next();
					S = dis[i][j];
					//cell[i][j] = new Node();
				}
			}
			
			
			
		}
		
		input.close();
	}

}
