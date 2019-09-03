package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class KLargestElementsInBST {
	
	BSTNode root;

	public static List<Integer> findKLargestInBST(BSTNode root, int k) {
		List<Integer> kLargestElements = new ArrayList<>();
		System.out.println("root: "+root.data+" k: "+k);
		findKLargestInBSTHelper(root, k, kLargestElements);
		return kLargestElements;
	}
	
	public static void findKLargestInBSTHelper(BSTNode root, int k, List<Integer> kLargestElements) {
		
		//Perform reverse inorder traversal
		if(root != null && kLargestElements.size() < k) {
			System.out.println("root: "+root.data+" kLargestElements: "+kLargestElements+" k: "+k);
			
			findKLargestInBSTHelper(root.right, k, kLargestElements);
			System.out.println("kLargestElements: "+kLargestElements+" k: "+k);
			
			if(kLargestElements.size() < k) {
				kLargestElements.add(root.data);
				findKLargestInBSTHelper(root.left, k, kLargestElements);
			}
		}
	}
	
	public static void main(String[] args) {
		KLargestElementsInBST tree = new KLargestElementsInBST();
		
		tree.root = new BSTNode(19);
		tree.root.left = new BSTNode(7);
		tree.root.left.left = new BSTNode(3);
		tree.root.left.left.left = new BSTNode(2);
		tree.root.left.right = new BSTNode(11);
		tree.root.left.right.right = new BSTNode(17);
		tree.root.left.right.right.left = new BSTNode(13);
		tree.root.left.left.right = new BSTNode(5);
		tree.root.right = new BSTNode(43);
		tree.root.right.left = new BSTNode(23);
		tree.root.right.left.right = new BSTNode(37);
		tree.root.right.left.right.left = new BSTNode(29);
		tree.root.right.left.right.right = new BSTNode(41);
		tree.root.right.left.right.left.right = new BSTNode(31);
		tree.root.right.right = new BSTNode(47);
		tree.root.right.right.right = new BSTNode(53);
		
		int k = 5;
		
		System.out.println(findKLargestInBST(tree.root, k));
	
	}

}
