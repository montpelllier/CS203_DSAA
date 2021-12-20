import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-->0) {
			int n = input.nextInt();
			int[] pile = new int[n];
			for(int i=0;i<n;i++) {
				pile[i] = input.nextInt();
			}
			int output = 0;
			int a = pile[0];
			for(int i=1;i<n;i++) 
				a = a^pile[i];//XOR: 0 or 1; win or lose
		    if(a != 0){
		        for(int i = 0;i < n;i++)
		            {
		                int tmp = a ^ pile[i]; //令第i堆拿走后剩下 pile[i](原本的数量)^a,才能使其与其余数的异或认为0,同时其值小于pile[i]
		                if(tmp < pile[i])
		                    output++;
		            }
		        }
			System.out.println(output);
		}
		
		input.close();
	}

}
