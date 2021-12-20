import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long xr = input.nextLong(),yr = input.nextLong(),xc = input.nextLong(),yc = input.nextLong(),n = input.nextLong();
		long time = -1,xri = xr,yri = yr;
		String string = input.next();
		char[] move = string.toCharArray();//�õ��������ж�ָ��
		for(int i=0;i<n;i++) {
			if(move[i] == 'U')
				yr++;
			else if(move[i] == 'D')
				yr--;
			else if(move[i] == 'L')
				xr--;
			else if(move[i] == 'R')
				xr++;
		}//һ�ֺ�Ļ�����λ��
		long xdif = xr - xri, ydif = yr - yri;
		long l = 0,r = 10000000000000L;//����
		while(l<r) {
			long midturn = (l+r)/2;
			long x = xri+midturn*xdif-xc, y = yri+midturn*ydif-yc;
			if(Math.abs(x)+Math.abs(y)<=midturn*n) r = midturn; 
			else l = midturn+1;//���ݻ�������CC����(ȡ����ֵ��ƽ��)�ж��ܷ�׷�ϣ��ٶ���
		}
		xr=l*xdif+xri-xdif;
		yr=l*ydif+yri-ydif;
		for(int i=0;i<n;i++) {//�ҳ����һ�ֵľ���ʱ��
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
