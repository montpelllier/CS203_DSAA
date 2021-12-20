import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		String a = "Alice";
		String b = "Bob";
		while (t-->0) {
			int n = input.nextInt();
			int m = input.nextInt();
			String winner;
			if(m==1&&n==1) {
				winner = b;
			}else {
				winner = a;
			}//yyds: Alice, except n=m=1
			System.out.println(winner);
		}
		
		input.close();
	}

}
