import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class E {
	
	static class Node {
		int index;
		int in_degree;
		boolean isvisited = false;
		ArrayList<Integer> neighbour = new ArrayList<Integer>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt(),a=input.nextInt(),b=input.nextInt(),u,v;
		Node[] city = new Node[n+1];
		for(int i=1;i<=n;i++) city[i] = new Node();
		while(m-->0) {
			u = input.nextInt();
			v = input.nextInt();
			city[u].neighbour.add(v);
			city[v].neighbour.add(u);
		}
		
		Queue<Integer> bfs = new LinkedList<Integer>();
		int x = 2, y = 2,poll;
		//将b删去后,从a开始遍历
		bfs.add(a);
		city[a].isvisited=true;
		while(!bfs.isEmpty()) {
			poll = bfs.poll();
			for(int i=0;i<city[poll].neighbour.size();i++) {
				if(!city[city[poll].neighbour.get(i)].isvisited&&city[poll].neighbour.get(i)!=b) {
					bfs.add(city[poll].neighbour.get(i));
					city[city[poll].neighbour.get(i)].isvisited = true;
					x++;
				}
			}
		}
		bfs.clear();
		for(int i=1;i<=n;i++) city[i].isvisited = false;
		//删a,从b遍历
		bfs.add(b);
		city[b].isvisited=true;
		while(!bfs.isEmpty()) {
			poll = bfs.poll();
			for(int i=0;i<city[poll].neighbour.size();i++) {
				if(!city[city[poll].neighbour.get(i)].isvisited&&city[poll].neighbour.get(i)!=a) {
					bfs.add(city[poll].neighbour.get(i));
					city[city[poll].neighbour.get(i)].isvisited = true;
					y++;
				}
			}
		}
		
		System.out.println((n-x)*(n-y));
		
		input.close();
	}

}
