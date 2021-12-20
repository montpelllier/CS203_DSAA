import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String s;
		while(n-->0) {
			s = input.next();
			if(s.length() == 0) System.out.print(1);
			else System.out.println(getnums(s));
		}
		
		input.close();
	}
	
	public static int getnums(String s) {
		char[] ch = s.toCharArray();
		int[] next = new int[ch.length];
		int j, ans, maxlength = 0;
		for(int i=1;i<ch.length;i++) {
			j = next[i-1];//上一个字符的对应的开头位置
			while(j>0 && ch[i] != ch[j]) {//不重复，往回找重复片段
				j = next[j-1];
			}
			if(ch[i] == ch[j]) next[i] = j + 1;//字符相同，+1
		}
		for(int i=0;i<ch.length;i++) {
			if(next[i]==0) maxlength = i+1;
			else if(i+1-next[i]>maxlength){
				maxlength = i+1-next[i];
			}
		}
		if(next[ch.length-1]==0) ans = maxlength;
		else if(next[ch.length-1]%maxlength > 0) {
			ans = maxlength-next[ch.length-1]%maxlength;
		}else ans = 0;
		return ans;
	}
}
