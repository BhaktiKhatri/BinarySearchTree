package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

class Interval {
	public int left, right;
	
	public Interval(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

public class RangeLookup {
	
	BSTNode root;

	public static List<Integer> rangeLookupInBST(BSTNode root, Interval interval) {
		List<Integer> result = new ArrayList<>();
		rangeLookupInBSTHelper(root, interval, result);
		return result;
	}
	
	public static void rangeLookupInBSTHelper(BSTNode root, Interval interval, List<Integer> result) {
		if(root == null) 
			return;
		
		System.out.println("root: "+root.data+" interval.left: "+interval.left+" interval.right: "+interval.right+" result: "+result);
		
		if(interval.left <= root.data && root.data <= interval.right) {
			//root.data lies in the interval
			rangeLookupInBSTHelper(root.left, interval, result);
			result.add(root.data);
			rangeLookupInBSTHelper(root.right, interval, result);
		}
		else if(interval.left > root.data) {
			rangeLookupInBSTHelper(root.right, interval, result);
		}
		else {	//interval.right <= root.data
			rangeLookupInBSTHelper(root.left, interval, result);
		}
	}
	
	public static void main(String[] args) {
		RangeLookup tree = new RangeLookup();
		
		tree.root = new BSTNode(19);
		tree.root.left = new BSTNode(7);
		tree.root.left.left = new BSTNode(3);
		tree.root.left.left.left = new BSTNode(2);
		tree.root.left.left.right = new BSTNode(5);
		tree.root.left.right = new BSTNode(11);
		tree.root.left.right.right = new BSTNode(17);
		tree.root.left.right.right.left = new BSTNode(13);
		tree.root.right = new BSTNode(43);
		tree.root.right.left = new BSTNode(23);
		tree.root.right.left.right = new BSTNode(37);
		tree.root.right.left.right.left = new BSTNode(29);
		tree.root.right.left.right.right = new BSTNode(41);
		tree.root.right.left.right.left.right = new BSTNode(31);
		tree.root.right.right = new BSTNode(47);
		tree.root.right.right.right = new BSTNode(53);
		
		Interval interval = new Interval(16, 42);
		
		System.out.println(rangeLookupInBST(tree.root, interval));
		
	}

}
