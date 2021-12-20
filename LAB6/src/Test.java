import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random in = new Random();
		int tmp=0;
		int T=in.nextInt(100);
		while(T-->0) {
		tmp+=in.nextInt(10);
		for(int i=0;i<tmp;i++) {
			System.out.println("put-in "+in.nextInt(4));
		}
		int tmpo=in.nextInt(tmp);
		for(int i=0;i<tmpo;i++) {
			System.out.println("eat");
		}
		tmp-=tmpo;
		}
		System.out.println("nsdd");
	}

}
