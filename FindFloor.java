package binarySearchTrees;

public class FindFloor {

	 public static int floor(Node root, int x) {
	        // Code here
		 	if(root == null )
		 		return -1;
		 	
		 	int floor = -1;
		 	while(root!= null) {
		 		if(root.data == x) {
		 			floor = x;
		 			break;
		 		} if(root.data<x) {
		 			floor = root.data;
		 			root = root.right;
		 		}else
		 			root = root.left;
		 	}
		 	return floor;
	    }
	 
	 public static void main(String args[]) {
		 Node root = new Node(12);
			root.left = new Node(6);
			root.left.left = new Node(4);
			root.left.right = new Node(8);
			root.right = new Node(16);
			root.right.left = new Node(14);
			root.right.right = new Node(18);
			
			System.out.println(floor(root,7));
	 }
	 
}
