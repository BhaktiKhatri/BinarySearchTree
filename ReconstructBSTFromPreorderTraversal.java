package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class ReconstructBSTFromPreorderTraversal {

	public static Integer rootIdx;			//Global variable, tracks current subtree
	
	//{10, 5, 1, 7, 40, 50}
	public static BSTNode rebuildBSTFromPreorder(List<Integer> preorderSequence) {
		rootIdx = 0;
		return rebuildBSTFromPreorderOnValueRange(preorderSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	//Builds a BST on the subtree rooted at rootIdx from preorderSequence on keys in (lowerBound, upperBound)
	public static BSTNode rebuildBSTFromPreorderOnValueRange(List<Integer> preorderSequence, Integer lowerBound, Integer upperBound) {
		System.out.println("rootIdx: "+rootIdx+" preorder: "+preorderSequence+" preorder.size: "+preorderSequence.size()+" lowerBound: "+lowerBound+" upperBound: "+upperBound);
		
		if(rootIdx == preorderSequence.size()) {
			return null;
		}
		
		Integer root = preorderSequence.get(rootIdx);
		System.out.println("root: "+root);
		
		if(root < lowerBound || root > upperBound) {
			return null;
		}
		
		++rootIdx;
		System.out.println("rootIdx: "+rootIdx);
		
		//Note that rebuildBSTFromPreorderOnValueRange updates the rootIdx. So, the order of following two calls are critical
		BSTNode leftSubtree = rebuildBSTFromPreorderOnValueRange(preorderSequence, lowerBound, root);
		
		BSTNode rightSubtree = rebuildBSTFromPreorderOnValueRange(preorderSequence, root, upperBound);
		
		BSTNode node = new BSTNode(root);
		node.left = leftSubtree;
		node.right = rightSubtree;

		return node;
	}
	
	public static void main(String[] args) {
		//ReconstructBSTFromPreorderTraversal tree = new ReconstructBSTFromPreorderTraversal();
		
		/*
		 	      10
			     /  \
			    5    40
			   / \    \
			  1  7     50
		 */
		
		//{10, 5, 1, 7, 40, 50}
		List<Integer> preorder = new ArrayList<Integer>();
		preorder.add(10);
		preorder.add(5);
		preorder.add(1);
		preorder.add(7);
		preorder.add(40);
		preorder.add(50);
		
		BSTNode root = rebuildBSTFromPreorder(preorder);

		System.out.println("      "+root.data);
		System.out.println("     /"+"  \\");
		System.out.println("    "+root.left.data+"    "+root.right.data);
		System.out.println("   /"+" \\   "+" \\");
		System.out.println("  "+root.left.left.data+"  "+root.left.right.data+"     "+root.right.right.data);
	}

}
