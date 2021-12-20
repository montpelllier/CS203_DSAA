import java.util.ArrayList;

public class AVL {
	
	static class Node {
		int value;
		int height;
		int treesize;
		Node father;//不会递归只能这么写了
		Node left;
		Node right;
	}
	
	static class AVLtree {
		Node root;
		boolean isEmpty = true;
	}
	
	//public static Node root;
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
	
	public static Node search(AVLtree avl, int num) {
		Node cnd = avl.root;
		while(true) {
			if(num>cnd.value && cnd.right!=null) {
				cnd = cnd.right;
			}else if(num<cnd.value && cnd.left!=null) {
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
	public static Node LLrotation(AVLtree avl, Node nd2) {
		Node nd1 = nd2.left;
		
		nd1.father = nd2.father;
		if(nd2 != avl.root) {
			if(nd2.father.value > nd2.value) nd2.father.left = nd1;
			else nd2.father.right = nd1;
		}else avl.root = nd1;
		nd2.left = nd1.right;
		if(nd1.right!=null) nd1.right.father = nd2;
		nd1.right = nd2;
		nd2.father = nd1;
		return nd1;
	}
	
	public static Node RRrotation(AVLtree avl, Node nd2) {
		Node nd1 = nd2.right;
		
		nd1.father = nd2.father;
		if(nd2 != avl.root) {
			if(nd2.father.value > nd2.value) nd2.father.left = nd1;
			else nd2.father.right = nd1;
		}else avl.root = nd1;
		nd2.right = nd1.left;
		if(nd1.left!=null) nd1.left.father = nd2;
		nd1.left = nd2;
		nd2.father = nd1;
		return nd1;
	}
	
	public static Node LRrotation(AVLtree avl, Node nd3) {
		nd3.left = RRrotation(avl, nd3.left);
		return LLrotation(avl, nd3);
	}
	
	public static Node RLrotation(AVLtree avl, Node nd3) {
		nd3.right = LLrotation(avl, nd3.right);
		return RRrotation(avl, nd3);
	}
	
	public static Node correct(AVLtree avl, Node cnd) {
		set(cnd);
		if(height(cnd.left) - height(cnd.right) == 2) {//L case
			if(height(cnd.left.left) > height(cnd.left.right)) {
				cnd = LLrotation(avl, cnd);
				set(cnd.right);
				set(cnd);
			}else {
				cnd = LRrotation(avl, cnd);
				set(cnd.left);
				set(cnd.right);
				set(cnd);
			}
		}else if(height(cnd.right) - height(cnd.left) == 2) {//R case
			if(height(cnd.right.right) > height(cnd.right.left)) {
				cnd = RRrotation(avl, cnd);
				set(cnd.left);
				set(cnd);
			}else {
				cnd = RLrotation(avl, cnd);
				set(cnd.left);
				set(cnd.right);
				set(cnd);
			}
		}
		if(cnd == avl.root) return cnd;
		else return correct(avl, cnd.father);
	}
	//Rotation
	public static void insert(AVLtree avl, int value) {
		Node cnd;
		if(avl.isEmpty == true) {
			avl.root = new Node();
			avl.root.value = value;
			cnd = avl.root;
			avl.isEmpty = false;
		}else {
			cnd = search(avl, value);
			if(value > cnd.value) {//插在右
				cnd.right = new Node();
				cnd.right.value = value;
				cnd.right.father = cnd;
				cnd = cnd.right;
			}else {//插在左
				cnd.left = new Node();
				cnd.left.value = value;
				cnd.left.father = cnd;
				cnd = cnd.left;
			}
		}
		correct(avl, cnd);
	}
	
	public static void remove(AVLtree avl, Node cnd) {//按节点删除
		if(cnd.left==null && cnd.right==null) {//叶节点直接删
			if(cnd == avl.root) {
				avl.root = null;
				avl.isEmpty = true;
				cnd = null;
			}else if(cnd.father.value > cnd.value) {
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
			if(max.value > max.father.value) {
				max.father.right = max.left;
			}else max.father.left = max.left;
			
			cnd.value = max.value;
			cnd = max.father;
			max.father = null;
			max.left = null;
		}else {
			Node min = findkth(cnd.right, 1);
			
			if(min.right != null) min.right.father = min.father;
			if(min.value > min.father.value) {
				min.father.right = min.right;
			}else min.father.left = min.right;
			
			cnd.value = min.value;
			cnd = min.father;
			min.father = null;
			min.right = null;
		}
		if(cnd != null) correct(avl, cnd);
	}
	
	public static Node closest(AVLtree avl, int num) {
		Node cnd = avl.root, low, high;
		//int min;
		while(true) {
			if(num>cnd.value && cnd.right!=null) {
				if(num < cnd.right.value) {
					low = cnd;
					high = findkth(cnd.right, 1);
					if(Math.abs(high.value-num) < Math.abs(low.value-num)) {
						cnd = high;
					}else cnd = low;
					break;
				}else cnd = cnd.right;
			}else if(num<cnd.value && cnd.left!=null) {
				if(num > cnd.left.value) {
					high = cnd;
					low = findkth(cnd.left, cnd.left.treesize);
					if(Math.abs(high.value-num) < Math.abs(low.value-num)) {
						cnd = high;
					}else cnd = low;
					break;
				}else cnd = cnd.left;
			}else break;
		}
		return cnd;
	}
	
	public static void check(AVLtree avl) {
		ArrayList<Node> a=new ArrayList<>();
		if(avl.root!=null) a.add(avl.root);
		int j=0;
		while(j<a.size()) {
			System.out.print(a.get(j).value+" father:");
			if(a.get(j).father!=null) {
				System.out.print(a.get(j).father.value+"; 左:");
			}else System.out.print("null; 左:");
			if(a.get(j).left!=null) {
				a.add(a.get(j).left);
				System.out.print(a.get(j).left.value+"; 右:");
			}else System.out.print("null; 右:");
			if(a.get(j).right!=null) {
				a.add(a.get(j).right);
				System.out.print(a.get(j).right.value+"; h:");
			}
			else System.out.print("null; h:");
			
			System.out.println(a.get(j).height+"; size:"+a.get(j).treesize);
			j++;
		}
		System.out.println("================================================");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node mated;
		AVLtree tree1 = new AVLtree();
		int[] arr = {2,4};
		for(int i=0;i<arr.length;i++) {
			insert(tree1, arr[i]);
		}
		check(tree1);
		mated = closest(tree1, 3);
		System.out.println(mated.value);
		remove(tree1, mated);
		check(tree1);
 
	}

}
