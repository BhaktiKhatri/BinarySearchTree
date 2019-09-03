package BinarySearchTrees;

public class FindFirstElementInDuplicateBST {
	
	BSTNode root;

	public static BSTNode findElement(BSTNode root, Integer key) {
		if(root == null)
			return root;
		else if(root.data == key)
			return root;
		
		BSTNode node = root;
		BSTNode firstSoFar = null;

		while(node != null) {
			if(node.data > key) {
				firstSoFar = node;
				node = node.left;
			}
			else if(node.data == key) {
				firstSoFar = node;
			}
			else {
				node = node.right;
			}
		}
		return firstSoFar;
	}
	
	public static void main(String[] args) {
		FindFirstElementInDuplicateBST tree = new FindFirstElementInDuplicateBST();
		
		tree.root = new BSTNode(108);
		tree.root.left = new BSTNode(108);
		tree.root.left.left = new BSTNode(-10);
		tree.root.left.left.left = new BSTNode(-14);
		tree.root.left.right = new BSTNode(108);
		tree.root.left.left.right = new BSTNode(2);
		tree.root.right = new BSTNode(285);
		tree.root.right.left = new BSTNode(243);
		tree.root.right.right = new BSTNode(285);
		tree.root.right.right.right = new BSTNode(401);
		
		Integer key = 100;
		
		System.out.println(findElement(tree.root, key).data);
	}

}
