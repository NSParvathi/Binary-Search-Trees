package binarySearchTrees;
/**
 * 
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * Solution:
 * 
 * You can solve this problem in 2 ways
 *  Method 1 :
 * 		a. Do the in order traversal of the given BST and store the result in a list.
 * 		b. Sort the list.
 * 		c. Construct the BST from the sorted list which result the correct BST.
 * 
 * 			T.C = O(N) for traversal + O(NlogN) for sorting
 *
 *  Method 2:
 *  	Find the nodes which are in wrong place. Below are the steps to be followed
 *  	a. Take 5 variables named prev, curr, first, middle and last. prev_node and curr_node are used for traversal and
 *  	   remaining 3 are to store nodes which are in wrong place.
 *  	b. Do in order traversal of the BST and compare previous node with the current node
 *  	c. if prev node< curr node then proceed else store prev node in first and curr node in second variables.
 *  	d. continue this process until you find another node which is incorrect or end of the BST.
 *  	e. If you find another node then store it in last and swap first and last.
 *  	f. If you don't find another node and first and middle are in wrong order so swap them.
 *  
 *  	For in order traversal you can do either recursive or iterative traversal. Here i am going to do using recursive appraoch
 */
public class RecoverBST {
	
	private Node prev;
	private Node first;
	private Node middle;
	private Node last;
	
	public void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		
		if(prev!=null && prev.data>root.data) {
			
			if(first == null) {
				first = prev;
				middle = root;
			}else
				last = root;
		}
		prev = root;
		
		inOrder(root.right);
	}
	public void recoverTree(Node root) {
		
		first = middle = last = null;
		
		
		inOrder(root);
		if(last != null) {
			int temp = first.data;
			first.data = last.data;
			last.data = temp;
		}else
		{
			int temp = first.data;
			first.data = middle.data;
			middle.data = temp;
		}
	}
	
	public static void main(String args[]) {
		
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.right.left = new Node(2);
		new RecoverBST().recoverTree(root);
		System.out.println(root);
		System.out.println(root.left);
		System.out.println(root.right);
		System.out.println(root.right.left);
	}
}
