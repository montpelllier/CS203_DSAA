import java.util.ArrayList;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n, repeat;
		long sum;
		int[] hour, power;
		ArrayList<Integer> maxheap;
		while(t-->0) {
			sum = 0L;
			n = input.nextInt();
			hour = new int[n];
			power = new int[n];
			maxheap = new ArrayList<Integer>();
			for(int i=0;i<n;i++) power[i] = input.nextInt();
			for(int i=0;i<n;i++) hour[i] = input.nextInt();
			quicksort(hour,power,0,n-1);//按时间排序
			
			for(int i=n-1;i>=0;i--) {
				add(maxheap, power[i]);
				while(i>0 && hour[i]==hour[i-1]) {//时间相同的加入堆
					add(maxheap, power[--i]);
				}
				if(i>0) repeat = hour[i]-hour[i-1]>maxheap.size()? maxheap.size():hour[i]-hour[i-1];
				else repeat = hour[i]>maxheap.size()? maxheap.size():hour[i];
				for(int j=0;j<repeat;j++) {//时间差内选前k大
					sum += delete(maxheap);
				}
			}
			System.out.println(sum);
		}
		
		input.close();
	}
	
	public static void add(ArrayList<Integer> heap, int num) {
		heap.add(num);
		int index = heap.size()-1, temp,father,child;
		
		while(index>0) {//比父大交换
			father = heap.get((index-1)/2);
			child = heap.get(index);
			if(father<child) {
				temp = father;
				heap.set((index-1)/2, child);
				heap.set(index, temp);
			}else break;
			index = (index-1)/2;
		}
	}
	
	public static int delete(ArrayList<Integer> heap) {
		int index = 0,father,left,right;
		int temp = heap.get(heap.size()-1);
		heap.set(heap.size()-1, heap.get(0));
		heap.set(0, temp);
		int delete = heap.remove(heap.size()-1);//swap the root and the last node, then delete the last one
		
		while(index*2+1<heap.size()) {//左节点存在，进行比较
			father = heap.get(index);
			left = heap.get(index*2+1);
			if(index*2+2<heap.size()) {//存在右节点
				right = heap.get(index*2+2);
				if(left>father && left>=right) {//左最大与左交换
					temp = left;
					heap.set(index*2+1, father);
					heap.set(index, temp);
					index = index*2+1;
				}else if(right>father && right>=left){//右最大与右交换
					temp = right;
					heap.set(index*2+2, father);
					heap.set(index, temp);
					index = index*2+2;
				}else break;//父最大不交换
			}else if(left>father){//无右节点的情况
				temp = left;
				heap.set(index*2+1, father);
				heap.set(index, temp);
				index = index*2+1;
			}else break;
		}
		return delete;
	}
	
	static int partition(int[] n, int[] m, int left, int right) {
		int p = left;
		int pivot = n[p];
		int pivotm = m[p];
        
        while (left < right) {
            while (left < right && n[right] >= pivot) right--;
            if (left < right) {
            	m[left] = m[right];
            	n[left++] = n[right];
            }
            while (left < right && n[left] <= pivot) left++;
            if (left < right) {
            	m[right] = m[left];
            	n[right--] = n[left];
            }
        }
        n[left] = pivot;
        m[left] = pivotm;
        return left;
    }
	
    static void quicksort(int[] n, int[] m, int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, m, left, right);
            quicksort(n, m, left, dp - 1);
            quicksort(n, m, dp + 1, right);
        }
    }
    
}
