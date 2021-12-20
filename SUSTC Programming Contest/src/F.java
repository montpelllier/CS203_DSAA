import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n;
		String[] string;
		String ans;
		while(t-->0) {
			ans = "";
			n = input.nextInt();
			string = new String[n];
			for(int i=1;i<=n;i++) {
				if(i <= n/2) string[i*2-2] = input.next();
				else string[(i-n/2)*2-1] = input.next();
			}
			for(int i=0;i<n;i++) {
				switch(string[i]) {
				case ".-"	:ans += "A";break;
				case "-..."	:ans += "B";break;
				case "-.-."	:ans += "C";break;
				case "-.."	:ans += "D";break;
				case "."	:ans += "E";break;
				case "..-."	:ans += "F";break;
				case "--."	:ans += "G";break;
				case "...."	:ans += "H";break;
				case ".."	:ans += "I";break;
				case ".---"	:ans += "J";break;
				case "-.-"	:ans += "K";break;
				case ".-.."	:ans += "L";break;
				case "--"	:ans += "M";break;
				case "-."	:ans += "N";break;
				case "---"	:ans += "O";break;
				case ".--."	:ans += "P";break;
				case "--.-"	:ans += "Q";break;
				case ".-."	:ans += "R";break;
				case "..."	:ans += "S";break;
				case "-"	:ans += "T";break;
				case "..-"	:ans += "U";break;
				case "...-"	:ans += "V";break;
				case ".--"	:ans += "W";break;
				case "-..-"	:ans += "X";break;
				case "-.--"	:ans += "Y";break;
				case "--.."	:ans += "Z";break;
				case "-----":ans += "0";break;
				case ".----":ans += "1";break;
				case "..---":ans += "2";break;
				case "...--":ans += "3";break;
				case "....-":ans += "4";break;
				case ".....":ans += "5";break;
				case "-....":ans += "6";break;
				case "--...":ans += "7";break;
				case "---..":ans += "8";break;
				case "----.":ans += "9";break;
				}
			}
			System.out.println(ans);
		}
		
		input.close();
	}

}
