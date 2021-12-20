import java.io.*;

public class D {
	
	public static void remove(Node nd) {//silly remove
		if(nd.next != null && nd.prev != null) {
			nd.prev.next = nd.next;
			nd.next.prev = nd.prev;
			nd.next = null;
			nd.prev = null;
		}else if(nd.next == null) {
			nd.prev.next = null;
			nd.prev = null;
		}else {
			nd.next.prev = null;
			nd.next = null;
		}
	}
	
	public static Node getMid(Node head) {
		if (head == null || head.next == null) return head;
	    Node s = head, q = head;
	    while (q.next != null && q.next.next != null) {
	        s = s.next;//走一步
	        q = q.next.next;//走两步
	    }
	    return s;//快的到了，慢的为中点  复杂度log(n)?
	}
	
	public static Node merge(Node heada, Node headb) {//链表拼接
		Node p1 = heada, p2 = headb, head;
		if (heada.value < headb.value) {
			head = heada;
		    p1 = p1.next;
		}else {
			head = headb;
		    p2 = p2.next;
	    }
		Node p = head;
		while (p1 != null && p2 != null) {//比较值
			if (p1.value <= p2.value) {
				p.next = p1;
				p1 = p1.next;
		        p = p.next;
			}else {
				p.next = p2;
				p2 = p2.next;
				p = p.next;
			}
		}
		if (p1 != null) p.next = p1;
		if (p2 != null) p.next = p2;
		return head;
	}
	
	public static Node mergesort(Node head) {//利用递归进行归并排序
		if (head == null || head.next == null) return head;
	    Node mid = getMid(head);
	    Node right = mid.next;
	    mid.next = null;
	    return merge(mergesort(head), mergesort(right));
	}	

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		while(t-->0) {
			int n = in.nextInt();
			if(n>0) {
				Node nd[] = new Node[n];
				Node sort[] = new Node[n];
				int output[] = new int[(n+1)/2];
				nd[0] = new Node();
				for(int i=0;i<n;i++) {
					nd[i] = new Node();
					sort[i] = new Node();
					nd[i].value = in.nextInt();
					sort[i].value = nd[i].value;
				}//读值
				for(int i=0;i<n-1;i++) {
					nd[i].next = nd[i+1];
					nd[i+1].prev = nd[i];
					sort[i].next = sort[i+1];
				}//连接链表
				Node head = mergesort(sort[0]);//排序
				Node cnd = head;
				int index = 0;
				while(cnd.next != null) {
					cnd.order = index++;
					cnd.next.prev = cnd;
					cnd = cnd.next;	
				}//储存排序后节点的序号
				if(cnd != null) cnd.order = index++;
				int i = n-1, j = i/2;
				if(n%2 == 0) {
					remove(sort[n-1]);
					i--;
				}//偶数个时，移除最后一个节点
				cnd = head;
				Node mid = getMid(cnd);//得到中点
				while(i>1) {//从最后一个开始两两移除
					output[j--] = mid.value;
					if(sort[i].order > mid.order) {//判断中位数移动方向
						if(sort[i-1].order >= mid.order) mid = mid.prev;
					}else if(sort[i].order == mid.order) {
						if(sort[i-1].order > mid.order) mid = mid.prev;
						if(sort[i-1].order < mid.order) mid = mid.next;
					}else {
						if(sort[i-1].order <= mid.order) mid = mid.next;
					}
					remove(sort[i]);
					remove(sort[i-1]);
					i -= 2;
				}
				if(mid != null) output[j--] = mid.value;
				for(int k:output) {//输出
					out.print(k+" ");
				}
			}
			out.println();
		}
		
		out.close();
	}

	private static class Node {
		Node next;
		Node prev;
		int value;
		int order;
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