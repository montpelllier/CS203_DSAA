import java.io.*;
import java.math.*;
import java.util.*;

public class A {

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
				String s = in.next();
				char[] bracket = s.toCharArray();
				char[] check = new char[bracket.length];
				int top = -1;
				if(n%2 == 0) {
					for(int i=0;i<n;i++) {
						push(check, bracket[i],top);
						top++;
						if(top > 0) {
							if(check[top] == ')') {
								if(check[top-1] == '(') top -= 2;
								else break;
							}else if(check[top] == ']') {
								if(check[top-1] == '[') top -= 2;
								else break;						
							}else if(check[top] == '}') {
								if(check[top-1] == '{') top -= 2;
								else break;
							}
						}
					}
					if(top == -1) out.println("YES");
					else out.println("NO"); 
				}else out.println("NO");
			}
			
		}
	}

	public static void push(char[] c, char item, int top) {
		if(top < c.length) c[++top] = item;
	}
	
/*	public static char pop(char[] c, int top) {
		if(top != -1) top--;
		return c[top+1];
	}*/

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