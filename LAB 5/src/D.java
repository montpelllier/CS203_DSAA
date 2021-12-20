import java.io.*;

public class D {//µ¥µ÷Õ»

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			Node nd[] = new Node[n];
			Node rear = new Node();
			Node cnd;
			
			for(int i=0;i<n;i++) {
				nd[i] = new Node();
				nd[i].index = in.nextInt();
				nd[i].day = i;
			}
			
			for(int i=0;i<n;i++) {
				if(rear.prev == null) rear.prev = nd[i];
				else if(rear.prev.index < nd[i].index) {
					while(rear.prev.index < nd[i].index) {
						rear.prev.day = nd[i].day - rear.prev.day;
						rear.prev = rear.prev.prev;
						if(rear.prev == null) break;
					}
					Rearinsert(rear, nd[i]);
				}else Rearinsert(rear, nd[i]);
				
			}
			cnd = rear;
			while(cnd.prev != null) {
				cnd = cnd.prev;
				cnd.day = -1;
			}
			int q = in.nextInt();
			int k;
			for(int i=0;i<q;i++) {
				k = in.nextInt();
				out.print(nd[k-1].day+" ");
			}
		}
		
		out.close();
	}
	
	static class Node {
		Node prev;
		int index;
		int day;
	}
	
	public static void Rearinsert(Node rear, Node insert) {
		Node temp = rear.prev;
		rear.prev = insert;
		insert.prev = temp;
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
