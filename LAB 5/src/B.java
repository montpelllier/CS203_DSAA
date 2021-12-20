import java.io.*;
import java.math.*;
import java.util.*;

public class B {

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
			int n = in.nextInt();
			Node head = new Node(), tail = new Node();
			head.next = tail;
			tail.prev = head;
			String operation;
			int x;
			while(n-->0) {
				operation = in.next();
				if(operation.equals("E")) {
					x = in.nextInt();
					Enqueue(tail, x);
				}else if(operation.equals("D")) Dequeue(head);
				else if(operation.equals("A")) {
					if(head.next != tail) out.println(head.next.data);
				}
			}
			Node cnd = head;
			while(cnd != tail) {
				cnd = cnd.next;
				if(cnd!=tail) out.print(cnd.data+" ");
			}
		}
	}

	static class Node {
		Node next;
		Node prev;
		int data;
	}
	
	public static void Enqueue(Node tail, int data) {
		tail.prev.next = new Node();
		tail.prev.next.next = tail;
		tail.prev.next.prev = tail.prev;
		tail.prev = tail.prev.next;
		tail.prev.data = data;
	}
	
	public static void Dequeue(Node head) {
		head.next.next.prev = head;
		head.next = head.next.next;
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