
public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbccaaaabbccaaaaabb";
		char[] ch = s.toCharArray();
		int[] n = new int[ch.length];
		int m;
		System.out.print(n[0]);
		for(int i=1;i<ch.length;i++) {
			m = n[i-1];
			if(ch[i] == ch[m]) n[i] = m + 1;
			else if(ch[i] == ch[0]) n[i] = 1;
			System.out.print(" "+n[i]);
		}
	}

}
