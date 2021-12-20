import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class D {

	static class Edge {
		int weight;
		boolean isvisited;
		Vertex vertex1;
		Vertex vertex2;
	}
	
	static class Vertex {
		int coef;
		boolean isvisited;
		ArrayList<Edge> edge = new ArrayList<Edge>();
	}
	
	static Comparator<Edge> cmp = new Comparator<Edge>() {//自定义比较器
		public int compare(Edge e1, Edge e2) {
			return e2.weight-e1.weight;
		}
	};
	
	public static void main(String[] args) {//最大生成树
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt();
		long ans = 0L;
		Vertex[][] grid = new Vertex[n+1][m+1];

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				grid[i][j] = new Vertex();
				grid[i][j].coef = input.nextInt();
			}
		}
		Edge[][] col_edge = new Edge[n][m+1];
		Edge[][] row_edge = new Edge[n+1][m];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(i<n) {
					col_edge[i][j] = new Edge();
					grid[i][j].edge.add(col_edge[i][j]);
					grid[i+1][j].edge.add(col_edge[i][j]);
					col_edge[i][j].vertex1 = grid[i][j];
					col_edge[i][j].vertex2 = grid[i+1][j];
					col_edge[i][j].weight = grid[i][j].coef*grid[i+1][j].coef;
				}
				if(j<m) {
					row_edge[i][j] = new Edge();
					grid[i][j].edge.add(row_edge[i][j]);
					grid[i][j+1].edge.add(row_edge[i][j]);
					row_edge[i][j].vertex1 = grid[i][j];
					row_edge[i][j].vertex2 = grid[i][j+1];
					row_edge[i][j].weight = grid[i][j].coef*grid[i][j+1].coef;
				}
				
			}
		}
		PriorityQueue<Edge> heap = new PriorityQueue<Edge>(cmp);//weight作优先度的最小堆
		
		grid[1][1].isvisited = true;
		for(int i=0;i<grid[1][1].edge.size();i++) heap.add(grid[1][1].edge.get(i));		
		while(!heap.isEmpty()) {//遍历所有的边
			Edge poll = heap.poll();
			poll.isvisited = true;
			Vertex next = notintree(poll);//找到边上不在树上的点
			if(next != null) {//两点都在树上，次边无效
				ans += poll.weight;
				next.isvisited = true;
				for(int i=0;i<next.edge.size();i++) {
					if(!next.edge.get(i).isvisited) heap.add(next.edge.get(i));
				}
			}
		}
		System.out.println(ans);
		
		input.close();
	}
	
	public static Vertex notintree(Edge edge) {
		if(edge.vertex1.isvisited && edge.vertex2.isvisited) return null;
		else if(!edge.vertex1.isvisited) return edge.vertex1;
		else return edge.vertex2;
	}
	
}

