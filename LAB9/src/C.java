import java.util.ArrayList;
import java.util.Scanner;

public class C {//拓扑排序

	static class Node {
		int index;
		int in_degree;
		ArrayList<Node> next = new ArrayList<Node>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), m=input.nextInt(),a,b;
		//String a,b;
		Node[] nd = new Node[n+1];
		ArrayList<Integer> minheap = new ArrayList<Integer>();//字典序最小堆
		
		for(int i=1;i<=n;i++) {
			nd[i] = new Node();
			nd[i].index = i;
		}
		while(m-->0) {
			a = input.nextInt();
			b = input.nextInt();
			nd[a].next.add(nd[b]);
			nd[b].in_degree++;	
		}
		
		for(int i=1;i<=n;i++) if(nd[i].in_degree==0) add(minheap, i);
		
		while(!minheap.isEmpty()) {
			int poll = delete(minheap);
			System.out.print(poll+" ");
			for(int i=0;i<nd[poll].next.size();i++) {
				if(--nd[poll].next.get(i).in_degree==0)
					add(minheap,nd[poll].next.get(i).index);
			}
		}
		
		input.close();
	}
	
	public static void add(ArrayList<Integer> heap, int num) {
		heap.add(num);
		int index = heap.size()-1;
		int temp,father,child;
		
		while(index>0) {//比父小交换
			father = heap.get((index-1)/2);
			child = heap.get(index);
			if(child<father) {//
				temp = father;
				heap.set((index-1)/2, child);
				heap.set(index, temp);
			}else break;
			index = (index-1)/2;
		}
	}
	
	public static int delete(ArrayList<Integer> heap) {
		int index = 0;
		int father,left,right;
		int temp = heap.get(heap.size()-1);
		heap.set(heap.size()-1, heap.get(0));
		heap.set(0, temp);
		int delete = heap.remove(heap.size()-1);
		//swap the root and the last node, then delete the last one
		while(index*2+1<heap.size()) {//左节点存在，小则交换
			father = heap.get(index);
			left = heap.get(index*2+1);
			if(index*2+2<heap.size()) {//存在右节点
				right = heap.get(index*2+2);
				if(left<father && left<=right) {//左最大与左交换
					temp = left;
					heap.set(index*2+1, father);
					heap.set(index, temp);
					index = index*2+1;
				}else if(right<father && right<=left){//右最大与右交换
					temp = right;
					heap.set(index*2+2, father);
					heap.set(index, temp);
					index = index*2+2;
				}else break;//父最大不交换
			}else if(left<father){//无右节点的情况
				temp = left;
				heap.set(index*2+1, father);
				heap.set(index, temp);
				index = index*2+1;
			}else break;
		}
		return delete;
	}
	
}
