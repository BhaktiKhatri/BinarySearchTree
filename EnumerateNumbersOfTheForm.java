package BinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

class ABSqrt2 implements Comparable<ABSqrt2> {

	public int a, b;
	public double val;
	
	public ABSqrt2(int a, int b) {
		this.a = a;
		this.b = b;
		val = a + b * Math.sqrt(2);
	}
	
	@Override
	public int compareTo(ABSqrt2 arg0) {
		return Double.compare(val, arg0.val);
	}
}

public class EnumerateNumbersOfTheForm {

	public static List<ABSqrt2> generateFirstKABSqrt2(int k) {
		//Will store the first k numbers of the form a + b sqrt(2)
		List<ABSqrt2> result = new ArrayList<>();
		result.add(new ABSqrt2(0, 0));
		
		int i = 0, j = 0;
		
		for(int n=1; n<k; ++n) {
			System.out.println("i: "+i+" j: "+j+" n: "+n+" k: "+k+" result.get(i): "+result.get(i).val+" result.get(i).a: "+result.get(i).a+" result.get(i).b: "+result.get(i).b);
			
			ABSqrt2 resultIPlus1 = new ABSqrt2(result.get(i).a + 1, result.get(i).b);
			
			System.out.println("resultIPlus1: "+resultIPlus1+" result.get(j): "+result.get(j).val+" result.get(j).a: "+result.get(j).a+" result.get(j).b: "+result.get(j).b);
			
			ABSqrt2 resultJPlusSqrt2 = new ABSqrt2(result.get(j).a, result.get(j).b + 1);
			
			result.add(resultIPlus1.val < resultJPlusSqrt2.val ? resultIPlus1 :  resultJPlusSqrt2);
			
			System.out.println("resultJPlusSqrt2: "+resultJPlusSqrt2+" result: "+result);
			
			if(resultIPlus1.compareTo(result.get(result.size() - 1)) == 0) {
				++i;
			}
			
			if(resultJPlusSqrt2.compareTo(result.get(result.size() - 1)) == 0) {
				++j;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int k = 3;
		List<ABSqrt2> list = generateFirstKABSqrt2(k);
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i).val+" , ");
		}
	}

}
