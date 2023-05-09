package binarySearchTrees;

/*
 * Given a Binary Search Tree and a node value X, find if the node with value X is present in the BST or not.
 */
public class SearchNode {

	public static boolean search(Node root, int x) {
		// Your code here
		while (root != null) {
			//if you find the node with given value x return true
			if (root.data == x)
				return true;
			else if (root.data > x) { // if the give value x is less then root then move to left sub tree else to the right sub tree.
				root = root.left;
			} else
				root = root.right;
		}
		return false;
	}

	public static void main(String args[]) {
		Node root = new Node(12);
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(18);

		System.out.println(search(root, 13));
	}

}
