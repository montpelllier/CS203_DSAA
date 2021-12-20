import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;




public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> q1 = new ArrayList<Integer>();
	//	System.out.print(String.format("%.2f", a));
		q1.add(3);q1.add(4);q1.add(0);q1.add(5);q1.add(2);q1.add(null);
		//while (!q1.isEmpty()) {
			//System.out.print(q1.poll()+" ");
		//}
		q1.remove(0);
		for(int i=0;i<q1.size();i++) {
			System.out.print(q1.get(i)+" ");
		}
	}

}
