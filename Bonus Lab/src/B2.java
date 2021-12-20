import java.util.*;

public class B2 {//NMD O(n)终于过了hhhhhhhhhhhhhhhhh
	
	private static class Node {
		Node next;
		Node prev;
		int value;
		int sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int q = in.nextInt(), x, index=0;
		String operation;
		Node head = new Node(), tail = new Node();
		head.next = tail;
		tail.prev = head;
		Node cursor = tail;
		int[] max = new int[1000000];
		max[0] = -1000;
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
				index++;//表示光标的位置
				if(cursor.prev.sum > max[index-1]) max[index-1] = cursor.prev.sum;
				if(index<max.length) max[index] = max[index-1];
				
				break;
			case "D" :
				if(cursor.prev != head) {
					cursor.prev = cursor.prev.prev;
					cursor.prev.next = cursor;
					index--;
					if(index > 0) max[index] = max[index-1];
					else max[0] = -1000;
				}
				break;
			case "L" :
				if(cursor.prev != head) {
					cursor = cursor.prev;
					index--;
					if(index > 0) max[index] = max[index-1];
					else max[0] = -1000; 
				}
				break;
			case "R" :
				if(cursor != tail) {
					cursor.sum = cursor.prev.sum + cursor.value;
					cursor = cursor.next;
					index++;
					if(cursor.prev.sum > max[index-1]) max[index-1] = cursor.prev.sum;
					if(index<max.length) max[index] = max[index-1];
				}
				break;
			case "Q" :
				x = in.nextInt();
				System.out.println(max[x-1]);
				break;
			}
		}
		
		in.close();
	}

}
