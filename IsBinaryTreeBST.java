package BinarySearchTrees;

public class IsBinaryTreeBST {
	
	BinaryTreeNode root;

	public static boolean isBinaryTreeBST(BinaryTreeNode root) {
		return areKeysInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean areKeysInRange(BinaryTreeNode root, Integer lower, Integer upper) {
		System.out.println("lower: "+lower+" upper: "+upper);
		if(root == null) {
			return true;
		}
		else if(Integer.compare(root.data, lower) < 0 || Integer.compare(root.data, upper) > 0) {	//eg 7 < 20 and 9 > 3 ie right || left
			System.out.println("root: "+root.data+" lower: "+lower+" upper: "+upper);
			return false;
		}
		
		return areKeysInRange(root.left, lower, root.data) && areKeysInRange(root.right, root.data, upper);
	}
	
	public static void main(String[] args) {
		IsBinaryTreeBST tree = new IsBinaryTreeBST();
		
		/*
							 3
		 				   /  \
		 				  9	   20
		                      /  \ 
		 					15    7
		 */
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(1);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(21);
		
		System.out.println(isBinaryTreeBST(tree.root));
	}

}