
public class Method {//����ĸ��෽��
	
	static class dNode {//double linkedlist dNode
		dNode next;
		dNode prev;
		int data;
	}
	
	static class sNode {
		sNode prev;
		int data;
	}
	
	public static void Frontinsert(dNode front, int data) {//˫�� ǰ��
		front.next.prev = new dNode();
		front.next.prev.prev = front;
		front.next.prev.next = front.next;
		front.next = front.next.prev;
		front.next.data = data;
	}
	
	public static void Endinsert(dNode rear, int data) {//˫�� ����
		rear.prev.next = new dNode();
		rear.prev.next.next = rear;
		rear.prev.next.prev = rear.prev;
		rear.prev = rear.prev.next;
		rear.prev.data = data;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
