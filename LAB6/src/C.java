import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] s = new String[n];
		String joint, c;
		int length1 = 0, length2, a, b, ans = 0;
		for(int i=0;i<n;i++) s[i] = input.next();
		
		int q = input.nextInt();
		while(q-->0) {
			a = input.nextInt();
			b = input.nextInt();
			c = input.next();
			joint = s[a-1]+"|"+s[b-1];
			length1 = getmaxlength(joint);
			joint = s[b-1]+"|"+s[a-1];
			length2 = getmaxlength(joint);
			if(length1<length2 && c.equals("<")) ans++;
			else if(length1==length2 && c.equals("=")) ans++;
			else if(length1>length2 && c.equals(">")) ans++;
		}
		System.out.println(ans);
		
		input.close();

	}
	
	public static int getmaxlength(String s) {
		char[] ch = s.toCharArray();
		int[] next = new int[ch.length];
		int j, max = 0;
		for(int i=1;i<ch.length;i++) {
			j = next[i-1];//��һ���ַ��Ķ�Ӧ�Ŀ�ͷλ��
			while(j>0 && ch[i] != ch[j]) {//���ظ����������ظ�Ƭ��
				j = next[j-1];
			}
			if(ch[i] == ch[j]) next[i] = j + 1;//�ַ���ͬ��+1
			max = next[ch.length-1];
			//System.out.println(next[i]);
		}
		return max;
	}
}
