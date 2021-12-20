import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class F {
	
	static class treeNode {
		int city;
		int dis;
		boolean isvisited = false;
		boolean haspeople = false;
		ArrayList<treeNode> sons = new ArrayList<treeNode>();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n, k, a=-1, b;
		treeNode[] city;
		while(t-->0) {
			n = input.nextInt();
			k = input.nextInt();
			city = new treeNode[n];
			for(int i=0;i<n;i++) {
				city[i] = new treeNode();
				city[i].city = i;
			}//create cities	
			for(int i=0;i<n-1;i++) {
				a = input.nextInt()-1;
				b = input.nextInt()-1;
				city[a].sons.add(city[b]);
				city[b].sons.add(city[a]);
			}//connect cities
			for(int i=0;i<k;i++) {
				a = input.nextInt()-1;
				city[a].haspeople = true;
			}//add people
			if(k>1) {
				int far = 0, maxdis = 0;//令city[a]为root开始遍历
				city[a].isvisited = true;
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(a);
				
				while(!queue.isEmpty()) {
					a = queue.poll();
					for(int i=0;i<city[a].sons.size();i++) {
						if(!city[a].sons.get(i).isvisited) {//没走过的才访问
							queue.add(city[a].sons.get(i).city);
							city[a].sons.get(i).isvisited = true;
							if(city[a].sons.get(i).haspeople) {
								far = city[a].sons.get(i).city;//get farest city
							}
						}
					}
				}
				
				for(int i=0;i<n;i++) city[i].isvisited = false;//初始化
				queue.add(far);
				city[far].isvisited = true;//far为根开始遍历
				while(!queue.isEmpty()) {
					a = queue.poll();
					for(int i=0;i<city[a].sons.size();i++) {
						if(!city[a].sons.get(i).isvisited) {
							city[a].sons.get(i).dis = city[a].dis+1;
							queue.add(city[a].sons.get(i).city);
							city[a].sons.get(i).isvisited = true;
							if(city[a].sons.get(i).haspeople) {
								maxdis = city[a].sons.get(i).dis;//get max dis
							}
						}
					}
				}
				System.out.println((maxdis+1)/2);
			}else System.out.println(0);//k为1答案为0			
		}
		
		input.close();
	}
	
}
