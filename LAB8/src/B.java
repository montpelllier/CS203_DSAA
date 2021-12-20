import java.util.Scanner;

public class B {
	
	public static void swap(int[] heap, int[] index, int i) {
		int temp, father = (i+1)/2-1;
		while(i>0 && (heap[father]<heap[i])) {
			temp = heap[i];
			heap[i] = heap[father];
			heap[father] = temp;
			temp = index[i];
			index[i] = index[father];
			index[father] = temp;
			i = father;
			father = (i+1)/2-1;
		}
	}//O(logn)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n, p, pos, x, y;
		int[] juan, index;
		
		while(t-->0) {
			n = input.nextInt();
			juan = new int[n];
			index = new int[n];
			for(int i=0;i<n;i++) {
				juan[i] = input.nextInt();
				index[i] = i+1;
				swap(juan, index, i);
			}
			p = input.nextInt();
			pos = -1;
			for(int i=0;i<n;i++) {//find the position in array
				if(index[i] == p) {
					pos = i;
					break;
				}
			}
			x = (int)(Math.log(pos+1)/Math.log(2));
			y = pos+1 - (int) Math.pow(2, x);
			x++;
			y++;
			System.out.println(x+" "+y);
		}
		
		input.close();
	}

}
