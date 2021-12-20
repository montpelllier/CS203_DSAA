import java.util.Scanner;

public class A {//merge

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
			int n = input.nextInt();
			int m = input.nextInt();
			int[] arrn = new int[n];
			int[] arrm = new int[m];
			int[] arr = new int[n+m];
			for(int i=0;i<n;i++) {
				arrn[i] = input.nextInt();
			}
			for(int i=0;i<m;i++) {
				arrm[i] = input.nextInt();
			}
			int i=0, j=0;
			for(int k=0;k<n+m;k++) {
				if(i<n && (j>=m || arrn[i]<=arrm[j])) {
					arr[k] = arrn[i++];
				}else {
					arr[k] = arrm[j++];
				}
				System.out.print(arr[k]+" ");
			}	
		}
		
 		input.close();
	}

}
