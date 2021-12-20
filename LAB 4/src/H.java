import java.util.Scanner;

public class H {
	static class Node {
		Node next;
		int data;
	}

	public static void insert(Node head, int p, int data) {
		Node cnd = head;
		p--;
		while(p-->0) {
			cnd = cnd.next;
		}
		Node temp = new Node();
		temp.data = data;
		temp.next = cnd.next;
		cnd.next = temp;
	}

	public static int find(Node head, int p) {
		Node cnd = head;
		while(p-->0) {
			cnd = cnd.next;
		}
		return cnd.data;
	}

	public static void remove(Node head, int p) {
		Node cnd = head;
		p--;
		while(p-->0) {
			cnd = cnd.next;
		}
		cnd.next = cnd.next.next;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(), m = input.nextInt();
		Node head = new Node(), cnd = head;
		String s;
		int p,x;
		for(int i=0;i<n;i++) {
			cnd.next = new Node();
			cnd.next.data = input.nextInt();
			cnd = cnd.next;
		}
		for(int i=0;i<m;i++) {
			s = input.next();
			p = input.nextInt();
			if(s.equals("i")) {
				x = input.nextInt();
				insert(head, p, x);
			}else if(s.equals("r")) remove(head,p);
			else if(s.equals("q")) System.out.println(find(head,p));
		}
		
		input.close();
		
	}
}
