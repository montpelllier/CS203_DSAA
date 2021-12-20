import java.util.Arrays;
import java.util.Scanner;

public class E {//»ô·òÂüÊ÷	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n;
		while(t-->0) {
			n = input.nextInt();
			int[] stick = new int[n];
			for(int i=0;i<n;i++) {
				stick[i] = input.nextInt();
			}
			Arrays.sort(stick);
			int j, temp, ans = 0;
			for(int i=1;i<n;i++) {
				j = i;
				stick[i] += stick[i-1];
				ans += stick[i];
				while(j<n-1 && stick[j]>stick[j+1]) {
					temp = stick[j+1];
					stick[j+1] = stick[j];
					stick[j++] = temp;
				}
			}
			System.out.println(ans);
		}
		
		input.close();
	}

}
