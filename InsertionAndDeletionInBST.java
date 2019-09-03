package BinarySearchTrees;

public class InsertionAndDeletionInBST {

	public static BinaryTreeNode root = null;
	
	public static boolean insert(Integer key) {
		if(root == null) {
			root = new BinaryTreeNode(key);
		}
		else {
			BinaryTreeNode curr = root;
			BinaryTreeNode parent = curr;
			
			while(curr != null) {
				parent = curr;
				int cmp = Integer.compare(key, curr.data);
				
				if(cmp == 0) {
					return false;	// key already present; no duplicates to be added
				}
				else if(cmp < 0) {		
					curr = curr.left;
				}
				else {					//cmp > 0
					curr = curr.right;
				}
			}
			
			//Insert key according to key and parent
			if(Integer.compare(key, parent.data) < 0) {
				parent.left = new BinaryTreeNode(key);
			}
			else {
				parent.right = new BinaryTreeNode(key);
			}
		}
		
		return true;
	}
	
	public static boolean delete(Integer key) {
		//Find the node with the key
		BinaryTreeNode curr = root;
		BinaryTreeNode parent = null;
		
		while(curr != null && Integer.compare(curr.data, key) != 0) {
			parent = curr;
			System.out.println("parent: "+parent.data+" key: "+key+" curr: "+curr.data);
			curr = Integer.compare(key, curr.data) < 0 ? curr.left : curr.right;
			System.out.println("curr: "+curr.data);
		}
		
		if(curr == null) {
			//There's no node with key in this tree
			return false;
		}
		System.out.println("curr: "+curr.data);
		
		BinaryTreeNode keyNode = curr;
		if(keyNode.right != null) {
			//Find the minimum of the right subtree
			BinaryTreeNode rKeyNode = keyNode.right;
			BinaryTreeNode rParent = keyNode;
			
			while(rKeyNode.left != null) {
				rParent = rKeyNode;
				rKeyNode = rKeyNode.left;
			}
			
			keyNode.data = rKeyNode.data;
			//Move links to erase the node
			if(rParent.left == rKeyNode) {
				rParent.left = rKeyNode.right;
			}
			else {		//Parent.left != rKeyNode
				rParent.right = rKeyNode.right;
			}
			rKeyNode.right = null;
		}
		else {
			//Update root link if needed
			if(root == keyNode) {
				root = keyNode.left;
				keyNode.left = null;
			}
			else {
				if(parent.left == keyNode) {
					parent.left = keyNode.left;
				}
				else {
					parent.right = keyNode.left;
				}
				keyNode.left = null;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		InsertionAndDeletionInBST tree = new InsertionAndDeletionInBST();
		
		tree.root = new BinaryTreeNode(19);
		tree.root.left = new BinaryTreeNode(7);
		tree.root.left.left = new BinaryTreeNode(3);
		tree.root.left.left.left = new BinaryTreeNode(2);
		tree.root.left.left.right = new BinaryTreeNode(5);
		tree.root.left.right = new BinaryTreeNode(11);
		tree.root.left.right.right = new BinaryTreeNode(17);
		tree.root.left.right.right.left = new BinaryTreeNode(13);
		tree.root.right = new BinaryTreeNode(43);
		tree.root.right.left = new BinaryTreeNode(23);
		tree.root.right.left.right = new BinaryTreeNode(37);
		tree.root.right.left.right.left = new BinaryTreeNode(29);
		tree.root.right.left.right.right = new BinaryTreeNode(41);
		tree.root.right.left.right.left.right = new BinaryTreeNode(31);
		tree.root.right.right = new BinaryTreeNode(47);
		tree.root.right.right.right = new BinaryTreeNode(53);
		
		//System.out.println(insert(9));
		
		System.out.println(delete(41));
	}

}
