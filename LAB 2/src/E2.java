import java.util.Scanner;

public class E2 {
	public static int[] ans(int t) {
		int arr[] = new int[t/2+1];
		arr[0] = 1;arr[1] = 1; arr[2] = 3;
		for(int i=2;i<t/2+1;i++) {
			if(i%2==0) {
				arr[i] = arr[i/2-1] + arr[i/2]*2;
			}else {
				arr[i] = arr[i/2]*2 + arr[i/2+1];
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1000000;
		int arr[] = ans(x);
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-->0) {
			int n = input.nextInt();
			if(n == 1) {
				System.out.println(1);
			}else 
				System.out.println(arr[n/2]);
		}
		
		input.close();
	}

}