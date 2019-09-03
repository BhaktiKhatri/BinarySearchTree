package BinarySearchTrees;

/**
 * Page 225
 * WAP to check if a given value is present in a BST
 * @author NisuBhakti
 * Since the program descends tree with in each step and spends O(1) time per level, the time complexity is O(h), where h is the height of the tree
 */

public class SearchKeyInBST {

	public static BSTNode searchKey(BSTNode root, int key) {
		if(root == null)
			return null;
		
		return root.data == key ? root : key < root.data ? searchKey(root.left, key) : searchKey(root.right, key);
	}
	
	public static void main(String[] args) {

	}

}
