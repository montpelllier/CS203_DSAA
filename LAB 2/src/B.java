import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int t = input.nextInt();
		int[] labs = new int[n];
		for(int i=0;i<n;i++) {
			labs[i] = input.nextInt();
		}
		while (t-->0) {
			int en = input.nextInt();
			int left = 0;
			int right = n;
			int mid = 0;
			while(left <= right){
				mid = (left + right)/2; 
				if(en == labs[mid]) {
					System.out.println("Accept");
					break;//if equal, print and break loop
				}else if(en > labs[mid]) {
					left = mid+1;
					if(mid+1 < n-1) {//next number is bigger
						if(en < labs[mid+1]) {
						System.out.println(en-labs[mid]);
						break;
						}
					}
					if(mid == n-1) {//is the last number
						System.out.println(en-labs[mid]);
						break;
					}
				}else {
					right = mid-1;
					if(en > labs[mid-1]) {//laster number is smaller
						System.out.println(en-labs[mid-1]);
						break;
					}
				}//¸ÄÍÂÁË
			}
		}
		
		input.close();
	}
}
