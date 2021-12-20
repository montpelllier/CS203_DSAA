import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long xr = input.nextLong(),yr = input.nextLong(),xc = input.nextLong(),yc = input.nextLong(),n = input.nextLong();
		long time = -1,xri = xr,yri = yr;
		String string = input.next();
		char[] move = string.toCharArray();//得到机器人行动指令
		for(int i=0;i<n;i++) {
			if(move[i] == 'U')
				yr++;
			else if(move[i] == 'D')
				yr--;
			else if(move[i] == 'L')
				xr--;
			else if(move[i] == 'R')
				xr++;
		}//一轮后的机器人位置
		long xdif = xr - xri, ydif = yr - yri;
		long l = 0,r = 10000000000000L;//轮数
		while(l<r) {
			long midturn = (l+r)/2;
			long x = xri+midturn*xdif-xc, y = yri+midturn*ydif-yc;
			if(Math.abs(x)+Math.abs(y)<=midturn*n) r = midturn; 
			else l = midturn+1;//根据机器人与CC距离(取绝对值或平方)判断能否追上，再二分
		}
		xr=l*xdif+xri-xdif;
		yr=l*ydif+yri-ydif;
		for(int i=0;i<n;i++) {//找出最后一轮的具体时间
			if(move[i] == 'U') yr++;
			else if(move[i] == 'D') yr--;
			else if(move[i] == 'L')	xr--;
			else if(move[i] == 'R')	xr++;
			if(Math.abs(xr-xc)+Math.abs(yr-yc) <= n*l-n+i+1) {
				time = l*n+i-n+1;
				break;
			}
		}
		System.out.println(time);
		
		input.close();
	}

}
