import java.io.*;
import java.math.*;
import java.util.*;

public class F {

	public static void main(String[] args) {
		InputStream inputStream = System.in;// new FileInputStream("C:\\Users\\wavator\\Downloads\\test.in");
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}

	static class Task {

		public void solve(InputReader in, PrintWriter out) {
			
			int t = in.nextInt();
			while(t-->0) {
				String s = in.next();
				char[] fuck = s.toCharArray(), ins;
				int index = 0, u = 0;
				Node cnd;
				
				int n = in.nextInt();
				int[] position = new int[n], operation = new int[n];
				char[] insert = new char[n];
				for(int i=0;i<n;i++) {
					operation[i] = in.nextInt();
					if(operation[i] == 1) {
						s = in.next();
						ins = s.toCharArray();
						insert[index++] = ins[0];	
					}
					position[i] = in.nextInt();
				}//储存数据
				
				int sq = (int) Math.sqrt(fuck.length+index);//插入后最大节点数开根
				Pointer head = new Pointer();
				Pointer cp = head;
				while(u<fuck.length) {
					for(int i=0;i<fuck.length/sq+1;i++) {
						cp.nextp = new Pointer();
						cp = cp.nextp;
						cp.nextnd = new Node();
						cnd = cp.nextnd;
						cnd.data = fuck[u++];//create first node
						cp.num++;
						for(int j=1;j<sq;j++) {
							if(u<fuck.length) {
								cnd.next = new Node();
								cnd = cnd.next;
								cnd.data = fuck[u++];
							}
							cp.num++;
						}
					}
				}//构建链表，存入fuck中的所有数据
				
				index = 0;
				for(int i=0;i<n;i++) {//执行操作			
					if(operation[i] == 1) {
						insert(head,insert[index++], position[i], sq);
						
					}else {
						out.println(find(head, position[i])+" ");
					}
				}

			}
		}
	}
	
	public static void insert(Pointer head, char data, int position, int sq) {//
		Pointer cp = head.nextp;
		Pointer tempp = new Pointer();
		Node temp = new Node();
		Node cnd;
		
		while(position > 0) {
			if(position > cp.num) {
				position -= cp.num;
				cp = cp.nextp;
			}else {
				cnd = cp.nextnd;
				if(position == 1) {//insert at first
					cp.nextnd = new Node();
					cp.nextnd.next = cnd;
					cp.nextnd.data = data;
					cp.num++;
				}else {
					while(position-->2) cnd = cnd.next;//insert behind
					temp.data = data;
					temp.next = cnd.next;
					cnd.next = temp;
					cp.num++;
				}
				position = 0;
				
				if(cp.num == 2*sq) {//create new pointer and cut the node
					cnd = cp.nextnd;
					for(int i=1;i<sq;i++) cnd = cnd.next;
					tempp.nextp = cp.nextp;
					cp.nextp = tempp;
					tempp.nextnd = cnd.next;
					tempp.num = sq;
					cnd.next = null;
					cp.num = sq;
				}
			}
		}
		
	}
	
	public static char find(Pointer head, int position) {
		Node cnd = null;
		Pointer cp = head.nextp;
		
		while(position > 0) {
			if(position > cp.num) {
				position -= cp.num;
				cp = cp.nextp;
			}else {
				cnd = cp.nextnd;
				while(position-->1) {
					cnd = cnd.next;
				}
				position--;
			}
		}
		return cnd.data;
	}

	private static class Node {
		Node next;
		char data;
	}
	
	private static class Pointer {
		Pointer nextp;
		Node nextnd;
		int num;
	}
	
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public char[] nextCharArray() {
			return next().toCharArray();
		}

//         public boolean hasNext() {
//             try {
//                 return reader.ready();
//             } catch(IOException e) {
//                 throw new RuntimeException(e);
//             }
//         }
		public boolean hasNext() {
			try {
				String string = reader.readLine();
				if (string == null) {
					return false;
				}
				tokenizer = new StringTokenizer(string);
				return tokenizer.hasMoreTokens();
			} catch (IOException e) {
				return false;
			}
		}

		public BigInteger nextBigInteger() {
			return new BigInteger(next());
		}

		public BigDecimal nextBigDecinal() {
			return new BigDecimal(next());
		}
	}
}