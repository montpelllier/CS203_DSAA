import java.util.Scanner;

public class G {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-->0) {
			long n = input.nextLong();
			int s = input.nextInt();
			long temp = n;
			long temp2 = 1;
			long sum = 0;
			String ns = String.valueOf(n);
			int length = ns.length();
			long arr[] = new long[length];
			long fvalue = 0;
			for(int i=0;i<length;i++) {
				arr[i] = temp%10;
				temp = temp/10;
				sum = sum + arr[i];
			}//�õ�ÿ����λ�ϵ�����
			if(sum<=s) {
				System.out.println(fvalue);//step = 0
			}else {
				long a = 0;
				for(int i=length;i>0;i--) {
					if(a+arr[i-1]+1>s) {
						for(int j=0;j<i;j++) {
							temp2 = temp2*10;
						}
						fvalue = fvalue + temp2;
						break;//��һλ����֮ǰ����λ��֮�ʹ���s,ֹͣѭ��,������10^(��������λ)
					}else {
						a = a + arr[i-1];
						for(int j=0;j<i-1;j++) {
							arr[i-1] = arr[i-1]*10;
						}
						fvalue = fvalue + arr[i-1];
					}//�õ�����ǰ����λ��֮�ͼ�һ��С��s������������������ԭ��λ
				}
				System.out.println(fvalue-n);//other situations
			}	
		}
		
		input.close();
	}
}