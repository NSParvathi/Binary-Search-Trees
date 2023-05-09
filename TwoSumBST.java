package binarySearchTrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem Statement : 
 * Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 
 * 
 * Solution :
 * 
 * We can solve this problem in 2 ways
 * 1.  Do in order traversal of given tree and store it in an array or arraylist. and Implement 2 pointer approach of TwoSum array problem.
 * 		Anyway in order traversal returns sorted form of the BST.
 * 
 * 2.  Implement 2 iterators to traverse the Tree from front and back side. Let's say i = front() and j = back() and if i+j<given sum then move
 * i to next pointer as BST is in ascending order, moving front will increase the sum else move j to the backward to reduce the sum.
 * 		The Iterator to traverse forward direction is using In order traversal
 * 		The iterator for reverse direction uses reverse in order traversal which is right root left
 * 
 */

// BSTIterator to traverse from both from both the ends. 
// We set reverse indicator to indicate from front or back traversal. In every function we check the indicator if reverse is yes means
// traverse from back so insert left node and then go deep right or else travers from front means insert right node and traverse deep left
class BSTIteratorBoth{
	
	Deque<Node> stack = new LinkedList<>();
	boolean reverse ;
	BSTIteratorBoth(Node root,boolean reverse){
		this.reverse = reverse;
		pushAll(root);
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		Node node = stack.pop();
		
		if(!reverse)
		pushAll(node.right);
		else
			pushAll(node.left);
		return node.data;
		
	}
	
	public void pushAll(Node node) {
		while(node!=null) {
			stack.push(node);
			if(!reverse)
				node= node.left;
			else
				node = node.right;
		}
	}
}
public class TwoSumBST {

	//method 1
	public static boolean isPairPresent(Node root,int target) {
		//Doing inorder traversal and getting the list
		
		Deque<Node> stack = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		Node node = root;
		while(true) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			if(node == null) {
				node = stack.pop();
				list.add(node.data);
				node = node.right;
			}
			
			if(node == null && stack.isEmpty()) {
				break;
			}
			
		}
		
		//Follow two pointer approach to get the pair which is equal to sum
		int i=0,j=list.size()-1;
		while(i<j) {
			int sum = list.get(i)+list.get(j);
			if(sum < target) {
				i++;
			}else if(sum>target)
				j--;
			else {
				return true;
			}
		}
		
		return false;
	}
	
	//method 2
	public static boolean isPairPresent_Optimised(Node root,int target) {
		
		BSTIteratorBoth front = new BSTIteratorBoth(root,false);
		BSTIteratorBoth back = new BSTIteratorBoth(root,true);
		int i = front.next();
		int j = back.next();//name is next but returns from back, using reverse variable we are setting two pointers front and back.
		
		
		
		
		while(true) {
			
			if(i==j)
				return false;
			if(i+j == target)
				return true;
			if(i+j <target) {
				i = front.next();
			} else
				j = back.next();
		}
	}
	
	public static void main(String args[]) {
		
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		System.out.println(isPairPresent_Optimised(root,15));
	}
}
