import java.util.ArrayList;
import java.util.Scanner;

public class C {//��������

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
		ArrayList<Integer> minheap = new ArrayList<Integer>();//�ֵ�����С��
		
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
		
		while(index>0) {//�ȸ�С����
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
		while(index*2+1<heap.size()) {//��ڵ���ڣ�С�򽻻�
			father = heap.get(index);
			left = heap.get(index*2+1);
			if(index*2+2<heap.size()) {//�����ҽڵ�
				right = heap.get(index*2+2);
				if(left<father && left<=right) {//��������󽻻�
					temp = left;
					heap.set(index*2+1, father);
					heap.set(index, temp);
					index = index*2+1;
				}else if(right<father && right<=left){//��������ҽ���
					temp = right;
					heap.set(index*2+2, father);
					heap.set(index, temp);
					index = index*2+2;
				}else break;//����󲻽���
			}else if(left<father){//���ҽڵ�����
				temp = left;
				heap.set(index*2+1, father);
				heap.set(index, temp);
				index = index*2+1;
			}else break;
		}
		return delete;
	}
	
}
