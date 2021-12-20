import java.util.Scanner;
import java.util.Stack;

public class C {//n个长方形从左到右相接，求至少多少块任意大小的长方形能将其完全覆盖

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), w, h, ans=0;
		Stack<Integer> billboards = new Stack<Integer>();
		//单调栈,保证递增(宽度好像没用
		while(n-->0) {
			w = input.nextInt();
			h = input.nextInt();
			while(!billboards.isEmpty() && billboards.peek()>h) {
				billboards.pop();
			}
			if(billboards.isEmpty() || billboards.peek()<h) {
				billboards.push(h);
				ans++;
			}
		}
		System.out.println(ans);
		
		input.close();
	}

}
