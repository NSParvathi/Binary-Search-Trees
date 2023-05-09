package binarySearchTrees;

/*
 * Given a BST and a number X, find Ceil of X.
 * Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.
 */
public class FindCeil {

	static int findCeil(Node root, int key) {
		if (root == null)
			return -1;
		// Code here
		int ceil = -1;
		while (root != null) {
			if (root.data == key) { // if the root is equal to the key means we found the given key and that is the ceiling, no need to traverse
				//furthur
				ceil = root.data;
				break;
			}
			if (key < root.data) { // if the root is > key means it can be ceil but still we will traverse to the left sub tree so that 
				// we might find the number which less than the root and  is immediately greater then key
				ceil = root.data;
				root = root.left;
			} else {  // if the root is smaller than key means traverse to right sub tree so that we can find node which is greater than key
				root = root.right;
			}
		}
		return ceil;
	}

	public static void main(String args[]) {
		Node root = new Node(12);
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(18);

		System.out.println(findCeil(root, 5));
	}
}
