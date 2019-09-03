package BinarySearchTrees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Interval1 {
	public int left, right;
	
	public Interval1(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

class Practice {
	
	public static List<Integer> rangeLookupInBST(BSTNode root, Interval interval) {
		List<Integer> result = new ArrayList<>();
		rangeLookupInBSTHelper(root, interval, result);
		return result;
	}
	
	public static void rangeLookupInBSTHelper(BSTNode root, Interval interval, List<Integer> result) {
		if(root == null) {
			return;
		}
		
		if(interval.left <= root.data && root.data <= interval.right) {
			rangeLookupInBSTHelper(root.left, interval, result);
			result.add(root.data);
			rangeLookupInBSTHelper(root.right, interval, result);
		}
		else if(root.data < interval.left) {
			rangeLookupInBSTHelper(root.right, interval, result);
		}
		else {
			rangeLookupInBSTHelper(root.left, interval, result);
		}
	}
	
	public static void main(String[] args) {
		
	}

}
