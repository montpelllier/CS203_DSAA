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
			j = next[i-1];//上一个字符的对应的开头位置
			while(j>0 && ch[i] != ch[j]) {//不重复，往回找重复片段
				j = next[j-1];
			}
			if(ch[i] == ch[j]) next[i] = j + 1;//字符相同，+1
			System.out.println(next[i]);
		}
		
		input.close();
	}

}
