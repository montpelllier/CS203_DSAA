import java.util.Scanner;
import java.util.Arrays;

public class D {
	public static boolean Judge(int a[], int n, int m, int max) {
		int sum = 0, people = 1;
		for(int i=0;i<n;i++) {
			if(a[i]>max) {
				return false;
			}//存在单个元素大于最大值，返回F
			sum = sum + a[i];
			if(sum>max) {
				people++;
				sum = a[i];//连续元素大于max，则下次从该元素开始遍历
			}
			if(people>m) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int L = input.nextInt();
		int[] position = new int[n+1];
		int[] distance = new int[n];
		position[n] = L;
		int right = 0;
		for(int i=0;i<n;i++) {
			position[i] = input.nextInt();
		}
		for(int i=0;i<n;i++) {
			distance[i] = position[i+1] - position[i];
			right = right + distance[i];//右界：元素之和
		}
		int left = Arrays.stream(distance).max().getAsInt();//左界：数组中元素最大值
		while(left<right) {
			int mid = (left+right)/2;
			if(Judge(distance, n, m, mid)) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}//用二分找到最小的最大值
		System.out.print(right);
		
		input.close();
	}
	
}
