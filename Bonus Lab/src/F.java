import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class F {
	
	static Comparator<Integer> cmp = new Comparator<Integer>() {//大优先
		public int compare(Integer e1, Integer e2) {
			return e2-e1;
		}
	};

	public static void main(String[] args) {//构造最大堆
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(), m, operation;
		PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(cmp);
		
		while(n-->0) {
			operation = input.nextInt();
			m = input.nextInt();
			if(operation == 1) maxheap.add(m);		
			else {
				while(m-->1) maxheap.poll();
				System.out.println(maxheap.peek());
			}
		}
		
		input.close();
	}

}
