import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class A {

	static class Edge {
		int weight;
		boolean intree;
		Vertex vertex1;
		Vertex vertex2;
	}
	
	static class Vertex {
		boolean intree;
		ArrayList<Edge> edge = new ArrayList<Edge>();
	}
	
	static Comparator<Edge> cmp = new Comparator<Edge>() {//自定义比较器
		public int compare(Edge e1, Edge e2) {
			return e1.weight-e2.weight;
		}
	};
	
	public static void main(String[] args) {//最小生成树
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt(),u,v,w;
		long ans = 0L;
		Vertex[] city = new Vertex[n+1];
		for(int i=1;i<=n;i++) city[i] = new Vertex();
		Edge[] road = new Edge[m];
		
		for(int i=0;i<m;i++) {
			road[i] = new Edge();
			u = input.nextInt();
			v = input.nextInt();
			w = input.nextInt();
			road[i].vertex1 = city[u];//完成边的数据结构
			road[i].vertex2 = city[v];
			road[i].weight = w;
			city[u].edge.add(road[i]);//完成点的数据结构
			city[v].edge.add(road[i]);
		}
		PriorityQueue<Edge> heap = new PriorityQueue<Edge>(cmp);//weight作优先度的最小堆
		
		city[1].intree = true;
		for(int i=0;i<city[1].edge.size();i++) heap.add(city[1].edge.get(i));		
		while(!heap.isEmpty()) {
			Edge poll = heap.poll();
			poll.intree = true;
			Vertex next = notintree(poll);
			if(next != null) {//
				ans += poll.weight;
				next.intree = true;
				for(int i=0;i<next.edge.size();i++) {
					if(!next.edge.get(i).intree) heap.add(next.edge.get(i));
				}
			}
		}
		System.out.println(ans);
		
		input.close();
	}
	
	public static Vertex notintree(Edge edge) {
		if(edge.vertex1.intree && edge.vertex2.intree) return null;
		else if(!edge.vertex1.intree) {
			//edge.vertex1.intree = true;
			return edge.vertex1;
		}else {
			//edge.vertex2.intree = true;
			return edge.vertex2;
		}
	}
	
}
