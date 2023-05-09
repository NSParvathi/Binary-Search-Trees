package binarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestElement {

	/**
	 * I am traversing the Tree using iterative in order traversal. In order traversal returns sorted version of Binary search tree.
	 * If I retrieved k elements from the in order traversal i am returning so that i can return kth smallest element.
	 * @param root
	 * @param k
	 * @return
	 */
	public static int kthSamllest(Node root,int k) {
		Deque<Node> stack = new LinkedList<>();
		int count =0;
		Node node = root;
		while(true) {
			
			while(node!= null) {
				stack.push(node);
				node = node.left;
			}
			if(node == null) {
				node = stack.pop();
				count++;
				if(count == k)
					return node.data;
					
				node = node.right;
			}
			if(node == null && stack.isEmpty())
				break;
		}
		return -1;
		
	}
	
	
	public static void main(String args[]) {
		Node root = new Node(12);
		root.left = new Node(6);
		root.left.left = new Node(4);
		root.left.right = new Node(8);
		root.right = new Node(16);
		root.right.left = new Node(14);
		root.right.right = new Node(18);
		
		System.out.println(kthSamllest(root,4));
	}
}
