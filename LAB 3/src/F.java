import java.io.*;

public class F {

	public static void merge(long[] arr, long[] conarr, int left, int mid, int right) {
		long SortedArr[] = new long[right-left+1];
		long temparr[] = new long[right-left+1];
		int l=left, r=mid+1, a=0, b=0; 
		while(l <= mid && r <= right) {
			if(arr[l] > arr[r]) {
				SortedArr[a] = arr[r];
				temparr[a++] = conarr[r++];
			}else {
				SortedArr[a] = arr[l];
				temparr[a++] = conarr[l++];
			}
		}
		while(l <= mid) {
			temparr[a] = conarr[l];
			SortedArr[a++] = arr[l++];
		}
		while(r <= right) {
			temparr[a] = conarr[r];
			SortedArr[a++] = arr[r++];
		}
		for(int i=left;i<=right;i++) {
			conarr[i] = temparr[b];
			arr[i] = SortedArr[b++];
		}
	}
	
	public static void sortI(long[] arr, long[] conarr, int left, int right) {//iteration
		if(left < right) {
			int mid = (left + right)/2;
			sortI(arr, conarr, left, mid);
			sortI(arr, conarr, mid+1, right);
			merge(arr, conarr, left, mid, right);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int x1  = in.nextInt(), x2 = in.nextInt();
		long[] k = new long[n], b = new long[n];
		long[] y1 = new long[n], y2 = new long[n];
		String ans = "NO";
		for(int i=0;i<n;i++) {
			k[i] = in.nextLong();
			b[i] = in.nextLong();
			y1[i] = k[i]*x1 + b[i];
			y2[i] = k[i]*x2 + b[i];
		}//求得左右边界
		sortI(y1, y2, 0, n-1);//对左边界排序，并使在右界的点始终对应左界
		for(int i =1;i<n;i++) {
			if(y1[i] == y1[i-1]) {
				if(y2[i] < y2[i-1]) {
					y2[i] = y2[i-1];
				}
			}
		}//当左界点重合时，右界点取最大值
		for(int i=1;i<n;i++) {
			if(y2[i] < y2[i-1]) {
				ans = "YES";
				break;
			}//检查右界点是否为非递减序列
		}
		System.out.println(ans);
		
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