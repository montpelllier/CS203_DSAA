import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class B {
	
	static class Vertex {
		boolean isvisied;
		ArrayList<Vertex> neb = new ArrayList<Vertex>();
	}

	public static void main(String[] args) {//有向图判断连通性，对原图取反，从任意一点出发遍历检验能否访问所有点
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt(),u,v;
		boolean isconnected = true;
		Vertex[] room = new Vertex[n+1];
		Vertex[] reverse = new Vertex[n+1];
		for(int i=1;i<=n;i++) {
			room[i] = new Vertex();
			reverse[i] = new Vertex();
		}
		for(int i=1;i<=m;i++) {
			 u = input.nextInt();
			 v = input.nextInt();
			 room[u].neb.add(room[v]);
			 reverse[v].neb.add(reverse[u]);
		}
		Queue<Vertex> queue = new LinkedList<Vertex>();
		queue.add(room[1]);
		room[1].isvisied = true;
		
		while(!queue.isEmpty()) {
			Vertex deq = queue.poll();
			for(int i=0;i<deq.neb.size();i++) {
				if(!deq.neb.get(i).isvisied) {
					queue.add(deq.neb.get(i));
					deq.neb.get(i).isvisied = true;
				}
			}
		}
		for(int i=1;i<=n;i++) {
			if(!room[i].isvisied) {
				isconnected = false;
				break;
			}
		}
		
		if(isconnected) {
			queue.add(reverse[1]);
			reverse[1].isvisied = true;
			while(!queue.isEmpty()) {
				Vertex deq = queue.poll();
				for(int i=0;i<deq.neb.size();i++) {
					if(!deq.neb.get(i).isvisied) {
						queue.add(deq.neb.get(i));
						deq.neb.get(i).isvisied = true;
					}
				}
			}
			for(int i=1;i<=n;i++) {
				if(!reverse[i].isvisied) {
					isconnected = false;
					break;
				}
			}
		}
		
		System.out.println(isconnected? "Bravo":"wawawa");
		
		input.close();
	}

}
