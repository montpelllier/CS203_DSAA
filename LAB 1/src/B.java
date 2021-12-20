import java.util.Scanner;
import java.math.*;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-->0) {
			int n = input.nextInt();
			String three = "3";
			String one = "1";
			String mod = "1000000007";
			BigInteger big1 = new BigInteger(one);
			BigInteger big3 = new BigInteger(three);
			BigInteger bigmod = new BigInteger(mod);
			BigInteger a = big3.pow(n);//step = 3^n-1
			BigInteger b = a.subtract(big1);
			BigInteger c = b.mod(bigmod);
			System.out.println(c);
		}
		
		input.close();
	}
}