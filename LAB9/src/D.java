import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class D {
	
	static class Node {
		int index;
	//	int in_degree;
		int path = -1;
		boolean isvisited = false;
		ArrayList<Node> next = new ArrayList<Node>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt(),u,v,w;
		Node[] city = new Node[n+1];
		Node temp;
		for(int i=1;i<=n;i++) {
			city[i] = new Node();
		}
		while(m-->0) {
			u = input.nextInt();
			v = input.nextInt();
			w = input.nextInt();
			if(w==1) city[u].next.add(city[v]);
			else {
				temp = new Node();
				city[u].next.add(temp);
				temp.next.add(city[v]);
			}
		}
		Queue<Node> bfs = new LinkedList<Node>();
		bfs.add(city[1]);
		city[1].path = 0;
		city[1].isvisited = true;
		while(!bfs.isEmpty()) {
			Node poll = bfs.poll();
			for(int i=0;i<poll.next.size();i++) {
				if(!poll.next.get(i).isvisited) {
					bfs.add(poll.next.get(i));
					poll.next.get(i).isvisited = true;
					poll.next.get(i).path = poll.path+1;
				}
			}
		}
		System.out.print(city[n].path);
		
		input.close();
	}

}
