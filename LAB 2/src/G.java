import java.util.Scanner;
import java.util.Arrays;

public class G {
	public static long Judge(int x,int arr[],int k){
		long ans = 0;
		int end = 0,num = 0;
		for(int i=0;i<arr.length;i++){
			while(end<arr.length && num<k) {
				if(arr[end++]>=x) num++;//����k�����ڵ���x����
			}
			if(num==k) ans = ans+arr.length-end+1;//û��K��������
			if(arr[i]>=x) num--;//��λ���ڵ���x,��ȥѭ������һ�����ڵ���x����
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while(t-->0) {
			int n = input.nextInt(), k = input.nextInt(), m = input.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = input.nextInt();
			}
			int right  = Arrays.stream(arr).max().getAsInt();
			int left = Arrays.stream(arr).min().getAsInt();
			int mid;
			while(left < right){
				mid = (left+right+1)/2;
				if(Judge(mid,arr,k) >= m) {//���ִ�
					left = mid;
				}else {
					right = mid-1;
				}
			}
		System.out.println(left);
		}
		
		input.close();
	}
}
