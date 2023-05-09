package binarySearchTrees;
/*
 * Problem Statement : Insert a node in a given BST.
 * 
 * Solution: Traverse to the leaf node where new node can fit and then attach to the
 * leaf node
 */


public class InsertNode {

	public static Node insert(Node root,int x) {
		Node temp = root;
		while(root.left != null || root.right != null) {
			if(x<root.data) {
				root = root.left;
			}else
				root = root.right;
		}
		
		if(x<root.data) {
			root.left = new Node(x);
		}else
			root.right = new Node(x);
		return temp;
	}
	public static void main(String args[]) {
		 	Node root = new Node(12);
			root.left = new Node(6);
			root.left.left = new Node(4);
			root.left.right = new Node(8);
			root.right = new Node(16);
			root.right.left = new Node(14);
			root.right.right = new Node(18);
			
			root = insert(root,7);
			insert(root,20);
			System.out.println(root.right.right.right);
			System.out.println(root.left.right.left);
			
	}
}

