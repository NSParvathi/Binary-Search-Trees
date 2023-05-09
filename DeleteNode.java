package binarySearchTrees;

public class DeleteNode {

	public static Node deleteNode(Node root, int x) {
		
		if(root == null)
			return null;
		
		//Search for the node with value x
		Node temp = root;
		if(root.data == x) {
			return helper(root);
		}
		while(root != null) {
			if(x < root.data) {
				if(root.left != null && root.left.data == x) {
					root.left = helper(root.left);
					break;
				}else
					root = root.left;
			} else
				if(root.right!=null && root.right.data == x) {
					root.right = helper(root.right);
					break;
				} else
					root = root.right;
		}
		
		return temp;
	}
	
	public static Node helper(Node root) {
		if(root.left == null)
			return root.right;
		if(root.right == null)
			return root.left;
		Node rightChild = root.right;
		Node lastRight = findLastRight(root.left);
		lastRight.right = rightChild;
		return root.left;
	}
	
	public static Node findLastRight(Node root) {
		if(root.right == null)
			return root;
		return findLastRight(root.right);
		
	}
	
	public static void main(String args[]) {
		Node root = new Node(12);
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(18);
		
		root = deleteNode(root,12);
		System.out.println(root);
		System.out.println(root.left);
		System.out.println(root.right);
		System.out.println(root.right.left);
		System.out.println(root.right.right);
		System.out.println(root.left.left);
		System.out.println(root.left.right);
		System.out.println(root.right.right.left);
		System.out.println(root.right.right.right);
		
		
	}
}
