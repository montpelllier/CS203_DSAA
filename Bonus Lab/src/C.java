import java.util.Scanner;
import java.util.Stack;

public class C {//n�������δ�������ӣ������ٶ��ٿ������С�ĳ������ܽ�����ȫ����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n=input.nextInt(), w, h, ans=0;
		Stack<Integer> billboards = new Stack<Integer>();
		//����ջ,��֤����(��Ⱥ���û��
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
