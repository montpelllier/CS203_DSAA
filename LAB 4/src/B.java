import java.io.*;
import java.math.*;
import java.util.*;

public class B {
	
	private static class Node {
		char data;
		Node next;
		Node previous;
	}

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
				int n = in.nextInt();
				String string = in.next();
				char[] vim = string.toCharArray();
				Node tail = new Node();
				Node cnd = tail;
				for(int i=0;i<n;i++) {
					if(Character.isDigit(vim[i])) {
						if(cnd.previous == null) {
							cnd.previous = new Node();
							cnd.previous.data = vim[i];
							cnd.previous.next = cnd;
						}else {
							cnd.previous.next = new Node();
							cnd.previous.next.data = vim[i];
							cnd.previous.next.previous = cnd.previous;
							cnd.previous.next.next = cnd;
							cnd.previous = cnd.previous.next;
						}//insert the number before the tail
					}else if(vim[i] == 'r') {
						if(i<n-1) {
							if(cnd.next == null) {
								if(cnd.previous == null) {
									cnd.previous = new Node();
									cnd.previous.data = vim[i+1];
									cnd.previous.next = cnd;
								}else {
									cnd.previous.next = new Node();
									cnd.previous.next.data = vim[i+1];
									cnd.previous.next.previous = cnd.previous;
									cnd.previous.next.next = cnd;
									cnd.previous = cnd.previous.next;
								}//insert the number before the tail
								cnd = cnd.previous;
							}else cnd.data = vim[i+1];
							i++;
						}
					}else if(vim[i] == 'I') {
						while(cnd.previous != null) cnd = cnd.previous;
					}else if(vim[i] == 'H') {
						if(cnd.previous != null) cnd = cnd.previous;
					}else if(vim[i] == 'L') {
						if(cnd.next != null) cnd = cnd.next;
					}else if(vim[i] == 'x') {
						if(cnd.next != null) {
							if(cnd.previous != null) {
								cnd.previous.next = cnd.next;
								cnd.next.previous = cnd.previous;
								cnd.previous = null;
							}else {
								cnd.next.previous = null;
							}
							cnd = cnd.next;	
						}
					}
				}	
				while(cnd.previous != null) {
					cnd = cnd.previous;
				}
				while(cnd.next != null) {
					System.out.print(cnd.data);
					cnd = cnd.next;
				}
				System.out.println();
			}
			
		}
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