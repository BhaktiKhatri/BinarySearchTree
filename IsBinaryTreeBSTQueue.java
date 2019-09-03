package BinarySearchTrees;

import java.util.LinkedList;
import java.util.Queue;

class QueueEntry {
	
	public BinaryTreeNode treeNode;
	public Integer lowerBound, upperBound;
	
	public QueueEntry(BinaryTreeNode treeNode, Integer lowerBound, Integer upperBound) {
		this.treeNode = treeNode;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
}

public class IsBinaryTreeBSTQueue {

	public static boolean isBinaryTreeBST(BinaryTreeNode root) {
		Queue<QueueEntry> BFSQueue = new LinkedList<>(); 
		BFSQueue.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		QueueEntry headEntry;
		
		while((headEntry = BFSQueue.poll()) != null) {
			if(headEntry.treeNode != null) {
				if(headEntry.treeNode.data < headEntry.lowerBound || headEntry.treeNode.data > headEntry.upperBound) {
					return false;
				}
				
				BFSQueue.add(new QueueEntry(headEntry.treeNode.left, headEntry.lowerBound, headEntry.treeNode.data));
				
				BFSQueue.add(new QueueEntry(headEntry.treeNode.right, headEntry.treeNode.data, headEntry.upperBound));
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

	}

}
