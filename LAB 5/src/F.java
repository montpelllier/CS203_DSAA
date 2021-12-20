import java.io.*;

public class F {
	
	static class Node {
		Node next;
		Node prev;
		int data;
	}

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int k = in.nextInt(), n = in.nextInt();
		int ans = 0, begin = 0;
		int[] seq = new int[n];
		Node maxh = new Node(), maxt = new Node();
		Node minh = new Node(), mint = new Node();
		maxh.next = maxt;
		maxt.prev = maxh;
		minh.next = mint;
		mint.prev = minh;
		
		for(int end=0;end<n;end++) {
			seq[end] = in.nextInt();
			while (maxh.next!=maxt && seq[maxt.prev.data]<seq[end]) {//单调递减 最大值队列
				maxt.prev = maxt.prev.prev;
				maxt.prev.next = maxt;
			}
			while (minh.next != mint && seq[mint.prev.data]>seq[end]) {//单调递增 最小值队列
				mint.prev = mint.prev.prev;
				mint.prev.next = mint;
			}
            Endinsert(maxt, end);
            Endinsert(mint, end);
            
            while (maxh.next!=maxt && minh.next!=mint && seq[maxh.next.data]-seq[minh.next.data]>k) {//将左边界缩小
            	if(maxh.next.data <= begin) {
            		maxh.next = maxh.next.next;
            		maxh.next.prev = maxh;
            	}
                if(minh.next.data <= begin) {
                	minh.next = minh.next.next;
                	minh.next.prev = minh;
                }
                begin++;
            }
            if(end-begin+1 >= ans) ans = end - begin + 1;
		}
		out.println(ans);
			
		out.close();
	}
	
	public static void Endinsert(Node rear, int data) {
		rear.prev.next = new Node();
		rear.prev.next.next = rear;
		rear.prev.next.prev = rear.prev;
		rear.prev = rear.prev.next;
		rear.prev.data = data;
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