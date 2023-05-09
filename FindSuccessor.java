package binarySearchTrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem Statement: Given a BST with root node with key part as an integer only. You need to find the in-order successor of a given key. 
 * If successor is not found, then return -1.
 *  Successor means the node which is immediate next to the node with given value. That means the node which has least value that is
 *  greater than the given key
 * There are 3 ways to find in order successor of a given tree.
 * 1. Do in order traversal of the BST and store the values in some data structure and do either linear search or binary search to 
 *  find successor of given value.
 *  	Time Complexity = O(N) + O(N) = O(N)
 *  	Space Complexity = O(N).
 *  
 *  2. Don't store the values in some data structure. Instead of that while doing in order traversal if you encounter a node whose value is 
 *  greater than given key then that is the in order successor of given node.
 *  	Time complexity  = O(N)
 *  	Space Complexity = O(1)
 *  
 *  3. a. Traverse the tree either left or right depends on the node value. 
 *     b. Take a variable named successor and assign it to null.
 *     c. Compare key with node value if the key is less than the node value then node can be the successor, assign successor = node value and 
 *   	then goto the left of the node as you might get the node whose value is immediate greater than key and less then the current successor.
 *     d. if the key is greater then the node then you have to traverse to the right of the node as it cannot be the successor.
 *     e. if the key is equal to the node then also you have to traverse to right as we need to get node greater than the key.
 *     e. Repeat steps c and d until you encounter null.
 *     
 *     	 Time Complexity : O(H)
 *     	
 *   
 */ 
public class FindSuccessor {


	//Using Data structure to store in order traversal 
	
    public static void findPre(Node root, int key)
    {
       // add your code here
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
    	
    	//Doing Linear search to find the successor of the given key. You can use binary search also as the in order traversal of
    	// BST returns sorted order the elements.
    	for(int i=0;i<inOrder.size();i++) {
    		if(inOrder.get(i) == key) {
    			if((i+1)<inOrder.size()) {
    				System.out.println(inOrder.get(i+1));
    			}else
    				System.out.println("null");
    		}
    	}
    	
    }
    
    
    /*
     * In this method I am not going to use any data structure to store the elements.Instead of that while doing in order traversal 
     * if you encounter a key value returning next value as a successor.
     */
    
    public static Node findSuccessor(Node root, int key) {
    	
    	//Inorder traversal code
    	Deque<Node> stack = new LinkedList<>();
    	boolean flag = false;
    	Node node = root;
    	while(true) {
    		while(node != null) {
    			stack.push(node);
    			node = node.left;
    		}
    		if(node == null) {
    			node = stack.pop();
    			if(flag == true)
    				return node;
    			if(node.data == key) {
    				flag  = true;
    			}
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
    public static int findSuccessor_Optimised(Node root,int key) {
    	
    	int successor = -1;
    	
    	Node node = root;
    	while(node!= null) {
    		if(node.data == key) { // go right
    			node = node.right;
    		} else if(node.data >key){
    			successor = node.data;
    			node = node.left;
    			
    		} else {
    			node = node.right;
    		}
    	}
    	
    	return successor;
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
    	System.out.println(findSuccessor(root,11));
    	System.out.println(findSuccessor_Optimised(root,2));
    }
}
