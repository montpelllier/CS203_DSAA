import java.io.*;

public class C {

	public static void main(String[] args) throws IOException {
		Reader in = new Reader();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();//t������
		while(t-->0) {
			long coef = 0L, exp =0L;
			
			int length = 0;
			int n = in.nextInt();
			Node head = new Node();
			Node cnd = head;
			for(int i=0;i<n;i++) {
				coef = in.nextLong();
				exp = in.nextLong();
				if(coef!=0) {
					cnd.next = new Node();
					cnd.next.coef = coef;
					cnd.next.exp = exp;
					cnd = cnd.next;
				}
			}
			cnd = head;
			int m = in.nextInt();
			for(int i=0;i<m;i++) {
				coef = in.nextLong();
				exp = in.nextLong();
				if(coef!=0) {
					if(cnd.next.exp < exp) {
						if(cnd.next == null) {
							cnd.next = new Node();
							cnd.next.coef = coef;
							cnd.next.exp = exp;
							cnd = cnd.next;
							length++;
						}else {
							length++;
							cnd = cnd.next;
						}						
					}else if(cnd.next.exp == exp) {
						cnd.next.coef += coef;
						if(cnd.next.coef == 0) length--;
						else length++;
						cnd = cnd.next;
					}else if(cnd.next.exp > exp) {
						length++;
						Node temp = new Node();
						temp.next = cnd.next;
						cnd.next = temp;
						temp.coef = coef;
						temp.exp = exp;
						cnd = cnd.next;
					}
				}
			}//����n,m��ϵ���͵���
			while(cnd.next != null) {
				length++;
				cnd = cnd.next;
			}
			System.out.println(length);		
			cnd = head;//�ص�ͷ��,���
			if(length == 0) System.out.print(0);
			else if(length == 1) {
				while(cnd.next != null) {
					if(cnd.next.coef != 0) {
						if(cnd.next.exp==0 || cnd.next.coef>1 || cnd.next.coef<-1) System.out.print(cnd.next.coef);
						else if(cnd.next.coef == -1) System.out.print("-");//���ϵ��
						
						if(cnd.next.exp == 1) System.out.print("x");
						else if(cnd.next.exp > 1) System.out.print("x^"+cnd.next.exp);//�������
						break;//�ҵ�һ���������ѭ��
					}
					cnd = cnd.next;
				}
			}else if(length > 1) {
				while(cnd.next != null) {
					if(cnd.next.coef != 0) {
						if(cnd.next.exp==0 || cnd.next.coef>1 || cnd.next.coef<-1) System.out.print(cnd.next.coef);
						else if(cnd.next.coef == -1) System.out.print("-");//���ϵ��
						
						if(cnd.next.exp == 1) System.out.print("x");
						else if(cnd.next.exp > 1) System.out.print("x^"+cnd.next.exp);//�������
						break;
					}
				}//�����һ����
				cnd = cnd.next;
				while(cnd.next != null) {
					if(cnd.next.coef != 0) {
						if(cnd.next.coef == 1) System.out.print("+");
						else if(cnd.next.coef == -1) System.out.print("-");
						else if(cnd.next.coef > 1) System.out.print("+"+cnd.next.coef);
						else if(cnd.next.coef < -1) System.out.print(cnd.next.coef);//���ϵ��
						
						if(cnd.next.exp == 1) System.out.print("x");
						else if(cnd.next.exp > 1) System.out.print("x^"+cnd.next.exp);//�������
					}
					cnd = cnd.next;
				}//���ʣ�µ���(�������ǳ��� ��exp != 0)
			}
			System.out.println();//����
		}

		out.close();
	}
	
	private static class Node {
		Node next;
		long coef;
		long exp = -1L;
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