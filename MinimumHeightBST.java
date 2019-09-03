package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class MinimumHeightBST {

	public static BSTNode buildMinHeightBSTFromSortedArray(List<Integer> A) {
		return buildMinHeightBSTFromSortedSubArray(A, 0, A.size());
	}
	
	public static BSTNode buildMinHeightBSTFromSortedSubArray(List<Integer> A, int start, int end) {
		System.out.println("start: "+start+" end: "+end+" A: "+A);
		if(start >= end) 
			return null;
		
		int mid = start + ((end - start) / 2);
		System.out.println("mid: "+mid);
		
		BSTNode root = new BSTNode(A.get(mid));
		System.out.println("root: "+root.data);
		
		root.left = buildMinHeightBSTFromSortedSubArray(A, start, mid);
		root.right = buildMinHeightBSTFromSortedSubArray(A, mid + 1, end);
		
		if(root.left != null && root.right != null)
			System.out.println("root.left: "+root.left.data+" root.right: "+root.right.data);
		else
			System.out.println("root.left: "+root.left+" root.right: "+root.right);
		
		return root;
	}
	
	public static void main(String[] args) {
		List<Integer> array = new ArrayList<>();
		array.add(2);
		array.add(3);
		array.add(5);
		array.add(7);
		array.add(11);
		array.add(13);
		array.add(17);
		array.add(19);
		array.add(23);
		
		System.out.println(buildMinHeightBSTFromSortedArray(array));
		
		
		
	}

}
