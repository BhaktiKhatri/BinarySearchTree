package BinarySearchTrees;

public class TestIfBSTOrdered {

	BSTNode root;
	
	public static boolean pairIncludesAncestorAndDescendentOfM(BSTNode possibleAscOrDesc1, BSTNode possibleAscOrDesc2, BSTNode middle) {
		System.out.println("possibleAscOrDesc1: "+possibleAscOrDesc1.data+" possibleAscOrDesc2: "+possibleAscOrDesc2.data+" middle: "+middle.data);
		
		BSTNode search1 = possibleAscOrDesc1; 
		BSTNode search2 = possibleAscOrDesc2;
		
		System.out.println("search1: "+search1.data+" search2: "+search2.data+" middle: "+middle.data);
		
		//Perform interleaved searching from possibleAscOrDesc1 and possibleAscOrDesc2 for middle
		while(search1 != possibleAscOrDesc2 && search1 != middle && search2 != possibleAscOrDesc1 && search2 != middle && (search1 != null || search2 != null)) {
			System.out.println("search1: "+search1.data+" search2: "+search2.data+" middle: "+middle.data+" possibleAscOrDesc1: "+possibleAscOrDesc1.data+" possibleAscOrDesc2: "+possibleAscOrDesc2.data);
			if(search1 != null) {
				search1 = middle.data < search1.data ? search1.left : search1.right; 
			}
			
			if(search2 != null) {
				search2 = middle.data < search2.data ? search2.left : search2.right;
			}
		}
		
		//If both searches were unsuccessful, or we got from possibleAscOrDesc1 to possibleAscOrDesc2 without seeing middle, or from possibleAscOrDesc2
		//to possibleAscOrDesc1 without seeing middle, middle cannot lie between possibleAscOrDesc1 and possibleAscOrDesc2
		if(search1 == possibleAscOrDesc2 || search2 == possibleAscOrDesc1 || (search1 != middle && search2 != middle)) {
			return false;
		}
		
		//If we get here, we already know one of possibleAscOrDesc1 or possibleAscOrDesc2 has a path to middle. Check if middle has a path to possibleAscOrDesc1 or
		//possibleAscOrDesc2
		return search1 == middle ? searchTarget(middle, possibleAscOrDesc2) : searchTarget(middle, possibleAscOrDesc1); 
	}
	
	public static boolean searchTarget(BSTNode from, BSTNode target) {
		while(from != null && from != target) {
			from = target.data < from.data ? from.left : from.right;
		}
		
		return from == target;
	}
	
	public static void main(String[] args) {
		TestIfBSTOrdered tree = new TestIfBSTOrdered();
		
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
		
		System.out.println(pairIncludesAncestorAndDescendentOfM(tree.root, tree.root.right.left, tree.root.right));
		
	}

}
