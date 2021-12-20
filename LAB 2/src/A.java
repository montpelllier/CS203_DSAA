import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		long mod = 1L;
		for(int i=0;i<9;i++) {
			mod = mod*10L;
		}
		mod = mod + 7L;
		while (t-->0) {
			long n = input.nextLong();
			long n1 = n*n;
			long n2 = (n+1)*(n+1);
			if(n%2 == 0) {
				n1 = (n1/4)%(mod);
				n2 = n2%(mod);
			}else {
				n1 = n1%(mod);
				n2 = (n2/4)%(mod);
			}
			long ans = (n1*n2)%(mod);//垃圾除法不能模，先除再模
			System.out.println(ans);
		}
		
		input.close();
	} 
}
