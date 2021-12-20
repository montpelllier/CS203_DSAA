import java.util.Scanner;

public class A {//heap 完全二叉树，>=/<=

	static class treeNode {
		int value;
		treeNode lnd;//左节点
		treeNode rnd;//右节点
	}
	
	static class Node {
		Node next;
		Node prev;
		treeNode data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n, x, y, root=-1;
		treeNode[] tree;
		treeNode pop;
		int[] roots;
		String ans;
		for(int cas=1;cas<=t;cas++) {
			boolean isheap=true, max=true, min=true, l=true, r=true;
			n = input.nextInt();
			tree = new treeNode[n];
			roots = new int[n];
			for(int i=0;i<n;i++) {
				tree[i] = new treeNode();
				tree[i].value = input.nextInt();
			}
			for(int i=0;i<n-1;i++) {
				x = input.nextInt()-1;//x is the parent
				y = input.nextInt()-1;//y is the child
				roots[y] = 1;
				if(tree[x].lnd == null) tree[x].lnd = tree[y];
				else if(tree[x].rnd == null) tree[x].rnd = tree[y];
				else {//check binary
					isheap = false;
					break;
				}
				if(max||min) {
					if(max) max = tree[x].value>=tree[y].value? true:false;
					if(min) min = tree[x].value<=tree[y].value? true:false;
				}else isheap = false;
				if(!(max||min)) {//check heap property
					isheap = false;
				}
			}//create the binary tree, O(n)
			
			if(isheap) {//check complete
				for(int i =0;i<n;i++) {//find the root;
					if(roots[i] != 1) {
						root = i;
						break;
					}
				}
				Node head = new Node();
				Node tail = new Node();
				head.next = tail;
				tail.prev = head;
				Enqueue(tail, tree[root]);
				while(head.next != tail) {
					pop = head.next.data;
					if(pop.lnd != null) {
						Enqueue(tail, pop.lnd);
						if(!l) {//已经出现叶节点，此后都应为叶节点
							isheap = false;
							break;
						}
						if(pop.rnd != null) {
							Enqueue(tail, pop.rnd);
							if(!r) {//同l
								isheap = false;
								break;
							}
						}else r = false;
					}else l = false;
					Dequeue(head);
				}					
			}
			
			ans = isheap? "YES":"NO";
			System.out.println("Case #"+cas+": "+ans);
		}
		
		input.close();
	}
	
	public static void Enqueue(Node tail, treeNode data) {
		tail.prev.next = new Node();
		tail.prev.next.next = tail;
		tail.prev.next.prev = tail.prev;
		tail.prev = tail.prev.next;
		tail.prev.data = data;
	}
	
	public static void Dequeue(Node head) {
		head.next.next.prev = head;
		head.next = head.next.next;
	}
	
}
