
public class Sort {//mergesort
	
	public static void remove(Node nd) {
		nd.prev.next = nd.next;
		if(nd.next != null) nd.next.prev = nd.prev;
		else nd.prev = null;
	}
	
	private static class Node {
		Node next;
		Node prev;
		int data;
	}
	
	public static Node getMid(Node head) {
		if (head == null || head.next == null) {
	        return head;
	    }
	    //����ָ��
	    Node s = head, q = head;
	    //��2������һ��
	    while (q.next != null && q.next.next != null) {
	        s = s.next;
	        q = q.next.next;
	    }
	    return s;
	}
	
	public static Node merge(Node heada, Node headb) {
		Node p1 = heada, p2 = headb, head;
		   //�õ�ͷ�ڵ��ָ��
		    if (heada.data < headb.data) {
		        head = heada;
		        p1 = p1.next;
		    } else {
		        head = headb;
		        p2 = p2.next;
		    }

		    Node p = head;
		    //�Ƚ������е�ֵ
		    while (p1 != null && p2 != null) {
		        if (p1.data <= p2.data) {
		            p.next = p1;
		            p1 = p1.next;
		            p = p.next;
		        } else {
		            p.next = p2;
		            p2 = p2.next;
		            p = p.next;
		        }
		    }
		    //�ڶ����������
		    if (p1 != null) {
		        p.next = p1;
		    }
		    //��һ���������
		    if (p2 != null) {
		        p.next = p2;
		    }
		    return head;
	}
	
	public static Node sort(Node head) {
		if (head == null || head.next == null) {
	        return head;
	    }
	    //��ȡ�м���
	    Node mid = getMid(head);
	    Node right = mid.next;
	    mid.next = null;
	    //�ϲ�
	    return merge(sort(head), sort(right));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		Node a[] = new Node[n];
		for(int i=0;i<n;i++) {
			a[i] = new Node();
			a[i].data = i;
		}
		for(int i=0;i<n-1;i++) {
			a[i].next = a[i+1];
			a[i+1].prev = a[i];
		}
		a[0].data = 2; a[1].data = 10; a[2].data = 0; a[4].data = 9;
	//	System.out.println(a[4].data);
		
		Node cnd = sort(a[0]);
		while(cnd != null) {
			System.out.print(cnd.data+" ");
			cnd = cnd.next;
		}
	}

}
