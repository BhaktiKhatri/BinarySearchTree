package BinarySearchTrees;

public class FindFirstKeyGreaterThanGivenValue {
	
	BSTNode root;

	public static BSTNode findFirstGreaterThanK(BSTNode root, Integer k) {
		System.out.println("root: "+root.data+" k: "+k);
		
		BSTNode subtree = root;
		BSTNode firstSoFar = null;
		
		while(subtree != null) {
			System.out.println("subtree: "+subtree.data+" k: "+k);
		
			if(subtree.data > k) {
				if(subtree.left != null)
					System.out.println("subtree.left: "+subtree.left.data);
				else
					System.out.println("subtree.left: "+subtree.left);
				
				firstSoFar = subtree;
				subtree = subtree.left;
				
				if(firstSoFar != null && subtree != null)
					System.out.println("subtree: "+subtree.data+" firstSoFar: "+firstSoFar.data);
				else
					System.out.println("subtree: "+subtree+" firstSoFar: "+firstSoFar);
			}
			else {
				if(subtree.right != null)
					System.out.println("subtree.right: "+subtree.right.data);
				else
					System.out.println("subtree.right: "+subtree.right);
			
				subtree = subtree.right;
			}
		}
		
		return firstSoFar;
	}
	
	public static void main(String[] args) {
		
		FindFirstKeyGreaterThanGivenValue tree = new FindFirstKeyGreaterThanGivenValue();
		
		/*
				   1
				 /   \
				2      3
			  /  \     / \
			 4    8    5  6
			     /    /
			    9     7
		 */
		
//		tree.root = new BSTNode(1);
//		tree.root.left = new BSTNode(2);
//		tree.root.left.right = new BSTNode(8);
//		tree.root.left.right.left = new BSTNode(9);
//		tree.root.left.left = new BSTNode(4);
//		tree.root.right = new BSTNode(3);
//		tree.root.right.left = new BSTNode(5);
//		tree.root.right.left.left = new BSTNode(7);
//		tree.root.right.right = new BSTNode(6);
		
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
		
		Integer k = 31;
		System.out.println(findFirstGreaterThanK(tree.root, k).data);
	}

}
