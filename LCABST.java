package binarySearchTrees;
/**
 * Given a Binary Search Tree (with all values unique) and two node values. Find the Lowest Common Ancestors of the two nodes in the BST.
 */
public class LCABST {

	/**
	 * Below are the steps to be followed.
	 * 1. Start from the root of the tree check weather the n1 and n2 lies on the same side of the root or different side.
	 * 2. if n1<root.data and n2<root.data then both are on same path so go left otherwise check n1,n2>root.data if yes then go right of the root
	 * 3. if both are on different sides then that is the LCA of n1 and n2 as both are going on different paths and there wont be any 
	 *    common root further.
	 * 
	 */
	public static Node LCA(Node root, int n1, int n2)
	{
        // code here.  
		if(n1<root.data && n2<root.data)
			return LCA(root.left,n1,n2);
		else if(n1>root.data && n2>root.data)
			return LCA(root.right,n1,n2);
		else
			return root;
    }
	
	public static void main(String args[]) {
		Node root = new Node(16);
		root.left = new Node(10);
		root.right = new Node(24);
		root.left.left = new Node(7);
		root.left.right = new Node(13);
		
		System.out.println(LCA(root,7,13));
	}
}
