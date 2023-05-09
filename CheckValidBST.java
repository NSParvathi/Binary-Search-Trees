package binarySearchTrees;
/*
 * Preoblem Statmenet:
 * Given the root of a binary tree. Check whether it is a BST or not.
 * 
 * Solution:
 * A BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
	
	Approach:
	Maintain range for each node.If the node is with in the range then move further to check for remaining nodes else return false.
	The range of root node is (Integer.MIN,Integer.MAX)
	if you move left then the range of the node would be (Integer.MIN,root.data) and if you move right range would be (root.data, Integer.MAX)
	as left side should be smaller than the root and the right side should be greater than root.
	Calculate the ranges for each node and check weather the node is with in the range.
	
 */
public class CheckValidBST {

	public static boolean validBST(Node root,int lRange,int RRange) {
	
		System.out.println(root.data+" "+lRange+" "+RRange);
		boolean l=true,r= true;
		if(lRange<root.data && root.data < RRange) {
			if(root.left != null)
			     l = validBST(root.left,lRange,root.data);
			if(root.right != null)
				 r =validBST(root.right,root.data,RRange);
			return l && r;
		}
		else 
		return false;
	}
	
	//Same functionality as above method but I have done some refactoring of the code..
	public static boolean isValidBST(Node root,int lRange,int RRange) {
		if(root == null)
			return true;
		if(root.data <= lRange || root.data >= RRange)
			return false;
		return isValidBST(root.left,lRange,root.data) && 
				isValidBST(root.right,root.data,RRange);
	}
	
	public static boolean isBST(Node root) {
		return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	public static void main(String args[]) {
		Node root = new Node(12);
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(18);
		//root.right.right.right = new Node(10);
		
		boolean valid = isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.println(valid);
	}
	
	
}
