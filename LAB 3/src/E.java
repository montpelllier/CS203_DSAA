import java.io.*;
import java.util.*;

public class E {
	
	public static long pow(int m, int n) {
		long result = 1L;
		for(int i=0;i<n;i++) {
			result *= m;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		Reader input = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = input.nextInt();
		int p = input.nextInt();
		int q = input.nextInt();
		int[] hp = new int[n];
		int[] atk = new int[n];
		long[] difp = new long[n];
		int[] difhp = new int[n];
		int[] sorteddifhp = new int[n];
		long sum = 0L, max = 0L;

		for(int i=0;i<n;i++) {
			hp[i] = input.nextInt();
			atk[i] = input.nextInt();
			sum += atk[i];
			if(hp[i]*pow(2,p) - atk[i] > 0) difp[i] = hp[i]*pow(2,p) - atk[i];
			if(hp[i] - atk[i] > 0) difhp[i] = hp[i] - atk[i];
			sorteddifhp[i] = difhp[i];
			if(difp[i] > max) max = difp[i];//hp翻倍后增加的max atk
		}
		if(max>0 && q==1) {
			sum += max;//只有一张相等，加上最大的差值
		}else if(max>0 && q>1){
			Arrays.sort(sorteddifhp);
			int k = n-1, qth = 0;
			long sumq = 0L;
			while(k>=n-q && k>=0) {
				if(sorteddifhp[k]>0) sumq += sorteddifhp[k--];//前q大的difhp 之和
				else break;			
			}
			if(k<0) qth = sorteddifhp[n-q];
			long tempsum = 0L;
			long sumx=0L;
			for(int i=0;i<n;i++) {//遍历所有的操作后的atk之和，通过+difp+sumq并减去重复的difhp得到
				if(difhp[i]>qth)tempsum = difp[i] + sumq - difhp[i];
				else tempsum = difp[i] + sumq - qth;
				if(sumx < tempsum ) sumx = tempsum;
			}
			sum += sumx;	
		}
		System.out.println(sum);
		
		out.close();
	}
	

	static class Reader
	{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;
 
		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}
 
		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
 
		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');
 
			if (neg)
				return -ret;
			return ret;
		}
 
		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}
 
		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
 
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
 
			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}
 
			if (neg)
				return -ret;
			return ret;
		}
 
		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
 
		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}
 
		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}

}