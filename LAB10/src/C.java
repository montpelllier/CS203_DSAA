import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class C {
	
	static class Vertex {
		int height;
		double time = 16384.00;//max time: 2^14 
		double velocity;
		boolean shortest;
		boolean inQueue;
		Vertex up, down, left, right;
	}
	
	static Comparator<Vertex>com = new Comparator<Vertex>() {
		public int compare(Vertex v1, Vertex v2) {
			if(v1.time-v2.time>0) return 1;
			else if(v1.time-v2.time<0) return -1;
			else return 0;
		}
	};

	public static void main(String[] args) {//Dijkstra
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt();
		Vertex poll;
		Vertex[][] grid = new Vertex[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				grid[i][j] = new Vertex();
				grid[i][j].height = input.nextInt();
				if(i==1 && j==1) grid[i][j].velocity = 1;
				else grid[i][j].velocity = Math.pow(2, grid[1][1].height-grid[i][j].height);
			}//get the velocity from the height of each vertex
		}
		for(int i=1;i<=n;i++) {//connect vertices
			for(int j=1;j<=m;j++) {
				grid[i][j].up = grid[i-1][j];
				grid[i][j].left = grid[i][j-1];
				if(i<n) grid[i][j].down = grid[i+1][j];
				if(j<m) grid[i][j].right = grid[i][j+1];
			}
		}
		
		Queue<Vertex> q = new PriorityQueue<Vertex>(com);
		grid[1][1].time = 0;
		q.add(grid[1][1]);
		while(!q.isEmpty()) {
			poll = q.poll();
			poll.shortest = true;
			adjest(q,poll,poll.up);
			adjest(q,poll,poll.down);
			adjest(q,poll,poll.left);
			adjest(q,poll,poll.right);
		}
		System.out.println(String.format("%.2f",grid[n][m].time));//保留两位小数

		input.close();
	}
	
	public static void adjest(Queue<Vertex> queue, Vertex vx, Vertex neb) {
		if(neb!=null && !neb.shortest) {
			if(1/vx.velocity+vx.time < neb.time) {
				neb.time = 1/vx.velocity+vx.time;
				if(neb.inQueue) queue.remove(neb);//先删后加，保证queue优先度不受破坏
				queue.add(neb);
				neb.inQueue = true;
			}
		}
	}

}
