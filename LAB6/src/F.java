import java.util.Scanner;

public class F {
	
	public static int getans(String s, char[] cipher) {
		char[] ch = s.toCharArray();
		int len = ch.length, j=0, k=0;
		int[] next = new int[len/2];
		for(int i=(ch.length+1)/2;i<ch.length;i++) {
			if(k>0) j = next[k-1];//上一个字符的对应的开头位置
			while(j>0 && ch[i] != decode(cipher,ch[j])) {//不重复，往回找重复片段
				j = next[j-1];
			}
			if(ch[i] == decode(cipher, ch[j])) next[k] = j + 1;//解密后的前面与后面相同，+1
			k++;
		}
		return len-next[len/2-1];
	}
	
	public static char decode(char[] cipher, char character) {
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int j = -1;
		for(int i=0;i<cipher.length;i++) {
			if(character == cipher[i]) {
				j = i;
				break;
			}
		}
		return alphabet[j];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		char[] cipher = new char[26];
		String temp;
		for(int i=0;i<26;i++) {
			temp = input.next();
			cipher[i] = temp.charAt(0);
		}
		String text = input.next(); 
		System.out.print(getans(text, cipher));
		
		input.close();
	}

}
