import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String str = input.next();
		String prefix = str, suffix = str;
		int l;
		for(int i=1;i<n;i++) {
			str = input.next();
			l = str.length();
			for(int j=1;j<=prefix.length();j++) {
				if(!str.substring(0,j).equals(prefix.substring(0,j))) {
					prefix = prefix.substring(0,j-1);
					break;
				}
			}
			for(int j=suffix.length();j>=0;j--) {
				if(!str.substring(l-(suffix.length()-j)).equals(suffix.substring(j))) {
					suffix = suffix.substring(j+1);
					break;
				}
			}
			if(prefix.length()==0 || suffix.length()==0) break;
		}
		
		System.out.println(prefix.length()*suffix.length());
		
		input.close();
	}

}
