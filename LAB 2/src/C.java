import java.util.Scanner;

public class C {//���ֵ��С������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int s = input.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = input.nextInt();
		}
		long ans = 0L;
		for(int i=0;i<n;i++) {
			int left = i + 1, right = n - 1;
			while(left < right) {//�������������м����
				if(arr[i]+arr[left]+arr[right] == s) {
					if(arr[left] == arr[right]) {//���
						int temp = right - left;
						ans = ans + temp*(temp+1)/2;
						break;	
					}else if(arr[right] == arr[right-1] || arr[left] == arr[left+1]) {//һ���ظ�
						int r = right, l = left,a = 1, b = 1;
						while(arr[r]==arr[r-a]) {
							a++;
						}
						while(arr[l]==arr[l+b]) {
							b++;
						}
						ans = ans + a*b;
						right = right - a;
						left = left + b;
					}else {
						ans++;
						right--;
					}
				}else if(arr[i]+arr[left]+arr[right] < s) {
					left++;
				}else {
					right--;
				}
			}
		}
		System.out.print(ans);
		
		input.close();
	}

}
