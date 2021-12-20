import java.util.ArrayList;
import java.util.Scanner;

public class D {//ά����СΪk����С��

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int k = input.nextInt();
		int s = input.nextInt();
		long a, n, lastans = s;
		ArrayList<Long> minheap = new ArrayList<Long>();
		t = t/100*100;//���λ��ʮλΪ0
		
		for(int i=1;i<=t;i++) {
			n = lastans + i;
			a = n + digitsum(n);
			if(minheap.size()==k && a!=minheap.get(0)) {
				add(minheap,a);
				delete(minheap);
			}else if(minheap.size()<k) add(minheap,a);
			if(i%100 == 0) {
				lastans = minheap.get(0);
				System.out.print(lastans+" ");
			}
		}
		
		input.close();
	}
	
	public static long digitsum(long n) {
		long sum = 0L;
		while(n>0) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
	
	public static void add(ArrayList<Long> heap, long num) {
		heap.add(num);
		int index = heap.size()-1;
		long temp,father,child;
		
		while(index>0) {//�ȸ�С����
			father = heap.get((index-1)/2);
			child = heap.get(index);
			if(child<father) {
				temp = father;
				heap.set((index-1)/2, child);
				heap.set(index, temp);
			}else break;
			index = (index-1)/2;
		}
	}
	
	public static long delete(ArrayList<Long> heap) {
		int index = 0;
		long father,left,right;
		long temp = heap.get(heap.size()-1);
		heap.set(heap.size()-1, heap.get(0));
		heap.set(0, temp);
		long delete = heap.remove(heap.size()-1);
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
