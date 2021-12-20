import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		int output = 0;
		while (t-->0) {
			int a = input.nextInt();
			int b = input.nextInt();
			int n = input.nextInt();
			int i = n%3;
			if(i == 0) {
				output = a;
			}
			if(i == 1) {
				output = b;
			}
			if(i == 2) {
				output = a^b;
			}//直接取3的模即可
			System.out.println(output);
		}
		
		input.close();
	}
}
