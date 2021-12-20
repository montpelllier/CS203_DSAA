import java.io.*;
import java.math.*;
import java.util.*;

public class E {

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
			String oper;
			int c, freq = 0, eat;
			int[] color = new int[100000];
			Node[] tail = new Node[100000];
			while(true) {
				oper = in.next();
				if(oper.equals("put-in")) {//╥елг
					c = in.nextInt() - 1;
					color[c]++; 
					if(tail[color[c]]==null) tail[color[c]] = new Node();
					push(tail[color[c]], c);
					if(color[c]>freq) freq++;
				}else if(oper.equals("eat")){//Ётлг
					if(freq>0) {
						eat = pop(tail[freq]);
						color[eat]--;
						out.println(eat+1);
						if(tail[freq].prev==null) freq--;
					}else out.println("pa");			
				}else break;
			}

		}
	}

	static class Node {
		int candy;
		Node prev;
	}
	
	public static void push(Node tail, int data) {
		Node temp = new Node();
		temp.candy = data;
		temp.prev = tail.prev;
		tail.prev = temp;
	}
	
	public static int pop(Node tail) {
		int pop = tail.prev.candy;
		tail.prev = tail.prev.prev;
		return pop;
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