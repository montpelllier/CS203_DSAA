import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s = input.next();
		char[] ch = s.toCharArray();
		int[] next = new int[ch.length];
		int j;
		System.out.println(0);
		for(int i=1;i<ch.length;i++) {
			j = next[i-1];//��һ���ַ��Ķ�Ӧ�Ŀ�ͷλ��
			while(j>0 && ch[i] != ch[j]) {//���ظ����������ظ�Ƭ��
				j = next[j-1];
			}
			if(ch[i] == ch[j]) next[i] = j + 1;//�ַ���ͬ��+1
			System.out.println(next[i]);
		}
		
		input.close();
	}

}
