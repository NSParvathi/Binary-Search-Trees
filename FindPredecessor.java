package binarySearchTrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem Statement: Given a BST with root node with key part as an integer only. You need to find the in-order predecessor of a given key. 
 * If predecessor is not found, then return -1.
 *  predecessor means the node which is immediate before to the node with given key. That means the node which has largest value that is
 *  smaller than the given key
 * There are 3 ways to find in order predecessor of a given tree.
 * 1. Do in order traversal of the BST and store the values in some data structure and do either linear search or binary search to 
 *  find predecessor of given value.
 *  	Time Complexity = O(N) + O(N) = O(N)
 *  	Space Complexity = O(N).
 *  
 *  2. Don't store the values in some data structure. Instead of that while doing in order traversal always sore previous node details.
 *  	if you encounter a node with given key then return previous node that is the predecessor of given key.
 *  	Time complexity  = O(N)
 *  	Space Complexity = O(1)
 *  
 *  3. a. Traverse the tree either left or right depends on the node value. 
 *     b. Take a variable named predecessor and assign it to -1.
 *     c. Compare key with node value if the key is greater than the node value then node can be the predecessor, assign predecessor = node value and 
 *   	then goto the right of the node as you might get the node whose value is immediate less than key and greater than the current predecessor.
 *     d. if the key is less then the node then you have to traverse to the left of the node as it cannot be the predecessor.
 *     e. if the key is equal to the node then also you have to traverse to left as we need to get node less than the key.
 *     e. Repeat steps c and d until you encounter null.
 *     
 *     	 Time Complexity : O(H)
 *     	
 */
public class FindPredecessor {

//Using Data structure to store in order traversal 
	
    public static void findPre(Node root, int key)
    {
      
    	List<Integer> inOrder = new ArrayList<>();
    	Deque<Node> stack = new LinkedList<>();
    	//InOrder Traversal code
    	Node node = root;
    	while(true) {
    		while(node!= null) {
    			stack.push(node);
    			node = node.left;
    		}
    		if(node == null) {
    			node = stack.pop();
    			inOrder.add(node.data);
    			node = node.right;
    		}
    		
    		if(node== null && stack.isEmpty())
    			break;
    		
    	}
    	
    	//Doing Linear search to find the predecessor of the given key. You can use binary search also as the in order traversal of
    	// BST returns sorted order the elements.
    	for(int i=0;i<inOrder.size();i++) {
    		if(inOrder.get(i) == key) {
    			if(i>0)
    				System.out.println(inOrder.get(i-1));
    			else
    				System.out.println("null");
    		}
    	}
    	
    }
    
    
    /*
     * In this method I am not going to use any data structure to store the elements.Instead of that while doing in order traversal 
     * if you encounter a key value returning previous value as a predecessor.
     * 
     * or you can do reverse in order traversal. means Right Root Left.
     * Start from right of the root and go deep into the right and insert into stack. if you encounter null pop the element and go left and 
     * then deep right. If you follow this approach you will get elements in descending order.
     */
    
    public static Node findPredecessor(Node root, int key) {
    	
    	//Inorder traversal code
    	Deque<Node> stack = new LinkedList<>();
    	
    	Node node = root;
    	Node prevNode = null;
    	while(true) {
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		if(node == null) {
    			node = stack.pop();
    			if(node.data == key)
    				return prevNode;
    			prevNode = node;
    			node = node.right;
    		}
    		if(node == null && stack.isEmpty())
    			return null;
    		
    	}
    }
    
    /*
     * Method - 3
     * Travelling either left or right depends on node value
     */
    public static int findPredecessor_Optimised(Node root,int key) {
    	
    	int predecessor = -1;
    	
    	Node node = root;
    	while(node!= null) {
    		if(node.data == key) { // go right
    			node = node.left;
    		} else if(node.data <key){
    			predecessor = node.data;
    			node = node.right;
    			
    		} else {
    			node = node.left;
    		}
    	}
    	
    	return predecessor;
    }
    
    public static void main(String args[]) {
    	Node root = new Node(6);
    	root.left = new Node(4);
    	root.left.left = new Node(2);
    	root.left.right = new Node(5);
    	root.right = new Node(9);
    	root.right.left = new Node(7);
    	root.right.right = new Node(11);
    	
    	findPre(root,11);
    	System.out.println(findPredecessor(root,11));
    	System.out.println(findPredecessor_Optimised(root,2));
    }
}
