import java.io.*;

public class E {

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			Node head = new Node();
			Pointer pointerhead = new Pointer();
			Node cnd = head;
			Node right = head;
			Pointer cp = pointerhead, rightp;
			if(n>0) {
				while(n-->0) {//输入
					cnd.next = new Node();
					cnd.next.data = in.nextInt();
					cnd.next.order = n;
					cnd.next.previous = cnd;
					cnd = cnd.next;
				}
				cnd = head;
				while(cnd.next != null) {//第一遍暴力
					if(cnd.data > cnd.next.data) {
						right = cnd;
						while(right.next != null) {//遇到递减数列，用right找到递减结束的位置
							if(right.data > right.next.data) right = right.next;
							else break;
						}
						cnd = cnd.previous;
						cnd.next = right.next;//删去递减序列
						if(right.next != null) right.next.previous = cnd;
						if(cnd.next != null) {//在非尾部创建指示器
							cp.nextp = new Pointer();
							cp.nextp.node = cnd;
							cp = cp.nextp;
						}
					}
					if(cnd.next != null) cnd = cnd.next;
				}
				while(pointerhead.nextp != null) {//之后的循环从指示器开始
					cp = pointerhead;
					while(cp.nextp != null) {
						cnd = cp.nextp.node;
						if(cnd.next==null || cnd.previous==null) cp.nextp = cp.nextp.nextp;
						else if(cnd.data <= cnd.next.data) cp.nextp = cp.nextp.nextp;//skip the pointers
						else {
							right = cnd;
							rightp = cp;
							while(right.next != null) {
								if(right.data > right.next.data) right = right.next;//找到降序节点右端
								else break;
							}
							while(rightp.nextp.nextp != null) {
								if(rightp.nextp.nextp.node.order >= right.order) rightp = rightp.nextp;//找到右端指示器
								else break;
							}							
							cnd = cnd.previous;
							cnd.next = right.next;
							if(right.next != null) right.next.previous = cnd;//删除降序节点
							cp.nextp.nextp = rightp.nextp.nextp;//删除所有指向被因为降序删掉的指示器
							rightp = cp;//???我在干嘛
							if(cp.nextp != null) {
								cp.nextp.node = cnd;
								cp = cp.nextp;
							}
						}
					}
				}
				cnd = head;
				while(cnd.next != null) {//输出
					out.print(cnd.next.data+" ");
					cnd = cnd.next;
				}
			}
			out.println();
		}
		
		out.close();
	}
	
	private static class Node {
		Node next;
		Node previous;
		int data;
		int order;
	}
	
	private static class Pointer {
		Node node;
		Pointer nextp;
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