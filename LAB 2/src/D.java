import java.util.Scanner;
import java.util.Arrays;

public class D {
	public static boolean Judge(int a[], int n, int m, int max) {
		int sum = 0, people = 1;
		for(int i=0;i<n;i++) {
			if(a[i]>max) {
				return false;
			}//���ڵ���Ԫ�ش������ֵ������F
			sum = sum + a[i];
			if(sum>max) {
				people++;
				sum = a[i];//����Ԫ�ش���max�����´δӸ�Ԫ�ؿ�ʼ����
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
			right = right + distance[i];//�ҽ磺Ԫ��֮��
		}
		int left = Arrays.stream(distance).max().getAsInt();//��磺������Ԫ�����ֵ
		while(left<right) {
			int mid = (left+right)/2;
			if(Judge(distance, n, m, mid)) {
				right = mid;
			}else {
				left = mid + 1;
			}
		}//�ö����ҵ���С�����ֵ
		System.out.print(right);
		
		input.close();
	}
	
}
