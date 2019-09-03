package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

class ArrayData implements Comparable<ArrayData> {

	public int val;
	public int idx;
	
	public ArrayData(int idx, int val) {
		this.val = val;
		this.idx = idx;
	}
	
	@Override
	public int compareTo(ArrayData arg0) {
		int result = Integer.compare(val, arg0.val);
		
		if(result == 0) {
			result = Integer.compare(idx, arg0.idx);
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ArrayData)) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		ArrayData that = (ArrayData) obj;
		return this.val == that.val && this.idx == that.idx;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(val, idx);
	}
}

public class ClosestEnteriesInThreeSortedArrays {
	
	public static int findMinDistanceSortedArrays(List<List<Integer>> sortedArrays) {
		//Indices into each of the arrays
		List<Integer> heads = new ArrayList<Integer>(sortedArrays.size());
		
		for(List<Integer> arr: sortedArrays) {
			heads.add(0);
		}
		
		int result = Integer.MAX_VALUE;
		NavigableSet<ArrayData> currentHeads = new TreeSet<>();
		
		//Adds the minimum element of each array in to currentHeads
		for(int i=0; i<sortedArrays.size(); ++i) {
			currentHeads.add(new ArrayData(i, sortedArrays.get(i).get(heads.get(i))));
		}
		
		while(true) {
			result = Math.min(result, currentHeads.last().val - currentHeads.first().val);
			int idxNextMin = currentHeads.first().idx;
			//Return if some array has no remaining elements
			heads.set(idxNextMin, heads.get(idxNextMin) + 1);
			
			if(heads.get(idxNextMin) >= sortedArrays.get(idxNextMin).size()) {
				return result;
			}
			
			currentHeads.pollFirst();
			currentHeads.add(new ArrayData(idxNextMin, sortedArrays.get(idxNextMin).get(heads.get(idxNextMin))));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> array1 = new ArrayList<>();
		array1.add(5);
		array1.add(10);
		array1.add(15);
		
		List<Integer> array2 = new ArrayList<>();
		array2.add(3);
		array2.add(6);
		array2.add(9);
		array2.add(12);
		array2.add(15);
		
		List<Integer> array3 = new ArrayList<>();
		array3.add(8);
		array3.add(16);
		array3.add(24);
		
		List<List<Integer>> sortedArrays = new ArrayList<>();
		sortedArrays.add(array1);
		sortedArrays.add(array2);
		sortedArrays.add(array3);
		
		System.out.println(findMinDistanceSortedArrays(sortedArrays));
	}

}