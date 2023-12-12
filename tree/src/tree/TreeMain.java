package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import tree.Tree.Node;

class Tree {
	private Node root;

	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int val) {
			setData(val);
			left = null;
			right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
	}

	public void add(int val) {
		// create new node
		Node newNode = new Node(val);
		// if root is null, add new node to the root
		if (root == null) {
			root = newNode;
		}
		// else, if val in new node is less than root traverse to left
		else {
			Node trav = root;
			while (true) {
				if (newNode.getData() < trav.getData()) {
					if (trav.left != null)
						trav = trav.left;
					// then , if trav left if null then add new node to trav left.
					else {
						trav.left = newNode;
						break;
					}

				} else {// vice versa for adding node to the right side
					if (trav.right != null)
						trav = trav.right;
					else {
						trav.right = newNode;
						break;
					}
				}
			}

		}
		System.out.println("node added, val: " + newNode.getData());
	}

	// postOrder traversal for deleting all nodes
	public void deleteAll(Node trav) {
		if (trav == null)
			return;
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left = null;
		trav.right = null;
		trav = null;

	}

	public void deleteAll() {
		deleteAll(root);
		root = null;
	}

	public Node bfs(int val) {
		Queue<Tree.Node> q = new LinkedList<Tree.Node>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node trav = q.poll();
			if (trav.getData() == val)
				return trav;
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);

		}
		return null;
	}

	public Node dfs(int val) {
		Stack<Node> s = new Stack<Tree.Node>();
		s.push(root);
		while (!s.isEmpty()) {
			Node trav = s.pop();
			if (trav.getData() == val)
				return trav;
			if (trav.right != null)
				s.push(trav.right);
			if (trav.left != null)
				s.push(trav.left);
		}
		return null;
	}

	public Node bst(int val) {
		Node trav = root;
		while (trav != null) {
			if (trav.data == val)
				return trav;
			if (val<trav.data)
				trav = trav.left;
			else
				trav = trav.right;
			}
		return null;
	}
	
	public Node[] bstWithParent(int val) {
		Node trav = root,parent=null;
		while (trav != null) {
			if (trav.data == val)
				return new Node[] {trav,parent};
			parent=trav;
			if (val<trav.data)
				trav = trav.left;
			else
				trav = trav.right;
			}
		return new Node[] {null,null};
	}

    public void deleteNode(int val) {
    	Node trav, parent,succ;
    	Node [] bs= bstWithParent(val);
    	trav=bs[0];
    	parent=bs[1];
    	if(trav.left!=null&&trav.right!=null) {
    		succ=trav.right;
    		while(succ.left!=null) {
    			parent=succ;
    			succ=succ.left;
    		}
    		trav.data=succ.data;
    		trav=succ;//or parent.left=succ.right(put else if ten on below block)
    	}
    	if(trav.left==null) {
    		if(trav==root) {
    			root=trav.right;
    		}
    		else if (parent.left==trav) {
    			parent.left=trav.right;
    		}
    		else {
    			parent.right=trav.right;
    		}
    	}
    	else {
    		if(trav==root) {
    			root=trav.left;
    		}
    		else if (parent.left==trav) {
    			parent.left=trav.left;
    		}
    		else {
    			parent.right=trav.left;
    		}
    	}
    }
	public int height(Node trav) {
		if (trav == null)
			return -1;
		int htl = height(trav.left);
		int htr = height(trav.right);
		if (htl >= htr) {
			return htl + 1;
		} else {
			return htr + 1;
		}
	}

	public int height() {
		int max = height(root);
		return max;
	}

	public void displayPreOrderNonRec() {
		System.out.println("Pre Non rec :");
		Node trav = root;
		Stack<Tree.Node> s = new Stack<Tree.Node>();
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				System.out.print(trav.getData() + " ");
				if (trav.right != null)
					s.push(trav.right);
				trav = trav.left;
			}
			if (!s.isEmpty())
				trav = s.pop();
		}
		System.out.println();
	}

	public void displayPreorder(Node trav) {
		if (trav == null)
			return;
		System.out.print(trav.getData() + " ");
		displayPreorder(trav.left);
		displayPreorder(trav.right);

	}

	public void displayInOrderNonRec() {
		System.out.println("In Non rec :");
		Node trav = root;
		Stack<Tree.Node> s = new Stack<Tree.Node>();

		while (!s.isEmpty() || trav != null) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if (!s.isEmpty()) {
				trav = s.pop();
				System.out.print(trav.getData() + " ");
				trav = trav.right;
			}
		}
		System.out.println();
	}

	public void displayInorder(Node trav) {
		if (trav == null)
			return;
		displayInorder(trav.left);
		System.out.print(trav.getData() + " ");
		displayInorder(trav.right);
	}

	public void displayPostorder(Node trav) {
		if (trav == null)
			return;
		displayPostorder(trav.left);
		displayPostorder(trav.right);
		System.out.print(trav.getData() + " ");

	}

	public void displayPreorder() {
		Node trav = root;
		System.out.println("Pre :");
		displayPreorder(trav);
		System.out.println();

	}

	public void displayInorder() {
		Node trav = root;
		System.out.println("IN :");
		displayInorder(trav);
		System.out.println();

	}

	public void displayPostorder() {
		Node trav = root;
		System.out.println("Post :");
		displayPostorder(trav);
		System.out.println();

	}

}

public class TreeMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tree t = new Tree();
		t.add(50);
		t.add(30);
		t.add(10);
		t.add(90);
		t.add(100);
		t.add(40);
		t.add(70);
		t.add(80);
		t.add(60);
		t.add(20);
		t.displayPreorder();
		t.displayPreOrderNonRec();
		t.displayInorder();
		t.displayInOrderNonRec();
		t.displayPostorder();
//		System.out.println("height of tree is :" + t.height());
//		// t.deleteAll();
//		// t.displayPreorder();
//		// System.out.println("height of tree is :" + t.height());
//		System.out.println("enter element you want to search :");
//		int val = sc.nextInt();
//		Node temp = t.bfs(val);
//		if (temp == null) {
//			System.out.println("bfs not found");
//		} else {
//			System.out.println("bfs found :" + temp.getData());
//		}
//		temp = t.dfs(val);
//		if (temp == null) {
//			System.out.println("dfs not found");
//		} else {
//			System.out.println("bfs found :" + temp.getData());
//		}
//		temp = t.bst(val);
//		if (temp == null) {
//			System.out.println("bst not found");
//		} else {
//			System.out.println("bst found :" + temp.getData());
//		}
//		Node[] temp1 = t.bstWithParent(val);
//		if (temp1[0] == null) {
//			System.out.println("bst not found");
//		}
//		else if(temp1[1]==null) {
//			System.out.println("bst found :" + temp1[0].getData()+" parent: "+temp1[1]);
//		}
//		else {
//			System.out.println("bst found :" + temp1[0].getData()+" parent: "+temp1[1].getData());
//		}
		t.displayPreorder();
		System.out.println("enter Node to be deleted");
		int data=sc.nextInt();
		t.deleteNode(data);
		t.displayPreorder();

	}
}
