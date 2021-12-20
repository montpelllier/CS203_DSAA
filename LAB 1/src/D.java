import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		while (t-->0) {
			int l = input.nextInt();
			int w = input.nextInt();
			int h = input.nextInt();
			String[][] cube = new String[(w+h)*2+1][(w+l)*2+1];
			for(int i=0;i<(w+h)*2+1;i++) {
				for(int j=0;j<(w+l)*2+1;j++) {
					cube[i][j] = "."; 
				}//make all dots
				if(i<2*w) {
					for(int k=2*w-i;k<(w+l)*2+1-i;k=k+2) {
						if(i%2==0) {
							cube[i][k] = "+";
						}else {
							cube[i][k] = "/";
						}
					}
					for(int m = 2*w+1-i;m<2*(w+l)-i;m=m+2) {
						if(i%2==0) {
							cube[i][m] = "-";
						}
					}
				}//make the top surface
				if(2*w<=i) {
					for(int k=0;k<l*2+1;k=k+2) {
						if(i%2==0) {
							cube[i][k] = "+";
						}else {
							cube[i][k] = "|";
						}
					}
					for(int m = 1;m<2*l;m=m+2) {
						if(i%2==0) {
							cube[i][m] = "-";
						}
					}
				}//make the front surface
			}
			for(int j=2*(w+l);j>2*l;j--) {
				for(int i=2*(w+l)-j;i<2*h+2*(w+l)-j;i++) {
					if(j%2==0) {
						for(int k=2*(w+l)-j;k<2*h+2*(w+l)-j+1;k=k+2) {
							cube[k][j] = "+";
						}
						for(int m=2*(w+l)-j+1;m<2*h+2*(w+l)-j;m=m+2) {
							cube[m][j] = "|";
						}
					}else {
						for(int k=2*(w+l)-j;k<2*h+2*(w+l)-j+1;k=k+2) {
							cube[k][j] = "/";
						}
					}
				}//make the side surface
			}
			for(int i=0;i<(w+h)*2+1;i++) {
				for(int j=0;j<(w+l)*2+1;j++) {
					System.out.print(cube[i][j]);
				}
				System.out.println();
			}//print the cube
		}
		
		input.close();
	}
}