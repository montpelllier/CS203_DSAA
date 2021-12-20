import java.util.Scanner;

public class E {//平衡二叉搜索树
	
	static class Node {
		int element;
		int height;
		int treesize;
		Node father;//不会递归只能这么写了
		Node left;
		Node right;
	}
	
	public static Node root;
	//element structure
	public static int height(Node node) {//为null时返回0
		return node==null? 0:node.height;
	}
	
	public static int treesize(Node node) {//为null时返回0
		return node==null? 0:node.treesize;
	}
	
	public static void set(Node node) {
		node.height = Math.max(height(node.left), height(node.right))+1;
		node.treesize = treesize(node.left)+treesize(node.right)+1;
	}
	
	public static Node search(int num) {
		Node cnd = root;
		while(true) {
			if(num>cnd.element && cnd.right!=null) {
				cnd = cnd.right;
			}else if(num<cnd.element && cnd.left!=null) {
				cnd = cnd.left;
			}else break;
		}
		return cnd;
	}
	
	public static Node findkth(Node node, int k) {//找到第k大的数
		while(treesize(node.left)+1 != k) {
			if(treesize(node.left)+1 < k) {
				k -= treesize(node.left) + 1;
				node = node.right;
			}else node = node.left;
		}
		return node;
	}
	//basic operations
	
	public static Node LLrotation(Node nd2) {
		Node nd1 = nd2.left;
		
		nd1.father = nd2.father;
		if(nd2 != root) {
			if(nd2.father.element > nd2.element) nd2.father.left = nd1;
			else nd2.father.right = nd1;
		}else root = nd1;
		nd2.left = nd1.right;
		if(nd1.right!=null) nd1.right.father = nd2;
		nd1.right = nd2;
		nd2.father = nd1;
		return nd1;
	}
	
	public static Node RRrotation(Node nd2) {
		Node nd1 = nd2.right;
		
		nd1.father = nd2.father;
		if(nd2 != root) {
			if(nd2.father.element > nd2.element) nd2.father.left = nd1;
			else nd2.father.right = nd1;
		}else root = nd1;
		nd2.right = nd1.left;
		if(nd1.left!=null) nd1.left.father = nd2;
		nd1.left = nd2;
		nd2.father = nd1;
		return nd1;
	}
	
	public static Node LRrotation(Node nd3) {
		nd3.left = RRrotation(nd3.left);
		return LLrotation(nd3);
	}
	
	public static Node RLrotation(Node nd3) {
		nd3.right = LLrotation(nd3.right);
		return RRrotation(nd3);
	}
	
	public static Node correct(Node cnd) {
		set(cnd);
		if(height(cnd.left) - height(cnd.right) == 2) {//L case
			if(height(cnd.left.left) > height(cnd.left.right)) {
				cnd = LLrotation(cnd);
				set(cnd.right);
				set(cnd);
			}else {
				cnd = LRrotation(cnd);
				set(cnd.left);
				set(cnd.right);
				set(cnd);
			}
		}else if(height(cnd.right) - height(cnd.left) == 2) {//R case
			if(height(cnd.right.right) > height(cnd.right.left)) {
				cnd = RRrotation(cnd);
				set(cnd.left);
				set(cnd);
			}else {
				cnd = RLrotation(cnd);
				set(cnd.left);
				set(cnd.right);
				set(cnd);
			}
		}
		if(cnd == root) return cnd;
		else return correct(cnd.father);
	}
	//Rotation	
	public static void insert(int element) {
		Node cnd;
		if(root==null) {
			root = new Node();
			root.element = element;
			cnd = root;
		}else {
			cnd = search(element);
			if(element > cnd.element) {//插在右
				cnd.right = new Node();
				cnd.right.element = element;
				cnd.right.father = cnd;
				cnd = cnd.right;
			}else {//插在左
				cnd.left = new Node();
				cnd.left.element = element;
				cnd.left.father = cnd;
				cnd = cnd.left;
			}
		}
		correct(cnd);
	}
	
	public static void delete(int num) {
		Node cnd = search(num);
		if(cnd.left==null && cnd.right==null) {//叶节点直接删
			if(cnd == root) root = null;
			else if(cnd.father.element > cnd.element) {
				cnd = cnd.father;
				cnd.left.father = null;
				cnd.left = null;
			}else {
				cnd = cnd.father;
				cnd.right.father = null;
				cnd.right = null;
			}
		}else if(cnd.left != null) {//有左节点，左树的最大值来替代
			Node max = findkth(cnd.left, cnd.left.treesize);
			
			if(max.left != null) max.left.father = max.father;
			if(max.element>max.father.element) {
				max.father.right = max.left;
			}else max.father.left = max.left;
			
			cnd.element = max.element;
			cnd = max.father;
			max.father = null;
			max.left = null;
		}else {
			Node min = findkth(cnd.right, 1);
			
			if(min.right != null) min.right.father = min.father;
			if(min.element>min.father.element) {
				min.father.right = min.right;
			}else min.father.left = min.right;
			
			cnd.element = min.element;
			cnd = min.father;
			min.father = null;
			min.right = null;
		}
		correct(cnd);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = input.nextInt(), k = input.nextInt(), j=0;
		int[] nums = new int[m], order = new int[m-k+1];
		
		for(int i=0;i<m;i++) nums[i] = input.nextInt();
		for(int i=0;i<m-k+1;i++) order[i] = input.nextInt();
		for(int i=0;i<m;i++) {
			insert(nums[i]);
			if(i>=k-1) {
				//check();
				System.out.println(findkth(root, order[j]).element);
				delete(nums[j++]);
			}
		}
		input.close();
	}
	
}