package binarySearchTrees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sravani
 * Problem Statement :
 * 		   Given an array of integers preorder,which represents the preorder 
 * 		   traversal of a BST (i.e., binary search tree), construct the tree
 *         and return its root.
 * 
 *         Solution:
 * 
 *         There are 3 ways to construct BST from Pre order traversal. 1. For
 *         each element of the given pre Order list traverse the BST and find
 *         the place at which the new node can fit. As they are giving the pre
 *         order traversal of BST always the first element is the root of the
 *         tree. T.C = O(N*N) because for every element we have to traverse the
 *         tree. S.C = O(1)
 * 
 *         2 If we sort the give array, we will get in order traversal of the
 *         BST. We have pre order and in order traversals of the BST. so you can
 *         construct Binary Search Tree like the same way we constructed Binary
 *         tree from pre and in order traversals. T.C = O(nlogn) for sorting +
 *         O(n) for constructing S.C = O(n) for hasmap +O(n) for sorting
 *         technique = O(n)
 * 
 *         3. For each node we maintain upper bound and construct the BST based
 *         on that. T.C = O(n) S.C = O(1)
 */
public class ConstructBSTFromPreOrder {

	/*
	 * Method 1
	 */

	public static Node construct_BF(int[] pre) {
		int n = pre.length;
		Node root = new Node(pre[0]);
		for (int i = 1; i < n; i++) {
			Node node = root;
			Node newNode = new Node(pre[i]);
			while (node != null) {
				if (pre[i] < node.data) {
					if (node.left == null) {
						node.left = newNode;
						break;
					} else
						node = node.left;
				} else {
					if (node.right == null) {
						node.right = newNode;
						break;
					} else
						node = node.right;
				}
			}
		}
		return root;
	}
	
	//Method 2- using in order and pre order traversals
	public static Node construct_better(int[] pre) {
		
		int[] in = Arrays.copyOf(pre, pre.length);;
		
		Arrays.sort(in);
		
		// Now store the in order traversal elements into the Hash map
		Map<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<in.length;i++) {
			map.put(in[i],i);
		}
		
		int n = in.length;
		int m = pre.length;
		Node root = buildBST(in,0,n-1,pre,0,m-1,map);
				
		return root;
		
	}
	public static Node buildBST(int[] in,int inStart,int inEnd,int[] pre,int preStart,int preEnd,Map<Integer,Integer> map) {
		
		
		
		if(inStart>inEnd || preStart>preEnd)
			return null;
		Node root = new Node(pre[preStart]);
		int index = map.get(pre[preStart]);
		int noOfEle = index-inStart;
		
		root.left = buildBST(in,inStart,index-1,pre,preStart+1,preStart+noOfEle,map);
		root.right = buildBST(in,index+1,inEnd,pre,preStart+noOfEle+1,preEnd,map);
		
		return root;
	}
	
	
	//method3 - by maintaining upper bound for every node
	public static Node constructBST_optimal(int[] pre) {
		return construct(pre,Integer.MAX_VALUE,new int[] {0});
	}
	
	public static Node construct(int[] pre,int bound,int[] i) {
		if(i[0]==pre.length || pre[i[0]]>bound)
			return null;
		Node root = new Node(pre[i[0]++]);
		root.left = construct(pre,root.data,i);
		root.right = construct(pre,bound,i);
		 
		return root;
		
	}
	
	
	
	public static void main(String args[]) {
		
		
		int[] pre = { 8,5,1,7,10,12};
		Node root = constructBST_optimal(pre);
		
		System.out.println(root.data);
		System.out.println(root.left);
		System.out.println(root.left.left);
		System.out.println(root.left.right);
		System.out.println(root.right);
		System.out.println(root.right.right);
		System.out.println(root.right.left);
		
		
		
		
	}
}
