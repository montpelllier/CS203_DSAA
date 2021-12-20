import java.util.Scanner;

public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-->0) {
			int n = input.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = input.nextInt();
			}
			int k1 = 0;
			int k2 = 1;
			int max = a[k1] - a[k2];
			while(k2<a.length-1) {
				while(a[k2] < a[k1] && k2 < a.length-1) {
					if(a[k1] - a[k2] > max) {
						max = a[k1] - a[k2];//更新最大差值
					}
					++k2;
				}
				k1 = k2; //从目前最大值开始
				++k2;
			}
			System.out.println(max);
		}
		
		input.close();
	}

}
