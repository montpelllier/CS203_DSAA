import java.util.Scanner;

public class E {//ÄÚ´æ³¬ÏÞ

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String s1=input.next(), s2=input.next();
		
		int ans = 0;
		int[][] matrix = new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					matrix[i][j] = i==0||j==0 ? 1:matrix[i-1][j-1]+1;
				}
				if(matrix[i][j] > ans) ans = matrix[i][j];
			}
		}
		System.out.print(ans);
		
		input.close();
	}

}