package binarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 *
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. 
 * 							  The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * 
 * boolean hasNext()          Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * 
 * int next()                 Moves the pointer to the right, then returns the number at the pointer.
 * 
 * 
 * Solution:
 * 
 * Constructor : BSTIterator(Node root)
 * 				 In constructor we are pushing the elements into the Stack from root to deep left of the tree until you encounter null.
 * 
 * hasNext()   : Checks the stack whether it has elements are no. If the Stack is empty means we traverse all the elements of the tree
 * 
 * next()      : pop the node from the stack and traverse to the one right of the popped node and then deep left until you encounter null.
 * 				 While traversing deep left we are pushing elements into the Stack. and then return the popped node.
 * 
 */
public class BSTIterator {

	Deque<Node> stack = new LinkedList<>();
	public BSTIterator(Node root) {
		Node node = root;
		pushAll(node);
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		Node node = stack.pop();
		pushAll(node.right);
		return node.data;
	}
	
	public void pushAll(Node node) {
		while(node!=null) {
			stack.push(node);
			node = node.left;
		}
	}
	
	public static void main(String args[]) {
		Node root  = new Node(8);
		root.left = new Node(5);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(7);
		root.right.right = new Node(12);
		BSTIterator iterator  = new BSTIterator(root);
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		System.out.println(iterator.next());
		
		
	}
	
}
