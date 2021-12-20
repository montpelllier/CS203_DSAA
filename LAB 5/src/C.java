import java.util.Scanner;

public class C {

	static class Node {
		Node next;
		Node prev;
		int data = -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			int n = in.nextInt(), q = in.nextInt();
			int oper, u, v, w, val;
			Node front[] = new Node[n+1];
			Node rear[] = new Node[n+1];
			for(int i=1;i<=n;i++) {
				front[i] = new Node();
				rear[i] = new Node();
				front[i].next = rear[i];
				rear[i].prev = front[i];
			}
			
			while(q-->0) {
				oper = in.nextInt();
				u = in.nextInt();
				if(oper == 1) {
					w = in.nextInt();
					val = in.nextInt();
					if(w == 0) Frontinsert(front[u], val);//insert at front
					else Endinsert(rear[u], val);//insert at rear
				}else if(oper == 2) {
					w = in.nextInt();
					if(w == 0) {
						System.out.println(front[u].next.data);//Êä³ö
						if(front[u].next.data != -1) {//²»Îª¿Õ£¬É¾³ý
							front[u].next = front[u].next.next;
							front[u].next.prev = front[u];
						}
					}else if(w == 1) {
						System.out.println(rear[u].prev.data);
						if(rear[u].prev.data != -1) {
							rear[u].prev = rear[u].prev.prev;
							rear[u].prev.next = rear[u];
						}
					}
				}else if(oper == 3) {
					v = in.nextInt();
					w = in.nextInt();
					if(front[v].next.data != -1) {
						if(w == 1) reverse(front[v], rear[v]);//µ¹Ðò
						connect(rear[u], front[v], rear[v]);
					}
				}
			}
		}
		
		in.close();
	}
	
	public static void Endinsert(Node rear, int data) {
		rear.prev.next = new Node();
		rear.prev.next.next = rear;
		rear.prev.next.prev = rear.prev;
		rear.prev = rear.prev.next;
		rear.prev.data = data;
	}
	
	public static void Frontinsert(Node front, int data) {
		front.next.prev = new Node();
		front.next.prev.prev = front;
		front.next.prev.next = front.next;
		front.next = front.next.prev;
		front.next.data = data;
	}
	
	public static void reverse(Node front, Node rear) {//exchange the data, no problem
		Node f = front.next;
		Node r = rear.prev;
		int temp;
		while(true) {
			if(f == r || f.prev == r) break;
			temp = f.data;
			f.data = r.data;
			r.data = temp;
			f = f.next;
			r = r.prev;
		}
	}
	
	public static void connect(Node rear1, Node front2, Node rear2) {
		rear1.prev.next = front2.next;
		rear1.prev.next.prev = rear1.prev;
		rear1.prev = rear2.prev;
		rear2.prev.next = rear1;
		rear2.prev = front2;
		front2.next = rear2;
	}

}
