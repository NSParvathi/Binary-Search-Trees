package binarySearchTrees;
/**
 * 
 * Problem Statement: Given a binary tree. Find the size of its largest subtree that is a Binary Search Tree.
 * 
 * Solution : 
 * 
 * Intuition: 
 * 	For particular node if you get largest node among all the nodes on its left side and the smallest node among all the nodes on the right side 
 *  and if you say largest< node.val <smallest then add 1+MAX(left count,right count) and carry the largest and smallest.
 * 
 * Approach:
 *  
 *  create a container to store largest,smallest and count.
 *  
 *	I am going to solve using post order traversal as we have to check first whether left and right sub tree follows BST rules that means
 *	first we have to compute left and then right and then root.
 *	 
 *	During the traversal we will go deep left and then backtrack. while coming back attach each node the value of no of nodes till that node
 *	which satisfies BST and left side largest and right side smallest.
 *  then compare largest< node.val<smallest 
 *  if yes then add 1 to the count and send to the root with new largest and smallest.
 *  if not make new largest as Interger.MAX_VALUE and new smallest as Interger_MIN_VALUE as it is no more BST and send max(left_count,right_count) 
 *  to the parent node, keep on repeat until you reach root of the tree.
 */
public class LargestBST {

	static class NodeVal{
		public int largest,smallest,count;
		NodeVal(int largest,int smallest,int count){
			this.largest = largest;
			this.smallest = smallest;
			this.count = count;
		}
	}
	public static NodeVal largestBST(Node root) {
		
		if(root == null) {
			return new NodeVal(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
		}
		
		NodeVal left = largestBST(root.left);
		NodeVal right = largestBST(root.right);
		
		if(left.largest < root.data && root.data < right.smallest) {
			return new NodeVal(root.data,root.data,Math.max(left.count,right.count)+1); // right.data is new largest among left and new smallest
			// among right as it is smaller than the right smallest and larger than the left largest
		}
		return new NodeVal(Integer.MAX_VALUE,Integer.MIN_VALUE,Math.max(left.count,right.count));
	}
	
	public static void main(String args[]) {
		
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(8);
		root.right = new Node(15);
		root.right.right = new Node(17);
		NodeVal result = largestBST(root);
		System.out.println(result.count);
	}
	
}
