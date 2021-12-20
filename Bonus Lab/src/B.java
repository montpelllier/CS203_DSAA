import java.io.*;
import java.math.*;
import java.util.*;

public class B {//can read String

	public static void main(String[] args) {
		InputStream inputStream = System.in;// new FileInputStream("C:\\Users\\wavator\\Downloads\\test.in");
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
	
	private static class Node {
		Node next;
		Node prev;
		int value;
		int sum;
	}
	
	static Comparator<Node> cmp = new Comparator<Node>() {//大优先
		public int compare(Node node1, Node node2) {
			return node2.sum - node1.sum;
		}
	};

	static class Task {

		public void solve(InputReader in, PrintWriter out) {
			//nlogn也超时？服了
			int q = in.nextInt(), x, index=0;
			String operation;
			Node head = new Node(), tail = new Node();
			head.next = tail;
			tail.prev = head;
			Node cursor = tail;
			int[] max = new int[1000000];
			PriorityQueue<Node> maxheap = new PriorityQueue<Node>(cmp);
			//无法访问head,减少if判断
			while(q-->0) {
				operation = in.next();
				switch (operation) {
				case "I" :
					x = in.nextInt();
					cursor.prev.next = new Node();
					cursor.prev.next.next = cursor;
					cursor.prev.next.prev = cursor.prev;
					cursor.prev = cursor.prev.next;
					cursor.prev.value = x;
					cursor.prev.sum = cursor.prev.prev.sum + x;
					maxheap.add(cursor.prev);//新节点算得sum,value后入堆
					index++;//表示光标的位置
					max[index-1] = maxheap.peek().sum;
					break;
				case "D" :
					if(cursor.prev != head) {
						maxheap.remove(cursor.prev);//出堆
						cursor.prev = cursor.prev.prev;
						cursor.prev.next = cursor;
						index--;
						//max[index] = maxheap.peek().sum;
					}
					break;
				case "L" :
					if(cursor.prev != head) {
						cursor = cursor.prev;
						maxheap.remove(cursor);
						index--;
					}
					break;
				case "R" :
					if(cursor != tail) {
						cursor.sum = cursor.prev.sum + cursor.value;
						maxheap.add(cursor);//更新sum后右移
						cursor = cursor.next;
						index++;
						max[index-1] = maxheap.peek().sum;
					}
					break;
				case "Q" :
					x = in.nextInt();
					out.println(max[x-1]);
					break;
				}
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