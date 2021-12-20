import java.util.Scanner;

public class D {
	
	public static int postorder(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
		if(pl > pr) return 0;
		if(pl == pr) return preorder[pl];
		int index = 0, len, leftree, rightree, root;
		for(int i=0;i<preorder.length;i++) {
			if(inorder[i]==preorder[pl]) {
				index = i;
				break;
			}
		}
		len = index - il;//Ϊ���һ���������
		leftree = postorder(preorder, inorder, pl+1, pl+len, il, index-1);
		if(leftree > 0) System.out.print(leftree+" ");//���������
		rightree = postorder(preorder, inorder, pl+len+1, pr, index+1, ir);
		if(rightree > 0) System.out.print(rightree+" ");//���������
		root = preorder[pl];
		return root;//��������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int t = input.nextInt(), n;
		int[] pre, in;
		while(t-->0) {			
			n = input.nextInt();
			pre = new int[n];
			in = new int[n];
 			for(int i=0;i<n;i++) pre[i] = input.nextInt();
 			//����ǰ��
			for(int i=0;i<n;i++) in[i] = input.nextInt();
			//��������
			System.out.println(postorder(pre, in, 0, n-1, 0, n-1));
		}
		
		input.close();
	}

}
