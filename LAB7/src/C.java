import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class C {//so silly

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();
		int t = input.nextInt(), n, node, num;
		while(t-->0) {
			n = input.nextInt();
			ArrayList<Integer>[] tree = new ArrayList[n];
			for(int i=0;i<n;i++) {
				tree[i] = new ArrayList<Integer>();
			}
			
			for(int i=2;i<n+1;i++) {
				node = input.nextInt();
				tree[node-1].add(i);
			}//store all nums with arraylist
			queue.add(1);//add the root node
			while(!queue.isEmpty()) {
				num = queue.poll();
				int len = tree[num-1].size();
				for(int j=0;j<len;j++) {
					queue.add(tree[num-1].get(j));//add all child of the poll node
				}		
				System.out.print(num+" ");
			}
			System.out.println();
		}
		
		input.close();
	}

}
